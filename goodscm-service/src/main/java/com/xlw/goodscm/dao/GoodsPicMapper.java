package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsPic;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsPicMapper {
	int deleteByPrimaryKey(Long id);

	int insert(GoodsPic record);

	GoodsPic selectByPrimaryKey(Long id);

	List<GoodsPic> selectAll();

	int updateByPrimaryKey(GoodsPic record);

	void insertGoodsPics(List<GoodsPic> goodsPics);

	GoodsPic getGoodsThumbnail(@Param("goodsId") Long goodsId);

	void updateGoodsId(GoodsPic goodsPic);

	List<GoodsPic> selectGoodsPics(@Param("goodsId") Long goodsId);
}