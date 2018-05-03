package com.xlw.goodscm.model;

import java.util.Date;

public class GoodsCategory {
	private Long id;

	private Long parentId;

	private String categoryCode;

	private String categoryCodeRadical;// 部首

	private String name;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode == null ? null : categoryCode.trim();
		if (this.categoryCode != null) {
			this.categoryCodeRadical = categoryCode.replaceAll("000", "");
		}
	}

	public String getCategoryCodeRadical() {
		return categoryCodeRadical;
	}

	public void setCategoryCodeRadical(String categoryCodeRadical) {
		this.categoryCodeRadical = categoryCodeRadical;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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
}