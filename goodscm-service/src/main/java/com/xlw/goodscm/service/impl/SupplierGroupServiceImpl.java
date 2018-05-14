package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.GoodsCMException;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.dao.SupplierGroupMapper;
import com.xlw.goodscm.model.SupplierGroup;
import com.xlw.goodscm.service.SupplierGroupService;

/**
 * @author longlianghua
 */
@Service
public class SupplierGroupServiceImpl implements SupplierGroupService {

	@Autowired
	private SupplierGroupMapper supplierGroupMapper;

	@Override
	public void add(SupplierGroup supplierGroup) {
		supplierGroup.setCreateTime(new Date());
		supplierGroupMapper.insert(supplierGroup);
	}

	@Override
	public SupplierGroup get(Long id) {
		return supplierGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(SupplierGroup supplierGroup) {
		supplierGroupMapper.updateByPrimaryKey(supplierGroup);
	}

	@Override
	public List<SupplierGroup> selectAll() {
		return supplierGroupMapper.selectAll();
	}

	@Override
	public void delete(Long id) {
		Long supplierCount = supplierGroupMapper.supplierCount(id);
		if(supplierCount>0) {
			throw new GoodsCMException(Codes.REL_SUPPLIER);
		}
		supplierGroupMapper.deleteByPrimaryKey(id);
	}

}
