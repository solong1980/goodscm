package com.xlw.test;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.model.Customer;
import com.xlw.goodscm.pojo.CmPage;
import com.xlw.goodscm.utils.JsonUtilTool;

public class CustomerTest extends BaseTest {

	@Test
	public void testAdd() {
		Customer customer = new Customer();
		customer.setGroupId(1L);
		customer.setPriceLevelId(1L);
		customer.setCode("010201");
		customer.setName("客户名称2");
		customer.setFullName("客户完整公司名");

		customer.setContact("联系人");
		customer.setMobile("手机");
		customer.setPhone("电话");
		customer.setFax("传真");
		customer.setQq("QQ");
		customer.setWechat("微信");
		customer.setWangwangNo("旺旺号");
		customer.setOtherContact("其它联系方式");
		customer.setEmail("邮箱");
		customer.setWebsite("网站");
		customer.setAddress("经营地址");
		customer.setMemo("备注");
		customer.setStatus((short) 0);
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customer), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/add", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testDel() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/delete/8", HttpMethod.GET, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testGet() {
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(new Object()), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/get/10", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testUpdate() {
		Customer customer = new Customer();
		customer.setId(44L);
		customer.setGroupId(1L);
		customer.setPriceLevelId(1L);
		customer.setCode("01020");
		customer.setName("客户名称");
		customer.setFullName("客户完整公司名");

		customer.setContact("联系人");
		customer.setMobile("手机");
		customer.setPhone("电话");
		customer.setFax("传真");
		customer.setQq("QQ");
		customer.setWechat("微信");
		customer.setWangwangNo("旺旺号");
		customer.setOtherContact("其它联系方式");
		customer.setEmail("邮箱");
		customer.setWebsite("网站");
		customer.setAddress("经营地址");
		customer.setMemo("备注");
		customer.setStatus((short) 1);
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(customer), createJsonHeader());

		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/update", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testQuery() {
		Customer customer = new Customer();
		customer.setGroupId(1L);
//		customer.setCode("2222");
//		customer.setName("22");

		CmPage<Customer, List<Customer>> page = new CmPage<>();
		page.setC(customer);
		page.setPageNum(1);
		page.setCount(50);

		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(page), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/query", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void test() {
		HttpEntity<String> httpEntity = new HttpEntity<String>("{}", createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/customer/all", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

}
