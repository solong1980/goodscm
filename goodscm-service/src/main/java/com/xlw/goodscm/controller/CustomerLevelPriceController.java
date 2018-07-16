package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.CustomerLevelPrice;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.CustomerLevelPriceService;

@RestController
@RequestMapping("/customerlevelprice")
public class CustomerLevelPriceController {
	@Autowired
	private CustomerLevelPriceService customerLevelPriceService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody CustomerLevelPrice customerLevelPrice) {
		customerLevelPriceService.add(customerLevelPrice);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, customerLevelPrice.getId());
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		customerLevelPriceService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult delete(@RequestBody CustomerLevelPrice customerLevelPrice) {
		customerLevelPriceService.update(customerLevelPrice);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		CustomerLevelPrice customerLevelPrice = customerLevelPriceService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, customerLevelPrice);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult selectAll() {
		List<CustomerLevelPrice> customerLevelPrices = customerLevelPriceService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, customerLevelPrices);
		return cmResult;
	}

}
