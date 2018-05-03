package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.SupplierRecode;

/**
 * @author longlianghua
 */
public interface SupplierRecodeService {

	void add(SupplierRecode supplierRecode);

	List<SupplierRecode> selectByGoodsId(Long id);

	void update(SupplierRecode supplierRecode);
	
}
