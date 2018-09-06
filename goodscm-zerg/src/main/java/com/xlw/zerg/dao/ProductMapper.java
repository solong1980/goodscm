package com.xlw.zerg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xlw.zerg.model.OrderProduct;
import com.xlw.zerg.model.Product;

public interface ProductMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Product record);

	Product selectByPrimaryKey(Integer id);

	List<Product> selectAll();

	int updateByPrimaryKey(Product record);

	List<Product> selectByProductIds(@Param("products") List<OrderProduct> productsInOrder);

	int updateStock(@Param("productId") Integer productId, @Param("decCode") Integer decCount);

	List<Product> selectByCategoryIdPaginate(@Param("catId") Integer catId);
}