package com.xlw.test.mock;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.goodscm.utils.BeanContextAdv;

import springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
// @WebAppConfiguration
@EnableAutoConfiguration
public class BaseMockTest {
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

}
