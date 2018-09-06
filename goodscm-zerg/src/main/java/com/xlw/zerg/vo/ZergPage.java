package com.xlw.zerg.vo;

import java.io.Serializable;

public class ZergPage<T> implements Serializable {
	private static final long serialVersionUID = 7177209302766910079L;

	private T data;
	private Integer pageNo;

	public ZergPage(T data, Integer pageNo) {
		this.data = data;
		this.pageNo = pageNo;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}
