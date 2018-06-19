package com.xlw.test;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;
import com.xlw.goodscm.model.GoodsPostCart;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.utils.JsonUtilTool;

public class GoodsPostCartTest extends BaseTest {

	@Test
	public void testAdd() {
		GoodsPostCart goodsPostCart = new GoodsPostCart();
		goodsPostCart.setCustomerId(1L);
		goodsPostCart.setGoodsId(1L);
		goodsPostCart.setStatus((short) 1);
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goodsPostCart), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/add", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/delete/1",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/get/1",
				HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/get/1",
				HttpMethod.GET, httpEntity, String.class);

		String body = responseEntity.getBody();
		JSONObject jsonObj = JsonUtilTool.toJsonObj(body);
		GoodsPostCart goodsPostCart = JsonUtilTool.fromJson(jsonObj.getString("data"), GoodsPostCart.class);

		goodsPostCart.setStatus((short) 4);
		httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goodsPostCart), createJsonHeader());
		responseEntity = restTemplate.exchange(localhost + "/goodspostcart/update", HttpMethod.POST, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQueryAll() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new GoodsPostCart()),
				createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/all", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {

		GoodsPostCart goodsPostCart = new GoodsPostCart();
		goodsPostCart.setCustomerId(1L);
		goodsPostCart.setOperatorId(1L);
		CmPage<GoodsPostCart, List<GoodsPostCart>> page = new CmPage<>();
		page.setC(goodsPostCart);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/query",
				HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testExport() {

		HttpEntity<String> httpEntity = new HttpEntity<String>(createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goodspostcart/export/1",
				HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
}
