package com.xlw.goodscm.service;

import java.util.List;

import com.xlw.goodscm.model.CustomerLevelPrice;

/**
 * @author longlianghua
 */
public interface CustomerLevelPriceService {
	void add(CustomerLevelPrice customerLevelPrice);

	CustomerLevelPrice get(Long id);

	void update(CustomerLevelPrice customerLevelPrice);

	List<CustomerLevelPrice> selectAll();
	
	void delete(Long id);
}
