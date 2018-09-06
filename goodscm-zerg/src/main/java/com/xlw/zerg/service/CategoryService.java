package com.xlw.zerg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.zerg.dao.CategoryMapper;
import com.xlw.zerg.model.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	public Category getCategory(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

	public List<Category> getAllCategories() {
		return categoryMapper.selectAll();
	}
}
