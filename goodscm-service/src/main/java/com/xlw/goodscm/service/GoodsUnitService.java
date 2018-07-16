package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.GoodsUnit;

/**
 * @author longlianghua
 */
public interface GoodsUnitService {
	void add(GoodsUnit goodsUnit);

	GoodsUnit get(Long id);

	void update(GoodsUnit goodsUnit);

	List<GoodsUnit> selectAll();
	
	void delete(Long id);
}
