package com.xlw.goodscm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.SupplierRecodeMapper;
import com.xlw.goodscm.model.SupplierRecode;
import com.xlw.goodscm.service.SupplierRecodeService;

/**
 * @author longlianghua
 */
@Service
public class SupplierRecodeServiceImpl implements SupplierRecodeService {

	@Autowired
	private SupplierRecodeMapper supplierRecodeMapper;

	@Override
	public void add(SupplierRecode supplierRecode) {
		supplierRecodeMapper.insert(supplierRecode);
	}

	@Override
	public List<SupplierRecode> selectByGoodsId(Long goodsId) {
		return supplierRecodeMapper.selectByGoodsId(goodsId);
	}

	@Override
	public void update(SupplierRecode supplierRecode) {
		supplierRecodeMapper.updateByPrimaryKey(supplierRecode);
	}

}
