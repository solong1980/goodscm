package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;

/**
 * @author longlianghua
 */
public interface GoodsPostCartService {

	void add(GoodsPostCart goodsPostCart);

	void delete(Long id);

	void update(GoodsPostCart goodsPostCart);

	GoodsPostCart get(Long id);
	
	List<GoodsPostCart> selectAll();
	
	List<GoodsPostCart> query(CmPage<GoodsPostCart, List<GoodsPostCart>> page);

	List<String> export(CmPage<GoodsPostCart, List<GoodsPostCart>> page);
	
}
