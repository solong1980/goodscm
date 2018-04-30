package com.xlw.goodscm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.service.GoodsService;

/**
 * @author longlianghua
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> query(Goods goods) {
		List<Goods> all = goodsMapper.selectAll();
		return all;
	}

	@Override
	public Goods getById(Long id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		return goods;
	}

	@Override
	public void add(Goods goods) {
		goodsMapper.insert(goods);
	}

	@Override
	public void update(Goods goods) {
		if(goods.getId()==null) {
			
		}
	}
}
