package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.Goods;

/**
 * @author longlianghua
 */
public interface GoodsService {
	List<Goods> query(Goods goods);

	Goods getById(Long id);

	void add(Goods goods);

	void update(Goods goods);
}
