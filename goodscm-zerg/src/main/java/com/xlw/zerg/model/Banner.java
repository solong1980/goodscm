package com.xlw.zerg.model;

import java.util.List;

public class Banner {
	private Integer id;

	private String name;

	private String description;

	private Integer deleteTime;

	private Integer updateTime;

	private List<BannerItem> items;

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
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public List<BannerItem> getItems() {
		return items;
	}

	public void setItems(List<BannerItem> items) {
		this.items = items;
	}

}