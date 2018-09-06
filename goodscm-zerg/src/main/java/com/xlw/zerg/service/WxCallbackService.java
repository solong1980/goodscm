package com.xlw.zerg.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.xlw.zerg.model.Order;
import com.xlw.zerg.vo.OrderStatus;
import com.xlw.zerg.wx.WxSetting;

@Service
public class WxCallbackService extends ZergService {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	/**
	 * 支付回调
	 * 
	 * @throws Exception
	 */
	public void receiveNotify(String wxResponese) throws Exception {
		Map<String, String> xmlToMap = WXPayUtil.xmlToMap(wxResponese);
		// 获取微信返回的xml数据
		// 检测库存量，超卖，更新status
		handle(xmlToMap);
		// 做一次转发，然后就可以进行断点调试了
	}

	private String handle(Map<String, String> respData) throws Exception {
		String msg = "OK";
		// 当返回false的时候，表示notify中调用NotifyCallBack回调失败获取签名校验失败，此时直接回复失败
		boolean result = notifyProcess(respData, msg);
		Map<String, String> resp = new HashMap<>();
		if (result == false) {
			resp.put("return_code", WXPayConstants.FAIL);
			resp.put("return_msg", msg);
			return WXPayUtil.mapToXml(resp);
		} else {
			// 该分支在成功回调到NotifyCallBack方法，处理完成之后流程
			resp.put("return_code", WXPayConstants.SUCCESS);
			resp.put("return_msg", "OK");
			WXPayUtil.generateSignature(resp, WxSetting.key);
			return WXPayUtil.mapToXml(resp);
		}
	}

	public void notifyConcurrency() {
	}

	// protected $data = <<<EOD
	// <xml><appid><![CDATA[wxaaf1c852597e365b]]></appid>
	// <bank_type><![CDATA[CFT]]></bank_type>
	// <cash_fee><![CDATA[1]]></cash_fee>
	// <fee_type><![CDATA[CNY]]></fee_type>
	// <is_subscribe><![CDATA[N]]></is_subscribe>
	// <mch_id><![CDATA[1392378802]]></mch_id>
	// <nonce_str><![CDATA[k66j676kzd3tqq2sr3023ogeqrg4np9z]]></nonce_str>
	// <openid><![CDATA[ojID50G-cjUsFMJ0PjgDXt9iqoOo]]></openid>
	// <out_trade_no><![CDATA[A301089188132321]]></out_trade_no>
	// <result_code><![CDATA[SUCCESS]]></result_code>
	// <return_code><![CDATA[SUCCESS]]></return_code>
	// <sign><![CDATA[944E2F9AF80204201177B91CEADD5AEC]]></sign>
	// <time_end><![CDATA[20170301030852]]></time_end>
	// <total_fee>1</total_fee>
	// <trade_type><![CDATA[JSAPI]]></trade_type>
	// <transaction_id><![CDATA[4004312001201703011727741547]]></transaction_id>
	// </xml>
	// EOD;

	// 1 检测库存量（万一超卖？怎么解决）
	// 2 更新订单status状态
	// 3 减库存
	// 4 成功 返回成功消息 ，失败 返回没有成功
	public boolean notifyProcess(Map<String, String> data, String msg) {
		// $data = $this->data;
		if ("SUCCESS".equals(data.get("result_code".intern()))) {
			// 获取订单号
			String orderNo = data.get("out_trade_no".intern());
			try {
				Order order = orderService.selectByOrderNo(orderNo);
				// status =1 为订单未处理状态
				if (order.getStatus() == (byte) 1) {
					// 判断库存量
					OrderStatus status = orderService.checkOrderStock(order.getId());
					if (status.getPass()) {
						orderService.updateOrderStatus(order.getId(), true);
						productService.reduceStock(status);
					} else {
						orderService.updateOrderStatus(order.getId(), false);
					}
				}
				return true;
			} catch (Exception ex) {
				// 如果出现异常，向微信返回false，请求重新发送通知
				return false;
			}
		}
		return true;
	}

}
