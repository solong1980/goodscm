package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsPostCartMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteBatchByPrimaryKeys(Long[] ids);

    int insert(GoodsPostCart record);

    GoodsPostCart selectByPrimaryKey(Long id);

    List<GoodsPostCart> selectAll();

    int updateByPrimaryKey(GoodsPostCart record);

	List<GoodsPostCart> pageQuery(@Param("page") CmPage<GoodsPostCart, List<GoodsPostCart>> page);
}