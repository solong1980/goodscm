package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.SupplierRecord;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SupplierRecordMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SupplierRecord record);

	SupplierRecord selectByPrimaryKey(Long id);

	List<SupplierRecord> selectAll();

	int updateByPrimaryKey(SupplierRecord record);

	List<SupplierRecord> selectByGoodsId(@Param("goodsId") Long goodsId);
}