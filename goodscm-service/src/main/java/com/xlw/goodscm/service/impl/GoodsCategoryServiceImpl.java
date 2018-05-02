package com.xlw.goodscm.service.impl;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.GoodsCategoryMapper;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.service.GoodsCategoryService;
import com.xlw.goodscm.utils.GoodsCategoryCodeGenUtil;

/**
 * @author longlianghua
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	@Override
	public List<GoodsCategory> query(GoodsCategory goodsCategory) {
		return goodsCategoryMapper.selectAll();
	}

	@Override
	public void add(GoodsCategory goodsCategory) {
		/**
		 * for example parent 111 111 000 has sub code 111 111 001 , 111 111 002 then
		 * this category code is 111 111 003
		 */
		Long parentId = goodsCategory.getParentId();
		if (parentId == null) {
			throw new InvalidParameterException("need parent category id");
		}
		genCategoryCode(parentId, goodsCategory);
		goodsCategory.setCreateTime(new Date());
		goodsCategoryMapper.insert(goodsCategory);
	}

	@Override
	public GoodsCategory getById(Long id) {
		return goodsCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(GoodsCategory goodsCategory) {
		Long id = goodsCategory.getId();
		Long parentId = goodsCategory.getParentId();
		if (id == null || parentId == null)
			throw new InvalidParameterException("need primary key / parent key");

		GoodsCategory dbCategory = goodsCategoryMapper.selectByPrimaryKey(id);
		Long dbParentId = dbCategory.getParentId();
		if (!dbParentId.equals(parentId)) {
			genCategoryCode(parentId, goodsCategory);
		}
		goodsCategoryMapper.updateByPrimaryKey(goodsCategory);
	}

	/**
	 * Setup category code, across parent category code to query all sibling
	 * category,computer this new category code
	 * 
	 * @param parentId
	 *            the new parentId
	 * @param goodsCategory
	 *            updated category
	 */
	private void genCategoryCode(Long parentId, GoodsCategory goodsCategory) {
		List<String> allChildrenCodes = goodsCategoryMapper.selectSubCategoryCode(parentId);
		GoodsCategory parentCategory = goodsCategoryMapper.selectByPrimaryKey(parentId);
		String parentCategoryCode = parentCategory.getCategoryCode();
		String genCode = GoodsCategoryCodeGenUtil.genCode(parentCategoryCode, allChildrenCodes);
		goodsCategory.setCategoryCode(genCode);
	}

	@Override
	public List<GoodsCategory> querySubCategory(Long parentId) {
		return goodsCategoryMapper.selectByParentId(parentId);
	}

}
