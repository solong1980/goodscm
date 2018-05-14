package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.SupplierGroup;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.SupplierGroupService;

@RestController
@RequestMapping("/suppliergroup")
public class SupplierGroupController {
	@Autowired
	private SupplierGroupService supplierGroupService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody SupplierGroup supplierGroup) {
		supplierGroupService.add(supplierGroup);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		supplierGroupService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult delete(@RequestBody SupplierGroup supplierGroup) {
		supplierGroupService.update(supplierGroup);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		SupplierGroup supplierGroup = supplierGroupService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplierGroup);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult selectAll() {
		List<SupplierGroup> supplierGroups = supplierGroupService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplierGroups);
		return cmResult;
	}
}
