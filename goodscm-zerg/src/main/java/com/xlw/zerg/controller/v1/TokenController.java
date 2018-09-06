package com.xlw.zerg.controller.v1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.service.TokenService;

@RestController
@RequestMapping("/zerg/public/v1/token")
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@RequestMapping("/token/verify")
	public String tokenVerify(@RequestBody Map<String, String> to) {
		return tokenService.tokenVerify(to);
	}

	@RequestMapping("/token/user")
	public String tokenUser(@RequestBody String code) {
		return tokenService.tokenUser(code);
	}

}
