package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.SupplierRecode;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SupplierRecodeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SupplierRecode record);

	SupplierRecode selectByPrimaryKey(Long id);

	List<SupplierRecode> selectAll();

	int updateByPrimaryKey(SupplierRecode record);

	List<SupplierRecode> selectByGoodsId(@Param("goodsId") Long goodsId);
}