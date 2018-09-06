package com.xlw.zerg.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.Product;
import com.xlw.zerg.service.ProductService;

@RestController
@RequestMapping("/zerg/public/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void create(@RequestBody Product product) {
		productService.create(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product get(@PathVariable("id") Integer id) {
		return productService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}

	@RequestMapping("/recent/{pageName}")
	public List<Product> productRecent(@PathVariable("pageName") Integer pageName) {
		return productService.productRecent(pageName);
	}

	@RequestMapping(value = "/by_category", method = RequestMethod.GET)
	public List<Product> getByCategory(@RequestParam("id") Integer catId) {
		return productService.getByCategory(catId);
	}

	@RequestMapping(value = "/by_category/paginate/{catId}", method = RequestMethod.GET)
	public List<Product> getByCategoryPaginate(@PathVariable("catId") Integer catId) {
		return productService.getByCategoryPaginate(catId);
	}

}
