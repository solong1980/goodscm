package com.xlw.goodscm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.SupplierRecordMapper;
import com.xlw.goodscm.model.SupplierRecord;
import com.xlw.goodscm.service.SupplierRecordService;

/**
 * @author longlianghua
 */
@Service
public class SupplierRecordServiceImpl implements SupplierRecordService {

	@Autowired
	private SupplierRecordMapper supplierRecordMapper;

	@Override
	public void add(SupplierRecord supplierRecord) {
		supplierRecordMapper.insert(supplierRecord);
	}

	@Override
	public List<SupplierRecord> selectByGoodsId(Long goodsId) {
		return supplierRecordMapper.selectByGoodsId(goodsId);
	}

	@Override
	public void update(SupplierRecord supplierRecord) {
		supplierRecordMapper.updateByPrimaryKey(supplierRecord);
	}

	@Override
	public List<SupplierRecord> batchQuery(List<Long> goodsIds) {
		if (goodsIds == null || goodsIds.isEmpty())
			return Collections.emptyList();
		return supplierRecordMapper.batchQuery(goodsIds);
	}

}
