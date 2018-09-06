package com.xlw.zerg.service;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.tools.rmi.RemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import com.xlw.goodscm.utils.JsonUtilTool;
import com.xlw.zerg.OrderStatusEnum;
import com.xlw.zerg.dao.OrderMapper;
import com.xlw.zerg.dao.OrderProductMapper;
import com.xlw.zerg.model.Order;
import com.xlw.zerg.model.OrderProduct;
import com.xlw.zerg.model.Product;
import com.xlw.zerg.model.User;
import com.xlw.zerg.vo.OrderSnap;
import com.xlw.zerg.vo.OrderStatus;
import com.xlw.zerg.vo.ProductSnap;
import com.xlw.zerg.vo.ProductStatus;
import com.xlw.zerg.vo.WxUnifiedOrder;
import com.xlw.zerg.wx.WXZergPayConfig;
import com.xlw.zerg.wx.WxSetting;

@Service
public class OrderService extends ZergService {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderProductMapper orderProductMapper;

	// 用户下单
	public OrderStatus placeOrder(@RequestHeader("token") String token, @RequestBody Order order) {

		List<OrderProduct> orderProducts = order.getProducts();

		// HttpServletRequest request = ((ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes()).getRequest();
		// String token = request.getHeader("token");
		Integer uid = getCurUserId(token);

		// 查询订单内所有商品信息
		List<Product> products = productService.selectByProductIds(orderProducts);

		// 检查库存构建订单信息
		OrderStatus orderStatus = getOrderStatus(orderProducts, products);

		if (!orderStatus.getPass()) {
			orderStatus.setOrderId(-1);
			return orderStatus;
		}

		// 开始创建订单
		OrderSnap orderSnap = snapOrder(uid, orderProducts, products);
		orderSnap = createOrderByTrans(uid, orderProducts, orderSnap);
		orderStatus.setOrderSnap(orderSnap);
		return orderStatus;
	}

	/**
	 * 订单号
	 * 
	 * @return string
	 */
	public static String makeOrderNo() {
		return "B" + System.currentTimeMillis() + new Random(System.currentTimeMillis()).nextInt(99);
	}

	private OrderSnap createOrderByTrans(Integer uid, List<OrderProduct> orderProducts, OrderSnap orderSnap) {
		// 订单号
		String orderNo = makeOrderNo();

		Order order = new Order();
		order.setOrderNo(orderNo);
		order.setUserId(uid);
		order.setTotalPrice(orderSnap.getOrderPrice());
		order.setTotalCount(orderSnap.getTotalCount());
		order.setSnapImg(orderSnap.getSnapImg());
		order.setSnapName(orderSnap.getSnapName());
		order.setSnapAddress(orderSnap.getSnapAddress());
		order.setSnapItems(JsonUtilTool.toJson(orderSnap.getpSnaps()));

		orderMapper.insert(order);

		for (int i = 0; i < orderProducts.size(); i++) {
			OrderProduct orderProduct = orderProducts.get(i);
			orderProduct.setOrderId(order.getId());
			orderProductMapper.insert(orderProduct);
		}

		orderSnap.setOrderId(order.getId());
		orderSnap.setOrderNo(order.getOrderNo());
		orderSnap.setCreateTime(System.currentTimeMillis());

		return orderSnap;
	}

