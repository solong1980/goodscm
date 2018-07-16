package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Supplier;
import com.xlw.goodscm.utils.JsonUtilTool;

public abstract class BeTempletTest<T> extends BaseTest {
	
	@Test
	public void testDologin() {
		login();
	}

	protected abstract String moduleUrl();
	protected abstract T create();
	protected abstract T createUpdate();

	@Test
	public void testAdd() {
		T t = create();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(t), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + moduleUrl() + "/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	public void del(Long id) {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + moduleUrl() + "/delete/"+id, HttpMethod.GET, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	public void get(Long id) {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + moduleUrl() + "/get/"+id, HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	public void update() {
		T supplier = createUpdate();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(supplier), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + moduleUrl() + "/update", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQueryAll() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Supplier()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + moduleUrl() + "/all", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
}
