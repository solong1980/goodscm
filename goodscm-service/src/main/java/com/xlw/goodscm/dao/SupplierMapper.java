package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.pojo.CmPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier record);

	List<Supplier> pageQuery(@Param("page") CmPage<Supplier, List<?>> page);

	int selectCount(Supplier supplier);
}