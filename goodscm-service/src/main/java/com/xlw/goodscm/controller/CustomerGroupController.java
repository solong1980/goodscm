package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.CustomerGroup;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.CustomerGroupService;

@RestController
@RequestMapping("/customergroup")
public class CustomerGroupController {
	@Autowired
	private CustomerGroupService customerGroupService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody CustomerGroup supplierGroup) {
		customerGroupService.add(supplierGroup);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplierGroup.getId());
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		customerGroupService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult delete(@RequestBody CustomerGroup supplierGroup) {
		customerGroupService.update(supplierGroup);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		CustomerGroup supplierGroup = customerGroupService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplierGroup);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult selectAll() {
		List<CustomerGroup> supplierGroups = customerGroupService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplierGroups);
		return cmResult;
	}
}
