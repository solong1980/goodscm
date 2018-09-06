package com.xlw.zerg.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
	private Integer id;

	private String orderNo;

	private Integer userId;

	private Integer deleteTime;

	private Integer createTime;

	private BigDecimal totalPrice;

	private Byte status;

	private String snapImg;

	private String snapName;

	private Integer totalCount;

	private Integer updateTime;

	private String snapAddress;

	private String prepayId;

	private String snapItems;

	private List<OrderProduct> products;

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getSnapImg() {
		return snapImg;
	}

	public void setSnapImg(String snapImg) {
		this.snapImg = snapImg == null ? null : snapImg.trim();
	}

	public String getSnapName() {
		return snapName;
	}

	public void setSnapName(String snapName) {
		this.snapName = snapName == null ? null : snapName.trim();
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public String getSnapAddress() {
		return snapAddress;
	}

	public void setSnapAddress(String snapAddress) {
		this.snapAddress = snapAddress == null ? null : snapAddress.trim();
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId == null ? null : prepayId.trim();
	}

	public String getSnapItems() {
		return snapItems;
	}

	public void setSnapItems(String snapItems) {
		this.snapItems = snapItems == null ? null : snapItems.trim();
	}
}