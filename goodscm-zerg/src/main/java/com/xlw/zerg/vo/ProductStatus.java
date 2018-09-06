package com.xlw.zerg.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xlw.zerg.model.Product;

public class ProductStatus implements Serializable {
	private static final long serialVersionUID = 1354404719596481439L;

	private Integer id;
	private Boolean haveStock;
	private Integer count;
	private String name;
	private BigDecimal totalPrice;

	public ProductStatus() {
		super();
	}

	public ProductStatus(Product product, Integer decCount) {
		setId(product.getId());
		// 订单商品请求数量
		setCount(decCount);
		// 判断是否有库存
		setHaveStock(product.getStock() - decCount > 0);
		setName(product.getName());
		setTotalPrice(product.getPrice().multiply(new BigDecimal(count)));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getHaveStock() {
		return haveStock;
	}

	public void setHaveStock(Boolean haveStock) {
		this.haveStock = haveStock;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
