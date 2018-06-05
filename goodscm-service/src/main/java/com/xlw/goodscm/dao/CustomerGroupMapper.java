package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.CustomerGroup;
import java.util.List;

public interface CustomerGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerGroup record);

    CustomerGroup selectByPrimaryKey(Long id);

    List<CustomerGroup> selectAll();

    int updateByPrimaryKey(CustomerGroup record);

	Long customerCount(Long id);
}