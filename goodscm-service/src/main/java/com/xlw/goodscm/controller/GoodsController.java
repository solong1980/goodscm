package com.xlw.goodscm.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	private static Logger logger = LoggerFactory.getLogger(GoodsController.class);

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("")
	public String index() throws Exception {
		return "goods";
	}

	@ResponseBody
	// 只用同时具有user:view和user:create权限才能访问
	// @RequiresPermissions(value = { "user:view", "user:create" }, logical =
	// Logical.AND)
	@RequestMapping("/query")
	public CmResult query(Goods goods) throws Exception {
		logger.info("query " + goods);
		List<Goods> goodsList = goodsService.query(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsList);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/get")
	public CmResult get(Long id) throws Exception {
		logger.info("query goods id=" + id);
		Goods goods = goodsService.getById(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goods);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/add")
	public CmResult add(Goods goods) throws Exception {
		logger.info("add goods" + goods);
		goodsService.add(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public CmResult update(Goods goods) throws Exception {
		logger.info("update goods" + goods);
		goodsService.update(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}
}
