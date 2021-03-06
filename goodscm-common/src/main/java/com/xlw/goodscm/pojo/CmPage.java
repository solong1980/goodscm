package com.xlw.goodscm.pojo;

import java.io.Serializable;

public class CmPage<C, R> implements Serializable {
	private static final long serialVersionUID = -2709969219830031835L;
	private Integer start = 0;
	private Integer pageNum = 1;
	private Integer count = 10;
	private Integer total = 0;

	private C c;// 条件
	
	private R t;// 结果

	public CmPage() {
		super();
	}

	public CmPage(C c) {
		super();
		this.c = c;
	}

	public CmPage(int pageNum, int count) {
		super();
		this.pageNum = pageNum;
		this.count = count;
		this.start = count * (pageNum - 1);
	}

	public Integer getStart() {
		this.start = count * (pageNum - 1);
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public R getT() {
		return t;
	}

	public void setT(R t) {
		this.t = t;
	}

}
