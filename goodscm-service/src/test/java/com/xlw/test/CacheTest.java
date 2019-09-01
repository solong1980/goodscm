package com.xlw.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.service.GoodsService;

import springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class CacheTest {

	@Autowired
	private GoodsService goodsService;

	@Test
	public void contextLoads() {

	}

	// 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac; // 注入WebApplicationContext

	// @Autowired
	// private MockHttpSession session;// 注入模拟的http session
	//
	// @Autowired
	// private MockHttpServletRequest request;// 注入模拟的http request\

	// 在测试开始前初始化工作
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testAble() throws Exception {
		for (int i = 0; i < 2; i++) {
			MvcResult result = mockMvc.perform(post("/able").param("id", "2")).andExpect(status().isOk())// 模拟向testRest发送get请求
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;
					// charset=UTF-8
					.andReturn();// 返回执行请求的结果

			System.out.println(result.getResponse().getContentAsString());
		}
	}

	@Test
	public void testCache() {
		Goods goods = new Goods();
		goods.setCode("10010101");
		goods.setCategoryId(1000L);
		goods.setShortName("10010101 name");

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
		Long id = goodsService.add(goods);

		goods = goodsService.getById(id);
		
		goods.setCategoryId(122000L);
		try {
			goodsService.update(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		goods = goodsService.getById(id);
		
		goodsService.deleteById(id);

		goods = goodsService.getById(id);
		
		System.out.println(id);
	}

}
