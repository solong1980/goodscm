package com.xlw.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.model.PlateformReleaseRecord;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.utils.JsonUtilTool;

public class PlateformReleaseTest extends BaseTest {

	@Test
	public void testAddGoodsReleaseRecord() {
		PlateformReleaseRecord record = new PlateformReleaseRecord();

		record.setGoodsId(25L);
		record.setPlatformId(1L);
		record.setReleasePrice(new BigDecimal(100));
		record.setReleaseState((short) 1);
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(record), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/plateformrelease/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDelGoodsReleaseRecord() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/plateformrelease/delete/6", HttpMethod.GET, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGetGoodsReleaseRecord() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/plateformrelease/get/5", HttpMethod.GET, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdateGoodsReleaseRecord() {
		PlateformReleaseRecord record = new PlateformReleaseRecord();
		record.setId(5L);
		record.setReleasePrice(new BigDecimal(1000));
		record.setReleaseState((short) 0);
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(record), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/plateformrelease/update", HttpMethod.POST, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQueryGoodsReleaseRecord() {
		Goods goods = new Goods();
		goods.setShortName("compan");
		goods.setCategoryId(10L);
		GoodsCategory category = new GoodsCategory();
		// category.setCategoryCode("007000000");
		goods.setCategory(category);

		CmPage<Goods, List<Map<String, Object>>> page = new CmPage<>();
		page.setC(goods);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/plateformrelease/querygoodsreleaserecord", HttpMethod.POST,
				httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
