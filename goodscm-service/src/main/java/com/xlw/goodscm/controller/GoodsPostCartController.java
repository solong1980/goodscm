package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsPostCartService;
import com.xlw.sys.shiro.ShiroUtils;

@RestController
@RequestMapping("/goodspostcart")
public class GoodsPostCartController {
	@Autowired
	private GoodsPostCartService goodsPostCartService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody GoodsPostCart goodsPostCart) {
		Long userId = ShiroUtils.getUserId();
		goodsPostCart.setOperatorId(userId);
		goodsPostCartService.add(goodsPostCart);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsPostCart.getId());
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		goodsPostCartService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult update(@RequestBody GoodsPostCart goodsPostCart) {
		goodsPostCartService.update(goodsPostCart);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		GoodsPostCart goodsPostCart = goodsPostCartService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsPostCart);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult all() {
		List<GoodsPostCart> goodsPostCarts = goodsPostCartService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsPostCarts);
		return cmResult;
	}
	
	@RequestMapping("/query")
	public CmResult query(@RequestBody CmPage<GoodsPostCart, List<GoodsPostCart>> page) {
		List<GoodsPostCart> goodsPostCarts = goodsPostCartService.query(page);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsPostCarts);
		return cmResult;
	}
}
