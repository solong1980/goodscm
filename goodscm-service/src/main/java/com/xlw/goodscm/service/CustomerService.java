package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.Customer;
import com.xlw.goodscm.pojo.CmPage;

/**
 * @author longlianghua
 */
public interface CustomerService {

	void add(Customer customer);

	void delete(Long id);

	void update(Customer customer);

	Customer get(Long id);

	List<Customer> query(CmPage<Customer, List<Customer>> page);
	
}
