package com.xlw.goodscm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsCategoryService;

@Controller
@RequestMapping("/goodscategory")
public class GoodsCategoryController {
	private static Logger logger = LoggerFactory.getLogger(GoodsCategoryController.class);

	@Autowired
	private GoodsCategoryService goodsCategoryService;

	@ResponseBody
	@RequestMapping("/query")
	public CmResult query(GoodsCategory goodsCategory) throws Exception {
		logger.info("query " + goodsCategory);
		List<GoodsCategory> categories = goodsCategoryService.query(goodsCategory);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, categories);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/get")
	public CmResult get(Long id) throws Exception {
		logger.info("get goods category id=" + id);
		GoodsCategory goodsCategory = goodsCategoryService.getById(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsCategory);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/add")
	public CmResult add(GoodsCategory goodsCategory) throws Exception {
		logger.info("add goods category" + goodsCategory);
		goodsCategoryService.add(goodsCategory);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/update")
	public CmResult update(GoodsCategory goodsCategory) throws Exception {
		logger.info("update goods category" + goodsCategory);
		goodsCategoryService.update(goodsCategory);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/delete")
	public CmResult delete(GoodsCategory goodsCategory) throws Exception {
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}
}
