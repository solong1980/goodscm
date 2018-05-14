package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.SupplierMapper;
import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.service.SupplierService;

/**
 * @author longlianghua
 */
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public void add(Supplier supplier) {
		supplier.setCreateTime(new Date());
		supplierMapper.insert(supplier);
	}

	@Override
	public Supplier get(Long id) {
		return supplierMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Supplier supplier) {
		supplierMapper.updateByPrimaryKey(supplier);
	}

	@Override
	public List<Supplier> selectAll() {
		return supplierMapper.selectAll();
	}

	@Override
	public void delete(Long id) {
		supplierMapper.deleteByPrimaryKey(id);
	}

}
