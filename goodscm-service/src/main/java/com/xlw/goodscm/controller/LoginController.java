package com.xlw.goodscm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlw.goodscm.Consts;
import com.xlw.goodscm.ReturnCode;
import com.xlw.goodscm.ReturnCode.Codes;
import com.xlw.goodscm.model.User;
import com.xlw.goodscm.pojo.CmResult;
import com.xlw.sys.model.SysUser;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * login with account/password
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/dologin")
	public CmResult login(User user) throws Exception {
		logger.info("dologin" + user);
		CmResult cmResult = null;
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			cmResult = CmResult.build(ReturnCode.Codes.PARAM_ERROR, null);
		}
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			cmResult = CmResult.build(ReturnCode.Codes.PARAM_ERROR, null);
		}
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			subject.login(token);

			SysUser userInfo = (SysUser) subject.getPrincipals().getPrimaryPrincipal();

			userInfo.setSessionId(subject.getSession().getId());
			subject.getSession().setAttribute(Consts.SESSION_USER, userInfo);

			cmResult = CmResult.build(ReturnCode.Codes.LOGIN_SUCCESS, userInfo);
		} catch (IncorrectCredentialsException e) {
			cmResult = CmResult.build(ReturnCode.Codes.PASSWORD_ERROR, null);
		} catch (LockedAccountException e) {
			cmResult = CmResult.build(ReturnCode.Codes.LOGIN_FAILURE, null);
		} catch (AuthenticationException e) {
			cmResult = CmResult.build(ReturnCode.Codes.USER_NOEXIST, null);
		} catch (Exception e) {
			logger.error("login fail", e);
			cmResult = CmResult.build(ReturnCode.Codes.FAILURE, null);
		}
		return cmResult;

	}
	
	/**
	 * logout
	 * @return
	 */
	@RequestMapping("/dologout")
	@ResponseBody
	public CmResult logout() {
		SecurityUtils.getSubject().logout();
		return CmResult.build(Codes.SUCCESS);
	}
}
