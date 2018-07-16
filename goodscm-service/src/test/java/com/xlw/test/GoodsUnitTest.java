package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.GoodsUnit;
import com.xlw.goodscm.utils.JsonUtilTool;

public class GoodsUnitTest extends BaseTest {

	@Test
	public void testAdd() {
		GoodsUnit goodsUnit = new GoodsUnit();
		goodsUnit.setName("量子");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goodsUnit), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodsunit/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodsunit/delete/19", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodsunit/get/19", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		GoodsUnit goodsUnit = new GoodsUnit();
		goodsUnit.setId(19L);
		goodsUnit.setName("电子");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goodsUnit), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodsunit/update", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
 
	@Test
	public void testQueryAll() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new GoodsUnit()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodsunit/all", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
}
