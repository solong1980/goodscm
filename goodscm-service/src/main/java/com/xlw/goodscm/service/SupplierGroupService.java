package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.SupplierGroup;

/**
 * @author longlianghua
 */
public interface SupplierGroupService {
	void add(SupplierGroup supplierGroup);

	SupplierGroup get(Long id);

	void update(SupplierGroup supplierGroup);

	List<SupplierGroup> selectAll();
	
	void delete(Long id);
}
