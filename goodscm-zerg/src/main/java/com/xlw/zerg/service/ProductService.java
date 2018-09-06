package com.xlw.zerg.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.zerg.dao.ProductMapper;
import com.xlw.zerg.model.OrderProduct;
import com.xlw.zerg.model.Product;
import com.xlw.zerg.vo.OrderStatus;
import com.xlw.zerg.vo.ProductSnap;
import com.xlw.zerg.vo.ProductStatus;

@Service
public class ProductService extends ZergService {
	@Autowired
	private ProductMapper productMapper;

	public List<Product> productRecent(Integer pageName) {
		return productMapper.selectAll();
	}

	public Product selectByPrimaryKey(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	public List<Product> getByCategoryPaginate(Integer catId) {
		return productMapper.selectByCategoryIdPaginate(catId);
	}

	public List<Product> getByCategory(Integer catId) {
		return productMapper.selectByCategoryIdPaginate(catId);
	}

	public void create(Product product) {
		productMapper.insert(product);
	}

	public void delete(Integer id) {
		productMapper.deleteByPrimaryKey(id);
	}

	public ProductStatus getProductStatus(Integer productId, Integer count, List<Product> orderProducts) {
		int pIndex = -1;

		for (int i = 0; i < orderProducts.size(); i++) {
			// 遍历真实商品，判断是否有该订单商品id
			if (productId.equals(orderProducts.get(i).getId())) {
				pIndex = i;
			}
		}

		if (pIndex == -1) {
			// 客户端传递的productid有可能根本不存在
			throw new InvalidParameterException("id为" + productId + "的商品不存在，订单创建失败");
		} else {
			// 有该商品，获取商品信息
			Product product = orderProducts.get(pIndex);
			ProductStatus pStatus = new ProductStatus(product, count);

			// JSONObject pStatus = new JSONObject(new HashMap<String, Object>() {
			// private static final long serialVersionUID = 1L;
			//
			// {
			// put("id", product.getId());
			// // 判断是否有库存
			// if (product.getStock() - count >= 0) {
			// // 是否有库存量
			// put("haveStock", Boolean.TRUE);
			// } else
			// put("haveStock", Boolean.FALSE);
			//
			// // 订单商品请求数量
			// put("count", count);
			// put("name", product.getName());
			// put("totalPrice", product.getPrice().multiply(new BigDecimal(count)));
			// }
			// });

			return pStatus;
		}
	}

	public ProductSnap snapProduct(Product product, Integer count) {
		return new ProductSnap(product, count);
	}

	/**
	 * 削减库存量
	 * 
	 * @param status
	 */
	public Integer reduceStock(OrderStatus status) {
		List<ProductStatus> pStatuses = status.getpStatusArray();
		int updateSuccessCount = 0;
		for (ProductStatus productStatus : pStatuses) {
			Integer productId = productStatus.getId();
			Integer decCount = productStatus.getCount();
			updateSuccessCount = updateSuccessCount + productMapper.updateStock(productId, decCount);
		}
		return updateSuccessCount;
	}

	public List<Product> selectByProductIds(List<OrderProduct> orderProducts) {
		return productMapper.selectByProductIds(orderProducts);
	}
}
