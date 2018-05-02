package com.xlw.test;

import java.io.File;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.utils.JsonUtilTool;

public class GoodsTest {
	public static final String localhost = "http://localhost:8080";

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

	private HttpHeaders login() {
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

	public JSONObject doGet(String url) {
		JSONObject body = restTemplate.getForEntity(url, JSONObject.class).getBody();
		return body;
	}

	public JSONObject doPost(String url, Object object) {
		JSONObject postData = JsonUtilTool.toJsonObj(object);
		JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
		return json;
	}

	private void sendWithHeader(String url, JSONObject jsonObj, HttpHeaders headers) {
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

	@Test
	public void testDologin() {
		login();
	}

	@Test
	public void testGoodsQuery() {
		sendWithHeader(localhost + "/goods/query", new JSONObject(), new HttpHeaders());
	}

	@Test
	public void testGoodsFastAdd() throws URISyntaxException {
		URI url = new URI(localhost + "/goods/fastadd");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

		Goods goods = new Goods();
		goods.setCode("1111");
		goods.setCategoryId(1000L);
		goods.setShortName("company short name");

		goods.setNameZh("强强强");

		goods.setNameEn("strongstring");

		goods.setNetWeight(new BigDecimal("10"));

		goods.setWeightAfterPacking(new BigDecimal("10"));

		goods.setLength(new BigDecimal("10"));

		goods.setWidth(new BigDecimal("10"));

		goods.setHeight(new BigDecimal("10"));

		goods.setPackingLength(new BigDecimal("10"));

		goods.setPackingWidth(new BigDecimal("10"));

		goods.setPackingHeight(new BigDecimal("10"));

		goods.setPurchasePrice(new BigDecimal("10"));

		goods.setRetailPrice(new BigDecimal("10"));

		goods.setTradePrice(new BigDecimal("10"));

		goods.setStock(new BigDecimal("10"));

		goods.setStockUnit((short) 1);

		goods.setStatus((short) 1);
 
		goods.setMemo("Meno");

		goods.setZhInfo("zh_info");

		goods.setEnInfo("en_info");

		goods.setExtInfo("ext_info");

		JSONObject jsonObj = JsonUtilTool.toJsonObj(goods);
		param.setAll(jsonObj);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
		System.out.println(httpEntity.toString());
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());

	}
	
	@Test
	public void testGoodsAdd() throws URISyntaxException {
		URI url = new URI(localhost + "/goods/add/1");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

		FileSystemResource resource = new FileSystemResource(new File("2016-10-19 2016-10-19 002 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-19 2016-10-19 002 001.jpg");

		resource = new FileSystemResource(new File("2016-10-27 2016-10-27 001 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-27 2016-10-27 001 001.jpg");

		resource = new FileSystemResource(new File("2016-11-01 2016-11-01 001 001.gif"));

		param.add("files", resource);
		param.add("fileName", "2016-11-01 2016-11-01 001 001.gif");
		
		Goods goods = new Goods();
		goods.setCode("1111");
		goods.setCategoryId(1000L);
		goods.setShortName("company short name");

		goods.setNameZh("强强强");

		goods.setNameEn("strongstring");

		goods.setNetWeight(new BigDecimal("10"));

		goods.setWeightAfterPacking(new BigDecimal("10"));

		goods.setLength(new BigDecimal("10"));

		goods.setWidth(new BigDecimal("10"));

		goods.setHeight(new BigDecimal("10"));

		goods.setPackingLength(new BigDecimal("10"));

		goods.setPackingWidth(new BigDecimal("10"));

		goods.setPackingHeight(new BigDecimal("10"));

		goods.setPurchasePrice(new BigDecimal("10"));

		goods.setRetailPrice(new BigDecimal("10"));

		goods.setTradePrice(new BigDecimal("10"));

		goods.setStock(new BigDecimal("10"));

		goods.setStockUnit((short) 1);

		goods.setStatus((short) 1);
 
		goods.setMemo("Meno");

		goods.setZhInfo("zh_info");

		goods.setEnInfo("en_info");

		goods.setExtInfo("ext_info");

		JSONObject jsonObj = JsonUtilTool.toJsonObj(goods);
		param.setAll(jsonObj);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
		System.out.println(httpEntity.toString());
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());

	}

	@Test
	public void testUpdateGoods() throws URISyntaxException {

		URI url = new URI(localhost + "/goods/update/1");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

		FileSystemResource resource = new FileSystemResource(new File("2016-10-19 2016-10-19 002 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-19 2016-10-19 002 001.jpg");

		resource = new FileSystemResource(new File("2016-10-27 2016-10-27 001 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-27 2016-10-27 001 001.jpg");

		resource = new FileSystemResource(new File("2016-11-01 2016-11-01 001 001.gif"));

		param.add("files", resource);
		param.add("fileName", "2016-11-01 2016-11-01 001 001.gif");

		Goods goods = new Goods();
		goods.setId(1L);
		goods.setCode("2222");
		JSONObject jsonObj = JsonUtilTool.toJsonObj(goods);
		param.setAll(jsonObj);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);

		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testAddGoodsPic() throws URISyntaxException {

		URI url = new URI(localhost + "/goodspic/upload/");

		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

		FileSystemResource resource = new FileSystemResource(new File("2016-10-19 2016-10-19 002 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-19 2016-10-19 002 001.jpg");

		resource = new FileSystemResource(new File("2016-10-27 2016-10-27 001 001.jpg"));

		param.add("files", resource);
		param.add("fileName", "2016-10-27 2016-10-27 001 001.jpg");

		resource = new FileSystemResource(new File("2016-11-01 2016-11-01 001 001.gif"));

		param.add("files", resource);
		param.add("fileName", "2016-11-01 2016-11-01 001 001.gif");

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);

		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}
	
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
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity , String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testQuerySubCategory() throws URISyntaxException {
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		URI url = new URI(localhost + "/goodscategory/querysubcategory/0");
		param.setAll(new JSONObject());
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity , String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void test() {
	}

}
