package com.xlw.goodscm.service;

import java.io.IOException;
import java.util.List;

import com.xlw.goodscm.model.GoodsPic;

/**
 * @author longlianghua
 */
public interface GoodsPicService {
	List<GoodsPic> query(GoodsPic goodsPic);

	GoodsPic getById(Long id);

	void add(GoodsPic goodsPic);

	void update(GoodsPic goodsPic);

	void add(List<GoodsPic> goodsPics) throws IOException;
	
	void addBatch(List<GoodsPic> goodsPics) throws IOException;

	GoodsPic getThrumbnail(Long goodsId);
}
