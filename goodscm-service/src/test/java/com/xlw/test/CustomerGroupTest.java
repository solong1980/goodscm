package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.CustomerGroup;
import com.xlw.goodscm.utils.JsonUtilTool;

public class CustomerGroupTest extends BaseTest {

	@Test
	public void testAdd() {
		CustomerGroup customerGroup = new CustomerGroup();
		customerGroup.setName("积极歪歪的");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customerGroup), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customergroup/add", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customergroup/delete/2",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customergroup/get/3",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		CustomerGroup customerGroup = new CustomerGroup();
		customerGroup.setId(3L);
		customerGroup.setName("积极歪歪的变牛鼻的");

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customerGroup), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customergroup/update",
				HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new CustomerGroup()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customergroup/all", HttpMethod.GET,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