	private OrderSnap snapOrder(Integer uid, List<OrderProduct> orderProducts, List<Product> products) {
		// status可以单独定义一个类
		OrderSnap orderSnap = new OrderSnap();
		orderSnap.setSnapAddress(JsonUtilTool.toJson(userService.selectByUserId(uid)));
		orderSnap.setSnapName(products.get(0).getName());
		orderSnap.setSnapImg(products.get(0).getMainImgUrl());

		if (products.size() > 1) {
			orderSnap.setSnapName(products.get(0).getName() + '等');
		} else {
			orderSnap.setSnapName(products.get(0).getName());
		}

		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			// Java 查询不保证和id列表次序一致
			for (int j = 0; j < orderProducts.size(); j++) {
				OrderProduct oProduct = orderProducts.get(j);
				if (product.getId().equals(oProduct.getProductId())) {
					ProductSnap pSnap = productService.snapProduct(product, oProduct.getCount());
					orderSnap.setOrderPrice(orderSnap.getOrderPrice().add(pSnap.getTotalPrice()));
					orderSnap.setTotalCount(orderSnap.getTotalCount() + pSnap.getCount());
					orderSnap.getpSnaps().add(pSnap);
				}
			}
		}
		return orderSnap;
	}

	private OrderStatus getOrderStatus(List<OrderProduct> orderProducts, List<Product> products) {
		OrderStatus status = new OrderStatus();

		int size = orderProducts.size();
		for (int i = 0; i < size; i++) {
			OrderProduct orderProduct = orderProducts.get(i);
			Integer productId = orderProduct.getProductId();
			Integer count = orderProduct.getCount();
			// 查询商品信息
			ProductStatus pStatus = productService.getProductStatus(productId, count, products);
			// 判断是否有库存
			if (!pStatus.getHaveStock()) {
				status.setPass(false);
			}
			status.setOrderPrice(status.getOrderPrice().add(pStatus.getTotalPrice()));
			status.getpStatusArray().add(pStatus);
		}

		return status;
	}

	/**
	 * 支付申请
	 * 
	 * @return
	 * @return array
	 */
	// 生单
	public OrderStatus preOrder(@RequestHeader String token, @RequestBody Order order) {
		Integer id = order.getId();
		checkOrderValid(token, id);
		OrderStatus status = checkOrderStock(id);
		if (!status.getPass()) {
			return status;
		}
		try {
			Map<String, String> wxRespData = makeWxPreOrder(token, order, status.getOrderPrice());
			status.setWxRespData(wxRespData);
			return status;
		} catch (Exception e) {
			throw new RemoteException(e);
		}
	}

	/**
	 * @param string
	 *            $orderNo 订单号
	 * @return array 订单商品状态
	 * @throws Exception
	 */
	public OrderStatus checkOrderStock(Integer orderId) {
		// 一定要从订单商品表中直接查询
		// 不能从商品表中查询订单商品
		// 这将导致被删除的商品无法查询出订单商品来
		List<OrderProduct> orderProducts = orderProductMapper.selectByOrderId(orderId);

		List<Product> products = productService.selectByProductIds(orderProducts);

		OrderStatus status = getOrderStatus(orderProducts, products);
		return status;
	}

	// 构建微信支付订单信息
	private Map<String, String> makeWxPreOrder(String token, Order order, BigDecimal orderPrice) throws Exception {
		if (token == null) {
			throw new InvalidParameterException("no token");
		}
		Integer uid = getCurUserId(token);
		User user = userService.getUser(uid);

		String openid = (user == null) ? null : user.getOpenid();
		if (StringUtils.isEmpty(openid)) {
			throw new InvalidParameterException("no openid");
		}

		WXPayConfig wxPayConfig = new WXZergPayConfig();
		WXPay wxOrderData = new WXPay(wxPayConfig);
		Map<String, String> unifiedOrder = wxOrderData.unifiedOrder(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put("body", "Kala商贸");
				put("out_trade_no", order.getOrderNo());
				put("trade_type", "JSAPI"); // 此处指定为JS支付
				put("total_fee", orderPrice.multiply(new BigDecimal("100")).toString());
				put("openid", openid);
				put("notify_url", "secure.pay_back_url");
			}
		});

		WxUnifiedOrder wxUnifiedOrder = new WxUnifiedOrder(unifiedOrder);
		if (!wxUnifiedOrder.isSuccess()) {
			throw new Exception("获取预支付订单失败");
		}
		// 保存到数据库，方便后期向客户端发送模板消息
		order.setPrepayId(wxUnifiedOrder.getPrepayId());
		int updateCount = orderMapper.updatePrePayIdByPrimaryKey(order);
		if (updateCount == 0) {
			// 没有更新到数据，抛出异常。
		}
		// 需要调用 生成签名
		return WXPayUtil.xmlToMap(WXPayUtil.generateSignature(unifiedOrder, WxSetting.key));
	}

	/**
	 * 安全性原则，客户端数据全部不可信，尤其涉及到钱这一字眼 订单号可能不存在，和用户不匹配，已经支付过
	 * 
	 * @return bool
	 */
	private boolean checkOrderValid(String token, Integer id) {
		Order order = orderMapper.selectByPrimaryKey(id);
		if (order == null) {
			throw new InvalidParameterException("order: id=" + id + " does not exists");
		}
		if (!isValidOperate(getCurUserId(token), order.getUserId())) {
			throw new InvalidParameterException("{msg:\"订单与用户不匹配\",errorCode:10003}");
		}
		// OrderStatusEnum::UNPAID
		if (order.getStatus() != (byte) 1) {
			throw new InvalidParameterException("{msg:\"订单已支付过啦\",errorCode:80003,code:400}");
		}
		return true;
	}

	public boolean isValidOperate(Integer curUid, Integer orderUserId) {
		if (curUid != orderUserId) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 更新订单状态 待支付 或者 库存量不足
	 * 
	 * @param orderID
	 * @param success
	 */
	public void updateOrderStatus(Integer orderId, boolean success) {
		OrderStatusEnum status = success ? OrderStatusEnum.PAID : OrderStatusEnum.PAID_BUT_OUT_OF;
		orderMapper.updateStatus(orderId, status.code());
	}

	public Order getOrderDetail(Integer id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	public Order selectByOrderNo(String orderNo) {
		return orderMapper.selectByOrderNo(orderNo);
	}

	public void orderDelivery(Order order) {
	}

	public List<Order> userOrders(String token, Integer pageNo, Integer pageCount) {
		Integer userId = getCurUserId(token);
		if (userId == null) {
			throw new InvalidParameterException("no user");
		}
		return orderMapper.selectByUserId(userId, pageNo * pageCount,pageCount);
	}

}
