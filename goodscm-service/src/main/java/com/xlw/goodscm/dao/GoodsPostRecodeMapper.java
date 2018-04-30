package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsPostRecode;
import java.util.List;

public interface GoodsPostRecodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsPostRecode record);

    GoodsPostRecode selectByPrimaryKey(Long id);

    List<GoodsPostRecode> selectAll();

    int updateByPrimaryKey(GoodsPostRecode record);
}