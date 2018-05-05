package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.SupplierRecord;

/**
 * @author longlianghua
 */
public interface SupplierRecordService {

	void add(SupplierRecord supplierRecord);

	List<SupplierRecord> selectByGoodsId(Long id);

	void update(SupplierRecord supplierRecord);

	List<SupplierRecord> batchQuery(List<Long> goodsIds);
	
}
