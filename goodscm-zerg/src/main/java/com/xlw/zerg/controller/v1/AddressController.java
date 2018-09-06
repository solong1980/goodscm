package com.xlw.zerg.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlw.zerg.model.UserAddress;
import com.xlw.zerg.service.UserService;

@RestController
@RequestMapping("/zerg/public/v1/address")
public class AddressController {

	@Autowired
	private UserService userService;

	/**
	 * 获取用户地址
	 * 
	 * @return array
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<UserAddress> getUserAddress(@RequestHeader("token") String token) {
		return userService.getUserAddress(token);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createOrUpdateAddress(@RequestBody UserAddress userAddress) {
		return userService.createOrUpdateAddress(userAddress);
	}

}
