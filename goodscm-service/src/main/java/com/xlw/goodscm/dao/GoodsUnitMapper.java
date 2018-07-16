package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsUnit;
import java.util.List;

public interface GoodsUnitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsUnit record);

    GoodsUnit selectByPrimaryKey(Long id);

    List<GoodsUnit> selectAll();

    int updateByPrimaryKey(GoodsUnit record);
}