package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.ChannelSaleRecode;
import java.util.List;

public interface ChannelSaleRecodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelSaleRecode record);

    ChannelSaleRecode selectByPrimaryKey(Long id);

    List<ChannelSaleRecode> selectAll();

    int updateByPrimaryKey(ChannelSaleRecode record);
}