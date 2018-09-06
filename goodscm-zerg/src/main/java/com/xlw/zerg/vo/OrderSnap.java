package com.xlw.zerg.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderSnap implements Serializable {
	private static final long serialVersionUID = 7177209302766910079L;
	
	@JSONField(name="order_id")
	private Integer orderId;
	@JSONField(name="order_no")
	private String orderNo;
	
	private Long createTime;
	
	private Boolean pass = Boolean.TRUE;
	private BigDecimal orderPrice = new BigDecimal("0");
	private Integer totalCount = 0;
	private String snapAddress;
	private String snapName;
	private String snapImg;

	private List<ProductSnap> pSnaps = new ArrayList<>(10);

	public OrderSnap() {

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getSnapAddress() {
		return snapAddress;
	}

	public void setSnapAddress(String snapAddress) {
		this.snapAddress = snapAddress;
	}

	public String getSnapName() {
		return snapName;
	}

	public void setSnapName(String snapName) {
		this.snapName = snapName;
	}

	public String getSnapImg() {
		return snapImg;
	}

	public void setSnapImg(String snapImg) {
		this.snapImg = snapImg;
	}

	public List<ProductSnap> getpSnaps() {
		return pSnaps;
	}

	public void setpSnaps(List<ProductSnap> pSnaps) {
		this.pSnaps = pSnaps;
	}

}
