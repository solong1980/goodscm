package com.xlw.goodscm.service;

import java.io.IOException;
import java.util.List;

import com.xlw.goodscm.model.Goods;

/**
 * @author longlianghua
 */
public interface GoodsService {
	List<Goods> query(Goods goods);

	Goods getById(Long id);

	Long add(Goods goods);

	void update(Goods goods);

	void updateStatus(Goods goods);

	void deleteById(Long id);

	void addUpdatePicsGoodsId(Goods goods) throws IOException;

	void addSavePics(Goods goods) throws IOException;
}
