package com.xlw.goodscm.service.impl;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.GoodsCMException;
import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.dao.GoodsCategoryMapper;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.service.GoodsCategoryService;
import com.xlw.goodscm.utils.GoodsCategoryCodeGenUtil;

/**
 * @author longlianghua
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
	private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryServiceImpl.class);
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	@Override
	public List<GoodsCategory> query(GoodsCategory goodsCategory) {
		//return goodsCategoryMapper.selectAll();
		return goodsCategoryMapper.selectAllWithCount();
	}

	@Override
	public Long add(GoodsCategory goodsCategory) {
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
		return goodsCategory.getId();
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
			throw new GoodsCMException(ReturnCode.Codes.FAILURE, "need primary key / parent key");

		GoodsCategory dbCategory = goodsCategoryMapper.selectByPrimaryKey(id);
		Long dbParentId = dbCategory.getParentId();
		if (!dbParentId.equals(parentId)) {
			throw new IllegalStateException("category parent id changed");
			// String oldCodeRadical = dbCategory.getCategoryCodeRadical();
			// genCategoryCode(parentId, dbCategory);
			// String newCodeRadical = dbCategory.getCategoryCodeRadical();
			// dbCategory.setParentId(parentId);
			// goodsCategoryMapper.updateChildrenCodeRadical(goodsCategory.getId(),
			// oldCodeRadical, newCodeRadical);
		} else {
			goodsCategoryMapper.updateByPrimaryKey(goodsCategory);
		}
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

	@Override
	public void delete(Long id) {
		Integer relGoodsCount = goodsCategoryMapper.checkCategoryGoodsCount(id);
		if (relGoodsCount > 0) {
			logger.error("category id=" + id + " has related goods");
			throw new GoodsCMException(ReturnCode.Codes.RELATED_GOODS);
		}
		Integer subCategoryCount = goodsCategoryMapper.checkCategorySubCount(id);
		if (subCategoryCount > 0) {
			logger.error("category id=" + id + " has sub categorys");
			throw new GoodsCMException(ReturnCode.Codes.SUB_CATEGORIES);
		}
		goodsCategoryMapper.deleteByPrimaryKey(id);
	}

}
