package com.xlw.test.mock;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.model.Goods;
import com.xlw.goodscm.service.GoodsService;
import com.xlw.goodscm.utils.BeanContextAdv;

import springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
// @WebAppConfiguration
@EnableAutoConfiguration
public class BaseMockTest {

	@Autowired
	private GoodsService goodsService;

	private MockMvc mockMvc;

	public BaseMockTest() {
		super();
		System.out.println();
	}

	@Before
	public void setUp() throws Exception {
		BeanContextAdv adv = new BeanContextAdv();
		List<Object> scan = adv.scan("com.xlw.goodscm.controller");
		List<Object> controllers = new ArrayList<>();
		for (Object object : scan) {
			if (object.getClass().getAnnotation(RestController.class) != null) {
				controllers.add(object);
			}
			if (object.getClass().getAnnotation(Controller.class) != null) {
				controllers.add(object);
			}
		}
		mockMvc = MockMvcBuilders.standaloneSetup(controllers.toArray(new Object[controllers.size()])).build();
	}

	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/login/dologin?account=admin&password=123456").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("")));
	}

	@Test
	public void testAdd() {
		Goods goods = new Goods();
		goods.setCode("00010100");
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
		Long id = goodsService.add(goods);
		System.out.println(id);
	}

	@Test
	public void testGet() {
		Goods goods = goodsService.getById(0L);
		System.out.println(goods);
	}

	@Test
	public void testUpdate() throws Exception {
		Goods goods = new Goods();

		goods.setId(0L);

		goods.setCode("00010100");
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

		goodsService.update(goods);

		System.out.println(goods);
	}

	@Test
	public void testDel() throws Exception {
		goodsService.deleteById(0L);
	}

}
