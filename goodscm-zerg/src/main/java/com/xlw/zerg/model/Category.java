package com.xlw.zerg.model;

public class Category {
	private Integer id;

	private String name;

	private Integer topicImgId;

	private Integer deleteTime;

	private String description;

	private Integer updateTime;

	private Image topicImage;

	public Image getTopicImage() {
		return topicImage;
	}

	public void setTopicImage(Image topicImage) {
		this.topicImage = topicImage;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
}