package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsPostCartMapper;
import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.GoodsPostCartService;

@Service
public class GoodsPostCartServiceImpl implements GoodsPostCartService {
	@Autowired
	private GoodsPostCartMapper goodsPostCartMapper;

	@Override
	public void add(GoodsPostCart goodsPostCart) {
		goodsPostCart.setCreateTime(new Date());
		goodsPostCartMapper.insert(goodsPostCart);
	}

	@Override
	public void delete(Long id) {
		goodsPostCartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(GoodsPostCart goodsPostCart) {
		goodsPostCartMapper.updateByPrimaryKey(goodsPostCart);
	}

	@Override
	public GoodsPostCart get(Long id) {
		return goodsPostCartMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<GoodsPostCart> query(CmPage<GoodsPostCart, List<GoodsPostCart>> page) {
		return goodsPostCartMapper.pageQuery(page);
	}

	@Override
	public List<GoodsPostCart> selectAll() {
		return goodsPostCartMapper.selectAll();
	}

}
