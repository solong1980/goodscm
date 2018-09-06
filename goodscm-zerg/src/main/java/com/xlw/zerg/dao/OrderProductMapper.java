package com.xlw.zerg.dao;

import com.xlw.zerg.model.OrderProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductMapper {
	int deleteByPrimaryKey(@Param("productId") Integer productId, @Param("orderId") Integer orderId);

	int insert(OrderProduct record);

	List<OrderProduct> selectByOrderId(@Param("orderId") Integer orderId);

	OrderProduct selectByPrimaryKey(@Param("productId") Integer productId, @Param("orderId") Integer orderId);

	List<OrderProduct> selectAll();

	int updateByPrimaryKey(OrderProduct record);
}