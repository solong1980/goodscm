package com.xlw.goodscm.service.impl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsPic;
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
	public void add(Goods goods) throws IOException {
		List<GoodsPic> goodsPics = goods.getGoodsPics();
		goodsMapper.insert(goods);
		Long id = goods.getId();
		for (GoodsPic goodsPic : goodsPics) {
			goodsPic.setGoodsId(id);
		}
		if (goodsPics != null && !goodsPics.isEmpty()) {
			goodsPicService.add(goodsPics);
		}
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
}
