package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.CustomerLevelPrice;
import java.util.List;

public interface CustomerLevelPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerLevelPrice record);

    CustomerLevelPrice selectByPrimaryKey(Long id);

    List<CustomerLevelPrice> selectAll();
    
    int updateByPrimaryKey(CustomerLevelPrice record);
}