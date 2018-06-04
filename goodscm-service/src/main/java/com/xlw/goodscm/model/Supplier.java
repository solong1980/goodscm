package com.xlw.goodscm.model;

import java.util.Date;
import java.util.List;

/**
 * 供应商
 * 
 * @author solon
 *
 */
public class Supplier {
	private Long id;

	private Long groupId;

	private String name;

	private String code;

	private Date createTime;

	private Date updateTime;

	private List<Goods> supplierGoods;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Goods> getSupplierGoods() {
		return supplierGoods;
	}

	public void setSupplierGoods(List<Goods> supplierGoods) {
		this.supplierGoods = supplierGoods;
	}

}