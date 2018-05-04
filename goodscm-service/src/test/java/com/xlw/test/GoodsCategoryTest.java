package com.xlw.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONObject;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.utils.JsonUtilTool;

public class GoodsCategoryTest extends BaseTest {

	@Test
	public void testAddCategory() throws URISyntaxException {
		GoodsCategory category = new GoodsCategory();
		category.setParentId(11L);
		category.setName("高级镜头");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		URI url = new URI(localhost + "/goodscategory/add");

		JSONObject jsonObj = JsonUtilTool.toJsonObj(category);
		param.setAll(jsonObj);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuerySubCategory() throws URISyntaxException {
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		URI url = new URI(localhost + "/goodscategory/querysubcategory/0");
		param.setAll(new JSONObject());
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testUpdateCategory() throws URISyntaxException {
		URI url = new URI(localhost + "/goodscategory/update");
		GoodsCategory category = new GoodsCategory();
		category.setId(10L);
		category.setParentId(0L);
		category.setName("高级镜头2");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(category),createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
