package com.xlw.zerg.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xlw.zerg.model.Product;

public class ProductSnap implements Serializable {
	private static final long serialVersionUID = 7177209302766910079L;
	private Integer id;
	private String name;
	private String mainImgUrl;
	private Integer count;
	private BigDecimal totalPrice;
	private BigDecimal price;

	public ProductSnap(Product product, Integer decCount) {
		setId(product.getId());
		setName(product.getName());
		setMainImgUrl(product.getMainImgUrl());
		// 订单商品请求数量
		setCount(decCount);
		setTotalPrice(product.getPrice().multiply(new BigDecimal(count)));
		setPrice(product.getPrice());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMainImgUrl() {
		return mainImgUrl;
	}

	public void setMainImgUrl(String mainImgUrl) {
		this.mainImgUrl = mainImgUrl;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
