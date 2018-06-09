package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
		customer.setId(null);
		checkCustomerCodeDuplicate(customer);
		
		customer.setCreateTime(new Date());
		customerMapper.insert(customer);
	}

	@Override
	public void delete(Long id) {
		customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Customer customer) {

		checkCustomerCodeDuplicate(customer);
		
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
	
	/**
	 * 如果code为空则通过 ，否则判断是否重复
	 * 
	 * @param customer
	 */
	private synchronized void checkCustomerCodeDuplicate(Customer customer) {
		String code = customer.getCode();
		if (StringUtils.isNotEmpty(code)) {
			int count = customerMapper.selectCount(customer);
			if (count > 0)
				throw new DuplicateKeyException("Add\\Update Customer Exception: Duplicate entry '"+code+"' for key 'code'");
		}
	}

}
