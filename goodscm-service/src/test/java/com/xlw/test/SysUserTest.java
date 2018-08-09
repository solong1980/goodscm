package com.xlw.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.xlw.goodscm.utils.JsonUtilTool;
import com.xlw.sys.model.SysUser;

public class SysUserTest extends BaseTest {

	@Test
	public void testChPwd() {
		SysUser sysUser = new SysUser();
		sysUser.setOriginPassword("admin");//原始密码
		sysUser.setPassword("admin");//新密码
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(sysUser), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/sysuser/chpwd", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testResetPwd() {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(3L);//员工userId
		sysUser.setPassword("admin");//新密码
		HttpEntity<String> httpEntity = new HttpEntity<String>(JsonUtilTool.toJson(sysUser), createJsonHeader());
		ResponseEntity<String> responseEntity = restTemplate.exchange(localhost + "/sysuser/resetpwd", HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getBody());
	}

}
