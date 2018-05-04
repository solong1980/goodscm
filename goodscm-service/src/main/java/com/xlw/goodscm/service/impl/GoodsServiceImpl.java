package com.xlw.goodscm.service.impl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.model.SupplierRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.service.GoodsService;
import com.xlw.goodscm.service.SupplierRecordService;

/**
 * @author longlianghua
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private SupplierRecordService supplierRecordService;

	@Autowired
	private GoodsPicService goodsPicService;

	@Override
	public List<Goods> query(Goods goods) {
		List<Goods> all = goodsMapper.selectAll();
		return all;
	}

	@Override
	public List<Goods> pageQuery(CmPage<Goods, List<?>> goodsPageQuery) {
		return goodsMapper.pageQuery(goodsPageQuery);
	}

	@Override
	public Goods getById(Long id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		if (goods != null) {
			GoodsPic goodsPic = new GoodsPic();
			goodsPic.setGoodsId(id);

			List<SupplierRecord> supplierRecords = supplierRecordService.selectByGoodsId(id);
			goods.setSupplierRecords(supplierRecords);

			List<GoodsPic> goodsPics = goodsPicService.selectGoodsPics(id);
			goods.setGoodsPics(goodsPics);
		}
		return goods;
	}

	@Override
	public Long add(Goods goods) {
		goods.setCreateTime(new Date());
		goodsMapper.insert(goods);
		Long goodsId = goods.getId();
		List<SupplierRecord> supplierRecords = goods.getSupplierRecords();
		if (supplierRecords != null && !supplierRecords.isEmpty()) {
			for (SupplierRecord supplierRecord : supplierRecords) {
				// save goods supplier relation
				supplierRecord.setGoodsId(goodsId);
				supplierRecord.setCreateTime(new Date());
				supplierRecordService.add(supplierRecord);
			}
		}
		return goodsId;
	}

	@Override
	@Transactional
	public void addUpdatePicsGoodsId(Goods goods) throws Exception {
		Long id = add(goods);
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null && !goodsPics.isEmpty()) {
			for (GoodsPic goodsPic : goodsPics) {
				goodsPic.setGoodsId(id);
			}
			goodsPicService.updateGoodsId(goodsPics);
			for (GoodsPic goodsPic : goodsPics) {
				if (goodsPic.getIsThumbnail()) {
					goodsPicService.createThumbnail(goodsPic);
					break;
				}
			}
		}
	}

	@Override
	@Transactional
	public void update(Goods goods) throws Exception {
		if (goods.getId() == null) {
			throw new InvalidParameterException("goods id is null");
		}
		goodsMapper.updateByPrimaryKey(goods);

		List<SupplierRecord> supplierRecords = goods.getSupplierRecords();
		for (SupplierRecord supplierRecord : supplierRecords) {
			Long id = supplierRecord.getId();
			if (id == null) {
				// do add
				supplierRecord.setGoodsId(goods.getId());
				supplierRecord.setCreateTime(new Date());
				supplierRecordService.add(supplierRecord);
			} else {
				supplierRecordService.update(supplierRecord);
			}
		}

		// no matter goods id ,update all record
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		for (GoodsPic goodsPic : goodsPics) {
			if (goodsPic.getIsThumbnail()) {
				goodsPicService.createThumbnail(goodsPic);
			}
			goodsPic.setGoodsId(goods.getId());
		}
		goodsPicService.updateGoodsId(goodsPics);
	}

	@Override
	public void updateStatus(Goods goods) {
		goodsMapper.updateStatus(goods);
	}

	@Override
	public void deleteById(Long id) {
		goodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Deprecated
	public void addSavePics(Goods goods) throws IOException {
		Long id = add(goods);
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null && !goodsPics.isEmpty()) {
			for (GoodsPic goodsPic : goodsPics) {
				goodsPic.setGoodsId(id);
			}
			goodsPicService.add(goodsPics);
		}
	}

}
