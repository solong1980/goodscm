package com.xlw.zerg.model;

import java.util.List;

public class Theme {
	private Integer id;

	private String name;

	private String description;

	private Integer topicImgId;

	private Integer deleteTime;

	private Integer headImgId;

	private Integer updateTime;

	private Image topicImage;
	private Image headImage;

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Image getTopicImage() {
		return topicImage;
	}

	public void setTopicImage(Image topicImage) {
		this.topicImage = topicImage;
	}

	public Image getHeadImage() {
		return headImage;
	}

	public void setHeadImage(Image headImage) {
		this.headImage = headImage;
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
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getTopicImgId() {
		return topicImgId;
	}

	public void setTopicImgId(Integer topicImgId) {
		this.topicImgId = topicImgId;
	}

	public Integer getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getHeadImgId() {
		return headImgId;
	}

	public void setHeadImgId(Integer headImgId) {
		this.headImgId = headImgId;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
}