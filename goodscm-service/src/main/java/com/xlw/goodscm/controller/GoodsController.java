package com.xlw.goodscm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.Consts;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsService;
import com.xlw.sys.shiro.ShiroTag;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	private static Logger logger = LoggerFactory.getLogger(GoodsController.class);

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private ShiroTag shiroTag;

	@RequestMapping("")
	public String index() throws Exception {
		return "goods";
	}

	@ResponseBody
	// 只用同时具有user:view和user:create权限才能访问
	// @RequiresPermissions(value = { "user:view", "user:create" }, logical =
	// Logical.AND)
	@RequestMapping("/query")
	public CmResult query(@RequestBody CmPage<Goods, List<?>> goodsCmPage) throws Exception {
		logger.info("query " + goodsCmPage);
		Goods c = goodsCmPage.getC();
		if (c != null) {
			String code = c.getCode();
			if (code != null)
				c.setCode(code.replaceAll("\\s+", "%"));
			
			String shortName = c.getShortName();
			if (shortName != null)
				c.setShortName(shortName.replaceAll("\\s+", "%"));
		}
		List<Goods> goodsList = goodsService.pageQuery(goodsCmPage);
		goodsCmPage.setT(goodsList);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsCmPage);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) throws Exception {
		logger.info("query goods id=" + id);
		Goods goods = goodsService.getById(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goods);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping(value = "/addupdatepics", method = RequestMethod.POST)
	public CmResult addUpdatePicsGoodsId(@RequestBody Goods goods) throws Exception {
		logger.info("addUpdatePicsGoodsId " + goods);
		if (shiroTag.isAuthority()) {
			goods.setStatus(Consts.GoodsAuditStatus.AUDIT.getCode());
		} else {
			goods.setStatus(Consts.GoodsAuditStatus.UNADUIT.getCode());
		}
		goodsService.addUpdatePicsGoodsId(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goods.getId());
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/update")
	public CmResult update(@RequestBody Goods goods) throws Exception {
		logger.info("update goods " + goods);

		/**
		 * 修改goods基本信息 修改供应商信息（如果有id update,否则insert） 图片没有修改，只有新增 除非修改了缩略图 ，在更新 goods
		 * id的时候遍历全部更新一次
		 */
		goodsService.update(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/fastupdate")
	public CmResult fastUpdate(@RequestBody Goods goods) throws Exception {
		logger.info("fast update goods " + goods);

		/**
		 * 修改goods基本信息
		 */
		goodsService.fastUpdate(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}

	/**
	 * Do audit by admin
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/audit/{id}/{status}")
	public CmResult audit(@PathVariable("id") Long id, @PathVariable("status") Short status) throws Exception {
		logger.info("update goods id=" + id + " to status=" + status);
		Goods goods = new Goods();
		goods.setId(id);
		goods.setStatus(status);
		goodsService.updateStatus(goods);
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}

	@ResponseBody
	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) throws Exception {
		logger.info("delete goods id=" + id);
		Goods goods = new Goods();
		goods.setId(id);
		goodsService.deleteById(goods.getId());
		CmResult cmResult = CmResult.build(Codes.SUCCESS);
		return cmResult;
	}
}
