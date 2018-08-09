package com.xlw.sys.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.GoodsCMException;
import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.sys.model.SysUser;
import com.xlw.sys.service.SysUserService;
import com.xlw.sys.shiro.ShiroTag;
import com.xlw.sys.shiro.ShiroUtils;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Autowired
	private ShiroTag shiroTag;
	@Autowired
	SysUserService sysUserService;

	public void isAuthority() {
		if (!shiroTag.isAuthority()) {
			throw new GoodsCMException(ReturnCode.Codes.NO_PERMISSION);
		}
	}

	// 修改密码
	@ResponseBody
	@RequestMapping("/chpwd")
	public CmResult chpwd(@RequestBody SysUser sysUser) {
		String originPassword = sysUser.getOriginPassword();
		CmResult cmResult = null;
		logger.info(ShiroUtils.getUserEntity() + " updates password");
		if (StringUtils.isEmpty(originPassword)) {
			cmResult = CmResult.build(ReturnCode.Codes.ORIGIN_PASSWORD_ERROR);
			return cmResult;
		}
		String password = sysUser.getPassword();
		if (StringUtils.isEmpty(password)) {
			cmResult = CmResult.build(ReturnCode.Codes.PARAM_ERROR);
			return cmResult;
		}

		Long userId = ShiroUtils.getUserEntity().getUserId();
		String salt = ShiroUtils.getUserEntity().getSalt();
		originPassword = ShiroUtils.sha256(originPassword, salt);
		password = ShiroUtils.sha256(password, salt);
		boolean success = sysUserService.updatePassword(userId, originPassword, password);
		cmResult = CmResult.build(success ? ReturnCode.Codes.SUCCESS : ReturnCode.Codes.ORIGIN_PASSWORD_ERROR);
		return cmResult;
	}

	// 管理员重置员工密码
	@ResponseBody
	@RequestMapping("/resetpwd")
	public CmResult resetpwd(@RequestBody SysUser sysUser) {
		// check permission
		isAuthority();

		CmResult cmResult = null;
		logger.info(ShiroUtils.getUserEntity() + " resets password");

		String password = sysUser.getPassword();
		if (StringUtils.isEmpty(password)) {
			cmResult = CmResult.build(ReturnCode.Codes.PARAM_ERROR);
			return cmResult;
		}
		boolean success = sysUserService.resetPassword(sysUser);
		cmResult = CmResult.build(success ? ReturnCode.Codes.SUCCESS : ReturnCode.Codes.FAILURE);
		return cmResult;
	}
}
