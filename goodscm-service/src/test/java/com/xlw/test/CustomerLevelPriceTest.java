package com.xlw.test;

import org.junit.Test;

import com.xlw.goodscm.model.CustomerLevelPrice;

public class CustomerLevelPriceTest extends BeTempletTest<CustomerLevelPrice> {
	@Override
	protected String moduleUrl() {
		return "/customerlevelprice";
	}

	@Override
	protected CustomerLevelPrice create() {
		CustomerLevelPrice customerLevelPrice = new CustomerLevelPrice();
		customerLevelPrice.setName("VIP高级客户价格");
		return customerLevelPrice;
	}

	@Override
	protected CustomerLevelPrice createUpdate() {
		CustomerLevelPrice customerLevelPrice = new CustomerLevelPrice();
		customerLevelPrice.setId(1L);
		customerLevelPrice.setName("普通高级客户价格");
		return customerLevelPrice;
	}

	@Override
	public void testDologin() {
		super.testDologin();
	}

	@Override
	public void testAdd() {
		super.testAdd();
	}

	@Test
	public void testDel() {
		super.del(1L);
	}
	
	@Test
	public void testGet() {
		super.get(1L);
	}
	@Test
	public void testUpdate() {
		super.update();
	}

	@Override
	public void testQueryAll() {
		super.testQueryAll();
	}

}
