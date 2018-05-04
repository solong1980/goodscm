package com.xlw.test;

import java.io.File;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONObject;
import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.model.GoodsPic;
import com.xlw.goodscm.model.SupplierRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.goodscm.utils.JsonUtilTool;

public class GoodsTest extends BaseTest {

	@Test
	public void testDologin() {
		login();
	}

	@Test
	public void testGoodsQuery() {
		Goods goods = new Goods();
		goods.setShortName("compan");
		goods.setCategoryId(10L);
		GoodsCategory category = new GoodsCategory();
		category.setCategoryCode("007000000");
		goods.setCategory(category);

		CmPage<Goods, List<Goods>> page = new CmPage<>();
		page.setC(goods);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goods/query", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGoodsGet() {
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goods/get/25", HttpMethod.GET, null, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGoodsAddUpdatePics() throws URISyntaxException {

		List<Long> addGoodsPics = addGoodsPics();

		URI url = new URI(localhost + "/goods/addupdatepics");

		HttpHeaders headers = createJsonHeader();

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

		goods.setSupplierRecords(new ArrayList<SupplierRecord>() {
			private static final long serialVersionUID = 1L;
			{
				for (int i = 0; i < 4; i++) {
					SupplierRecord record = new SupplierRecord();
					record.setSupplierId(i + 1L);
					record.setQuantity(1);
					record.setPurchaseTime(new Date());
					record.setTotalPrice(new BigDecimal("100"));
					record.setUnitPrice(new BigDecimal("100"));
					add(record);
				}
			}
		});

		goods.setGoodsPics(new ArrayList<GoodsPic>() {
			private static final long serialVersionUID = 1L;
			{
				for (int i = 0; i < addGoodsPics.size(); i++) {
					GoodsPic goodsPic = new GoodsPic();
					goodsPic.setId(addGoodsPics.get(i));
					if (i == 0)
						goodsPic.setIsThumbnail(true);
					add(goodsPic);
				}
			}
		});

		// JSONObject jsonObj = JsonUtilTool.toJsonObj(goods);
		// param.setAll(jsonObj);
		// HttpEntity<MultiValueMap<String, Object>> httpEntity = new
		// HttpEntity<MultiValueMap<String, Object>>(param);
		// System.out.println(httpEntity.toString());
		// ResponseEntity<String> responseEntity = restTemplate.exchange(url,
		// HttpMethod.POST, httpEntity, String.class);
		System.out.println(JsonUtilTool.toJson(goods));
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goods), headers);
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

		URI url = new URI(localhost + "/goods/update");

		List<Long> addGoodsPics = addGoodsPics();

		HttpHeaders headers = createJsonHeader();

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/goods/get/21", HttpMethod.GET, null, String.class);
		System.out.println(responseEntity.getBody());
		CmResult result = JsonUtilTool.fromJson(responseEntity.getBody(), CmResult.class);

		Goods goods = JsonUtilTool.fromJson(result.getData().toString(), Goods.class);

		System.out.println("-----------------------------------Get By 21");
		System.out.println(goods);

		goods.setCategoryId(11L);
		goods.setShortName("Company Long name");

		goods.setNameZh("太强了");

		goods.setNameEn("toostromg");

		goods.setNetWeight(new BigDecimal("140"));

		goods.setWeightAfterPacking(new BigDecimal("180"));

		goods.setLength(new BigDecimal("210"));

		goods.setWidth(new BigDecimal("120"));

		goods.setHeight(new BigDecimal("120"));

		goods.setPackingLength(new BigDecimal("120"));

		goods.setPackingWidth(new BigDecimal("120"));

		goods.setPackingHeight(new BigDecimal("120"));

		goods.setPurchasePrice(new BigDecimal("120"));

		goods.setRetailPrice(new BigDecimal("120"));

		goods.setTradePrice(new BigDecimal("120"));

		goods.setStock(new BigDecimal("120"));

		goods.setStockUnit((short) 2);

		goods.setStatus((short) 2);

		goods.setMemo("MenoMeno");

		goods.setZhInfo("zh_infozh_info");

		goods.setEnInfo("en_infoen_info");

		goods.setExtInfo("ext_infoext_info");

		List<SupplierRecord> supplierRecords = goods.getSupplierRecords();
		if (supplierRecords == null) {
			supplierRecords = new ArrayList<>();
		}
		supplierRecords.addAll(new ArrayList<SupplierRecord>() {
			private static final long serialVersionUID = 1L;
			{
				for (int i = 0; i < 2; i++) {
					SupplierRecord record = new SupplierRecord();
					record.setSupplierId(i + 1L);
					record.setQuantity(1);
					record.setPurchaseTime(new Date());
					record.setTotalPrice(new BigDecimal("100"));
					record.setUnitPrice(new BigDecimal("100"));
					add(record);
				}
			}
		});

		List<GoodsPic> goodsPics = goods.getGoodsPics();
		if (goodsPics == null) {
			goodsPics = new ArrayList<>();
		}
		for (GoodsPic goodsPic : goodsPics) {
			goodsPic.setIsThumbnail(false);
		}
		goodsPics.addAll(new ArrayList<GoodsPic>() {
			private static final long serialVersionUID = 1L;
			{
				for (int i = 0; i < addGoodsPics.size(); i++) {
					GoodsPic goodsPic = new GoodsPic();
					goodsPic.setId(addGoodsPics.get(i));
					if (i == 0)
						goodsPic.setIsThumbnail(true);
					add(goodsPic);
				}
			}
		});
		System.out.println("-----------------------------------Update By 2");
		System.out.println(JsonUtilTool.toJson(goods));
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(goods), headers);
		responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println("-----------------------------------After");
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
