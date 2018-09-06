package com.xlw.zerg.dao;

import com.xlw.zerg.model.Order;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Order record);

	Order selectByPrimaryKey(Integer id);

	Order selectByOrderNo(String orderNo);

	List<Order> selectAll();

	int updateByPrimaryKey(Order record);

	int updatePrePayIdByPrimaryKey(Order record);

	void updateStatus(@Param("orderId") Integer orderId, @Param("status") Integer status);

	List<Order> selectByUserId(@Param("userId") Integer userId, @Param("start") Integer start, @Param("pageCount") Integer pageCount);
}