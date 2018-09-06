package com.xlw.zerg.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 7177209302766910079L;

	@JSONField(name = "order_id")
	private Integer orderId;

	private Boolean pass = Boolean.TRUE;
	private BigDecimal orderPrice = new BigDecimal("0");
	private List<ProductStatus> pStatusArray = new ArrayList<>(10);
	private Map<String, String> wxRespData;
	private OrderSnap orderSnap;

	public OrderStatus() {

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<ProductStatus> getpStatusArray() {
		return pStatusArray;
	}

	public void setpStatusArray(List<ProductStatus> pStatusArray) {
		this.pStatusArray = pStatusArray;
	}

	public Map<String, String> getWxRespData() {
		return wxRespData;
	}

	public void setWxRespData(Map<String, String> wxRespData) {
		this.wxRespData = wxRespData;
	}

	public OrderSnap getOrderSnap() {
		return orderSnap;
	}

	public void setOrderSnap(OrderSnap orderSnap) {
		this.orderSnap = orderSnap;
	}

}
