package com.xlw.goodscm.service;

import java.io.IOException;
import java.util.List;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.pojo.CmPage;

/**
 * @author longlianghua
 */
public interface GoodsService {
	List<Goods> query(Goods goods);

	Goods getById(Long id);

	Long add(Goods goods);

	void updateStatus(Goods goods);

	void deleteById(Long id);

	void addUpdatePicsGoodsId(Goods goods) throws Exception;

	void update(Goods goods) throws Exception;

	@Deprecated
	void addSavePics(Goods goods) throws IOException;

	List<Goods> pageQuery(CmPage<Goods, List<?>> goodsPageQuery);

	void fastUpdate(Goods goods);

	Goods getGoodsInfoById(Long id);
}
