package com.xlw.goodscm.dao;

import com.xlw.goodscm.model.Customer;
import com.xlw.goodscm.pojo.CmPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Customer record);

	Customer selectByPrimaryKey(Long id);

	List<Customer> selectAll();

	int updateByPrimaryKey(Customer record);

	List<Customer> pageQuery(@Param("page") CmPage<Customer, List<Customer>> page);

	int selectCount(Customer customer);
}