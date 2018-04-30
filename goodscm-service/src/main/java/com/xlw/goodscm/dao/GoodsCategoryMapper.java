package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsCategory;
import java.util.List;

public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long id);

    List<GoodsCategory> selectAll();

    int updateByPrimaryKey(GoodsCategory record);

	List<String> selectChildrenCode(String parentCategoryCode);
}