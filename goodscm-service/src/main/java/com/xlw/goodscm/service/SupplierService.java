package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.pojo.CmPage;

/**
 * @author longlianghua
 */
public interface SupplierService {
	void add(Supplier supplier);

	Supplier get(Long id);

	void update(Supplier supplier);

	List<Supplier> selectAll();
	
	void delete(Long id);

	List<Supplier> query(CmPage<Supplier, List<?>> goodsCmPage);

	void updateStatus(Long id, Short status);
}
