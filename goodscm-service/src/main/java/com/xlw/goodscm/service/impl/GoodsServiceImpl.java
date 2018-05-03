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
import com.xlw.goodscm.model.SupplierRecode;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.service.GoodsService;
import com.xlw.goodscm.service.SupplierRecodeService;

/**
 * @author longlianghua
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private SupplierRecodeService supplierRecodeService;

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

			List<SupplierRecode> supplierRecodes = supplierRecodeService.selectByGoodsId(id);
			goods.setSupplierRecodes(supplierRecodes);

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
		List<SupplierRecode> supplierRecodes = goods.getSupplierRecodes();
		if (supplierRecodes != null && !supplierRecodes.isEmpty()) {
			for (SupplierRecode supplierRecode : supplierRecodes) {
				// save goods supplier relation
				supplierRecode.setGoodsId(goodsId);
				supplierRecode.setCreateTime(new Date());
				supplierRecodeService.add(supplierRecode);
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

		List<SupplierRecode> supplierRecodes = goods.getSupplierRecodes();
		for (SupplierRecode supplierRecode : supplierRecodes) {
			Long id = supplierRecode.getId();
			if (id == null) {
				// do add
				supplierRecode.setGoodsId(goods.getId());
				supplierRecode.setCreateTime(new Date());
				supplierRecodeService.add(supplierRecode);
			} else {
				supplierRecodeService.update(supplierRecode);
			}
		}

		// no matter goods id ,update all recode
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		goodsPicService.updateGoodsId(goodsPics);
		for (GoodsPic goodsPic : goodsPics) {
			if (goodsPic.getIsThumbnail()) {
				goodsPicService.createThumbnail(goodsPic);
				break;
			}
		}
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
