package com.xlw.zerg.dao;

import com.xlw.zerg.model.Product;
import com.xlw.zerg.model.ThemeProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThemeProductMapper {
    int deleteByPrimaryKey(@Param("themeId") Integer themeId, @Param("productId") Integer productId);

    int insert(ThemeProduct record);

    List<ThemeProduct> selectAll();
    
    List<Product> selectProductsByThemeId(Integer id);
}