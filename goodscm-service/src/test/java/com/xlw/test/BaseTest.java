package com.xlw.test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.utils.JsonUtilTool;

public class BaseTest {
	public static final String localhost = "http://localhost:9905";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(50000);// 单位为ms
		factory.setConnectTimeout(50000);// 单位为ms
		restTemplate = new RestTemplate(factory);
	}

	@After
	public void tearDown() throws Exception {
	}

	public HttpHeaders createJsonHeader() {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.APPLICATION_JSON_UTF8;
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
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

	public HttpHeaders login() {
		ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(localhost + "/login/dologin?account=admin&password=123456",
				JSONObject.class);
		JSONObject body = forEntity.getBody();
		HttpHeaders headers = forEntity.getHeaders();
		// for (Entry<String, List<String>> entry : headers.entrySet()) {
		// System.out.println(entry.getKey());
		// System.out.println(entry.getValue());
		// }
		System.out.println(JsonUtilTool.toJson(body));
		Integer status = body.getInteger("status");
		if (status == 200) {
			return headers;
		} else {
			return null;
		}
	}

	public void sendWithHeader(String url, JSONObject jsonObj, HttpHeaders headers) {
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		// headers.add("Authorization", "35e8cb2b-96ee-44da-9dc1-41650166753d");
		if (jsonObj == null) {
			HttpEntity<String> formEntity = new HttpEntity<String>(headers);
			String result = restTemplate.getForObject(url, String.class, formEntity);
			System.out.println(result);
		} else {
			HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

			ResponseEntity<String> postForEntity = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class, new HashMap<>());

			// String result = restTemplate.postForObject(url, formEntity, String.class);
			// System.out.println(result);

			// ResponseEntity<String> postForEntity = restTemplate.postForEntity(url,
			// jsonObj, String.class, formEntity);
			HttpStatus httpStatus = postForEntity.getStatusCode();
			if (httpStatus.is3xxRedirection()) {
				HttpHeaders headers2 = postForEntity.getHeaders();
				List<String> list = headers2.get("Location");
				if (list.size() > 0) {
					String redirectedURL = list.get(0);
					sendWithHeader(redirectedURL, jsonObj, headers);
				}
			} else {
				System.out.println(postForEntity.getBody());
				Map<String, Object> jsonToMap = JsonUtilTool.jsonToMap(postForEntity.getBody());
				Object object = jsonToMap.get("status");
				if ("201".equals(object.toString())) {
					HttpHeaders login = login();
					System.out.println(login);
				} else {

				}
			}
		}
	}

	public List<Long> addGoodsPics() throws URISyntaxException {
		URI url = new URI(localhost + "/goodspic/upload");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

		param.add("fileName", "2016-10-19 2016-10-19 002 001.jpg");
		FileSystemResource resource = new FileSystemResource(new File("2016-10-19 2016-10-19 002 001.jpg"));
		param.add("files", resource);

		param.add("fileName", "2016-10-27 2016-10-27 001 001.jpg");
		resource = new FileSystemResource(new File("2016-10-27 2016-10-27 001 001.jpg"));
		param.add("files", resource);

		param.add("fileName", "2016-11-01 2016-11-01 001 001.jpg");
		resource = new FileSystemResource(new File("2016-11-01 2016-11-01 001 001.jpg"));
		param.add("files", resource);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);

		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
		CmResult cmResult = JsonUtilTool.fromJson(responseEntity.getBody(), CmResult.class);

		List<Long> fromJson = JsonUtilTool.fromJson(cmResult.getData().toString(), new TypeReference<List<Long>>() {
		});
		System.out.println(fromJson);
		return fromJson;
	}
}
