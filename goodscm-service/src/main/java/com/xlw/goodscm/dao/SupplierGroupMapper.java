package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.SupplierGroup;
import java.util.List;

public interface SupplierGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SupplierGroup record);

    SupplierGroup selectByPrimaryKey(Long id);

    List<SupplierGroup> selectAll();

    int updateByPrimaryKey(SupplierGroup record);
    
    Long supplierCount(Long id);
}