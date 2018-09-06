package com.xlw.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.xlw.goodscm.utils.JsonUtilTool;

public class ZergTest {
	public static final String localhost = "http://localhost:9905/zerg/public/v1";
	public String sessionId = "5c162a48-f26f-49c3-b1bd-b44819ce1d45";

	RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(50000);// 单位为ms
		factory.setConnectTimeout(50000);// 单位为ms
		restTemplate = new RestTemplate(factory);

		File sessionFile = new File("session.dat");
		if (sessionFile.exists()) {
			String sessionId = FileUtils.readFileToString(new File("session.dat"));
			if (sessionId != null)
				this.sessionId = sessionId;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	public HttpHeaders createMultiPartHeader() {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.MULTIPART_FORM_DATA;
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
		if (sessionId != null)
			headers.add("Authorization", sessionId);
		return headers;
	}

	public HttpHeaders createJsonHeader() {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.APPLICATION_JSON_UTF8;
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
		if (sessionId != null)
			headers.add("Authorization", sessionId);
		return headers;
	}

	public JSONObject doGet(String url) {
		JSONObject body = restTemplate.getForEntity(url, JSONObject.class).getBody();
		return body;
	}

	public JSONObject doPost(String url, Object object) {
		JSONObject postData = JsonUtilTool.toJsonObj(object);
		JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
		return json;
	}

	@Test
	public void testTokenVerify() {
		JSONObject jb = new JSONObject();
		jb.put("token", "11111");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/token/verify", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testTokenUser() {
		JSONObject jb = new JSONObject();
		jb.put("code", "0713wFXN1gyjP21dT9XN10b1YN13wFXU");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/token/user", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testBanner() {
		JSONObject jb = new JSONObject();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/banner/1", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testProductRecent() {
		JSONObject jb = new JSONObject();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/product/recent/1", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testThemeIds() {
		JSONObject jb = new JSONObject();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/theme?ids=1,2,3", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testTheme() {
		JSONObject jb = new JSONObject();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/theme/1", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testProduct() {
		JSONObject jb = new JSONObject();
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/product/1", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testGetAddress() {
		JSONObject jb = new JSONObject();
		HttpHeaders header = createJsonHeader();
		header.add("token", "1122");
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(jb), header);
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/address", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testAddAddress() {
		HttpHeaders header = createJsonHeader();
		header.add("token", "1122");
		HttpEntity<String> httpEntity = new HttpEntity<String>("{\"name\": \"张三\", \"province\": \"广东省\", \"city\": \"广州市\", \"country\": \"海珠区\", \"mobile\": \"020-81167888\", \"detail\": \"新港中路397号\"}", header);
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/address", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testOrder() {
		HttpHeaders header = createJsonHeader();
		header.add("token", "1122");
		HttpEntity<String> httpEntity = new HttpEntity<String>(" {\"products\":[{\"productId\":1,\"count\":1},{\"productId\":18,\"count\":3},{\"productId\":19,\"count\":2}]}", header);
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/order", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
}
