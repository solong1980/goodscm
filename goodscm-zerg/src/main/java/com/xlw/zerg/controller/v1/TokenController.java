package com.xlw.zerg.controller.v1;

import java.security.InvalidParameterException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.service.TokenService;
import com.xlw.zerg.vo.WxCode;

@RestController
@RequestMapping("/zerg/public/api/v1/token")
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@RequestMapping("/verify")
	public String tokenVerify(@RequestBody Map<String, String> to) {
		return tokenService.tokenVerify(to);
	}

	@RequestMapping("/user")
	public String tokenUser(@RequestBody WxCode wxCode) {
		if (wxCode == null) {
			throw new InvalidParameterException("no wxcode error");
		}
		return tokenService.tokenUser(wxCode.getCode());
	}

}
