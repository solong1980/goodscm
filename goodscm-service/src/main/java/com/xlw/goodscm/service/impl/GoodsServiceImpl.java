package com.xlw.goodscm.service.impl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.model.SupplierRecode;
import com.xlw.goodscm.service.GoodsPicService;
import com.xlw.goodscm.service.GoodsService;

/**
 * @author longlianghua
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodsPicService goodsPicService;

	@Override
	public List<Goods> query(Goods goods) {
		List<Goods> all = goodsMapper.selectAll();
		return all;
	}

	@Override
	public Goods getById(Long id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		if (goods != null) {
			GoodsPic goodsPic = new GoodsPic();
			goodsPic.setGoodsId(id);
			List<GoodsPic> goodsPics = goodsPicService.query(goodsPic);
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

			}
		}
		return goodsId;
	}

	@Override
	public void update(Goods goods) {
		if (goods.getId() == null) {
			throw new InvalidParameterException("goods id is null");
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
	public void addUpdatePicsGoodsId(Goods goods) throws IOException {
		Long id = add(goods);
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics != null && !goodsPics.isEmpty()) {
			for (GoodsPic goodsPic : goodsPics) {
				goodsPic.setGoodsId(id);
			}
			goodsPicService.updateGoodsId(goodsPics);
			for (GoodsPic goodsPic : goodsPics) {
				if(goodsPic.getIsThumbnail()) {
					goodsPicService.createThumbnail(goodsPic);
					break;
				}
			}
		}
	}

	@Override
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
