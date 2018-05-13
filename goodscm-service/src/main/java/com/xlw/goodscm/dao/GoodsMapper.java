package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.pojo.CmPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Long id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);

	void updateStatus(Goods goods);

	List<Goods> pageQuery(@Param("page") CmPage<Goods, List<?>> goodsPageQuery);

	void fastUpdateByPrimaryKey(Goods goods);
}