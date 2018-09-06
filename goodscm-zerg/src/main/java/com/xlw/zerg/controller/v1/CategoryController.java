package com.xlw.zerg.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.Category;
import com.xlw.zerg.service.CategoryService;

@RestController
@RequestMapping("/zerg/public/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category getCategory(@PathVariable("id") Integer id) {
		return categoryService.getCategory(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

}
