package com.xlw.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.model.GoodsCategory;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.utils.JsonUtilTool;

public class PlateformReleaseTest extends BaseTest {

	@Test
	public void testGoodsQuery() {
		Goods goods = new Goods();
		goods.setShortName("compan");
		goods.setCategoryId(10L);
		GoodsCategory category = new GoodsCategory();
		//category.setCategoryCode("007000000");
		goods.setCategory(category);

		CmPage<Goods, List<Map<String, Object>>> page = new CmPage<>();
		page.setC(goods);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(
				localhost + "/plateformrelease/querygoodsreleaserecord", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
	}

}
