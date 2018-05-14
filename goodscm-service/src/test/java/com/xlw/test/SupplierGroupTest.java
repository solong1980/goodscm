package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.SupplierGroup;
import com.xlw.goodscm.utils.JsonUtilTool;

public class SupplierGroupTest extends BaseTest {

	@Test
	public void testAdd() {
		SupplierGroup supplier = new SupplierGroup();
		supplier.setName("积极歪歪的");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(supplier), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/suppliergroup/add", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/suppliergroup/delete/2",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/suppliergroup/get/2",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		SupplierGroup supplier = new SupplierGroup();
		supplier.setId(2L);
		supplier.setName("积极歪歪的变牛鼻的");

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(supplier), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/suppliergroup/update",
				HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new SupplierGroup()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/suppliergroup/all", HttpMethod.GET,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
