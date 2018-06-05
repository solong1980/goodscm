package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.GoodsCMException;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.dao.CustomerGroupMapper;
import com.xlw.goodscm.model.CustomerGroup;
import com.xlw.goodscm.service.CustomerGroupService;

/**
 * @author longlianghua
 */
@Service
public class CustomerGroupServiceImpl implements CustomerGroupService {

	@Autowired
	private CustomerGroupMapper customerGroupMapper;

	@Override
	public void add(CustomerGroup customerGroup) {
		customerGroup.setCreateTime(new Date());
		customerGroupMapper.insert(customerGroup);
	}

	@Override
	public CustomerGroup get(Long id) {
		return customerGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(CustomerGroup customerGroup) {
		customerGroupMapper.updateByPrimaryKey(customerGroup);
	}

	@Override
	public List<CustomerGroup> selectAll() {
		return customerGroupMapper.selectAll();
	}

	@Override
	public void delete(Long id) {
		Long CustomerCount = customerGroupMapper.customerCount(id);
		if (CustomerCount > 0) {
			throw new GoodsCMException(Codes.REL_CUSTOMER);
		}
		customerGroupMapper.deleteByPrimaryKey(id);
	}

}
