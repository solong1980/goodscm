package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.dao.SupplierMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.SupplierService;

/**
 * @author longlianghua
 */
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public void add(Supplier supplier) {
		supplier.setCreateTime(new Date());
		supplierMapper.insert(supplier);
	}

	@Override
	public Supplier get(Long id) {
		Supplier supplier = supplierMapper.selectByPrimaryKey(id);
		if (supplier != null) {
			List<Goods> supplyGoods = goodsMapper.selectSupplyGoods(id);
			supplier.setSupplierGoods(supplyGoods);
		}
		return supplier;
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

	@Override
	public List<Supplier> query(CmPage<Supplier, List<?>> page) {
		return supplierMapper.pageQuery(page);
	}

}
