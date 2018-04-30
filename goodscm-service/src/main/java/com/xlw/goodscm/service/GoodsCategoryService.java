package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.GoodsCategory;

/**
 * @author longlianghua
 */
public interface GoodsCategoryService {

	List<GoodsCategory> query(GoodsCategory goodsCategory);

	void add(GoodsCategory goodsCategory);

	GoodsCategory getById(Long id);

	void update(GoodsCategory goodsCategory);

	 
}
