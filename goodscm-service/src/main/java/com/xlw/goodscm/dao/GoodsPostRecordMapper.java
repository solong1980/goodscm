package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsPostRecord;
import java.util.List;

public interface GoodsPostRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsPostRecord record);

    GoodsPostRecord selectByPrimaryKey(Long id);

    List<GoodsPostRecord> selectAll();

    int updateByPrimaryKey(GoodsPostRecord record);
}