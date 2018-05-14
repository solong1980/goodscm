package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.utils.JsonUtilTool;

public class SupplierTest extends BaseTest {

	@Test
	public void testAdd() {
		Supplier supplier = new Supplier();
		supplier.setGroupId(3L);
		supplier.setCode("00003");
		supplier.setName("广东量子器件供应部");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(supplier), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/supplier/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/supplier/delete/1", HttpMethod.GET, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/supplier/get/2", HttpMethod.GET, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		Supplier supplier = new Supplier();
		supplier.setId(4L);
		supplier.setGroupId(2L);
		supplier.setCode("00003");
		supplier.setName("广西电子器件供应部");
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(supplier), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/supplier/update", HttpMethod.POST, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Supplier()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/supplier/all", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
