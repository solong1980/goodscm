package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.GoodsUnit;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.GoodsUnitService;

@RestController
@RequestMapping("/goodsunit")
public class GoodsUnitController {
	@Autowired
	private GoodsUnitService goodsUnitService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody GoodsUnit goodsUnit) {
		goodsUnitService.add(goodsUnit);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsUnit.getId());
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		goodsUnitService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult delete(@RequestBody GoodsUnit goodsUnit) {
		goodsUnitService.update(goodsUnit);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		GoodsUnit goodsUnit = goodsUnitService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsUnit);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult selectAll() {
		List<GoodsUnit> goodsUnits = goodsUnitService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, goodsUnits);
		return cmResult;
	}

}
