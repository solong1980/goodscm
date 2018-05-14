package com.xlw.goodscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	@RequestMapping("/add")
	public CmResult add(@RequestBody Supplier supplier) {
		supplierService.add(supplier);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/delete/{id}")
	public CmResult delete(@PathVariable("id") Long id) {
		supplierService.delete(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/update")
	public CmResult delete(@RequestBody Supplier supplier) {
		supplierService.update(supplier);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, null);
		return cmResult;
	}

	@RequestMapping("/get/{id}")
	public CmResult get(@PathVariable("id") Long id) {
		Supplier supplier = supplierService.get(id);
		CmResult cmResult = CmResult.build(Codes.SUCCESS, supplier);
		return cmResult;
	}

	@RequestMapping("/all")
	public CmResult selectAll() {
		List<Supplier> suppliers = supplierService.selectAll();
		CmResult cmResult = CmResult.build(Codes.SUCCESS, suppliers);
		return cmResult;
	}
}
