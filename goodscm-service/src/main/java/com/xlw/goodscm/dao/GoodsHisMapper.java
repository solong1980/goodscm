package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsHis;
import java.util.List;

public interface GoodsHisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsHis record);

    GoodsHis selectByPrimaryKey(Long id);

    List<GoodsHis> selectAll();

    int updateByPrimaryKey(GoodsHis record);
}