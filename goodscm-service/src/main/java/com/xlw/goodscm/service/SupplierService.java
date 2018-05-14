package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.Supplier;

/**
 * @author longlianghua
 */
public interface SupplierService {
	void add(Supplier supplier);

	Supplier get(Long id);

	void update(Supplier supplier);

	List<Supplier> selectAll();
	
	void delete(Long id);
}
