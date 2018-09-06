package com.xlw.zerg.dao;

import com.xlw.zerg.model.ProductProperty;
import java.util.List;

public interface ProductPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductProperty record);

    ProductProperty selectByPrimaryKey(Integer id);

    List<ProductProperty> selectAll();

    int updateByPrimaryKey(ProductProperty record);
}