package com.xlw.goodscm.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.CustomerLevelPriceMapper;
import com.xlw.goodscm.model.CustomerLevelPrice;
import com.xlw.goodscm.service.CustomerLevelPriceService;

/**
 * @author longlianghua
 */
@Service
public class CustomerLevelPriceImpl implements CustomerLevelPriceService {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLevelPriceImpl.class);

	@Autowired
	private CustomerLevelPriceMapper customerLevelPriceMapper;

	@Override
	public void add(CustomerLevelPrice customerLevelPrice) {
		customerLevelPrice.setCreateTime(new Date());
		customerLevelPriceMapper.insert(customerLevelPrice);
	}

	@Override
	public CustomerLevelPrice get(Long id) {
		return customerLevelPriceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(CustomerLevelPrice customerLevelPrice) {
		customerLevelPriceMapper.updateByPrimaryKey(customerLevelPrice);
	}

	@Override
	public List<CustomerLevelPrice> selectAll() {
		return customerLevelPriceMapper.selectAll();
	}

	@Override
	public void delete(Long id) {
		customerLevelPriceMapper.deleteByPrimaryKey(id);
	}

}
