package com.xlw.goodscm.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xlw.FreemarkTool;
import com.xlw.goodscm.dao.GoodsPostCartMapper;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.GoodsPostCartService;
import com.xlw.goodscm.service.GoodsService;

@Service
public class GoodsPostCartServiceImpl implements GoodsPostCartService {
	@Autowired
	private GoodsPostCartMapper goodsPostCartMapper;

	@Autowired
	private GoodsService goodsService;

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

	@Override
	public List<String> export(CmPage<GoodsPostCart, List<GoodsPostCart>> page) {
		List<GoodsPostCart> userPostGoods = goodsPostCartMapper.pageQuery(page);

		// query all goods detail
		for (GoodsPostCart goodsPostCart : userPostGoods) {
			Goods goods = goodsService.getGoodsInfoById(goodsPostCart.getGoodsId());
			// generate introduce page
			String pageContent = FreemarkTool.exportGoodsPage(goods);
			if (pageContent == null) {
				throw new RuntimeException("export page for goods id=" + goods.getId() + " error");
			} else {
				// create file
				File file = new File(goodsPostCart.getOperatorId() + "_" + goodsPostCart.getCustomerId() + "_"
						+ goodsPostCart.getGoodsId() + ".html");
				
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void mAdd(List<GoodsPostCart> goodsPostCarts) {
		for (GoodsPostCart goodsPostCart : goodsPostCarts) {
			add(goodsPostCart);
		}
	}

	@Override
	@Transactional
	public void clean(GoodsPostCart goodsPostCart) {
		goodsPostCartMapper.clean(goodsPostCart);
	}

}
