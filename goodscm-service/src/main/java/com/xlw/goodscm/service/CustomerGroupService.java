package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.CustomerGroup;

/**
 * @author longlianghua
 */
public interface CustomerGroupService {
	void add(CustomerGroup customerGroup);

	CustomerGroup get(Long id);

	void update(CustomerGroup customerGroup);

	List<CustomerGroup> selectAll();
	
	void delete(Long id);
}
