package com.xlw.test;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Customer;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.utils.JsonUtilTool;

public class CustomerTest extends BaseTest {

	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setGroupId(1L);
		customer.setType("1");
		customer.setCode("00000");
		customer.setName("abcdefg");
		customer.setEmail("afasfd");

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customer), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/delete/1", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/get/2", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		Customer customer = new Customer();

		customer.setId(2L);
		customer.setType("1");
		customer.setCode("2222");
		customer.setName("223sadfasf");
		customer.setEmail("3asdfas33");

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customer), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/update", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {
		Customer customer = new Customer();
		customer.setGroupId(1L);
//		customer.setCode("2222");
//		customer.setName("22");

		CmPage<Customer, List<Customer>> page = new CmPage<>();
		page.setC(customer);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/query", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
