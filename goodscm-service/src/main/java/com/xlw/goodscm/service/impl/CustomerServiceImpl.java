package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.CustomerMapper;
import com.xlw.goodscm.model.Customer;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public void add(Customer customer) {
		customer.setCreateTime(new Date());
		customerMapper.insert(customer);
	}

	@Override
	public void delete(Long id) {
		customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}

	@Override
	public Customer get(Long id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Customer> query(CmPage<Customer, List<Customer>> page) {
		return customerMapper.pageQuery(page);
	}

}
