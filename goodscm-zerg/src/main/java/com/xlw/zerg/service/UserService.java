package com.xlw.zerg.service;

import java.security.InvalidParameterException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.xlw.goodscm.utils.JsonUtilTool;
import com.xlw.zerg.dao.UserAddressMapper;
import com.xlw.zerg.dao.UserMapper;
import com.xlw.zerg.model.User;
import com.xlw.zerg.model.UserAddress;

@Service
public class UserService extends ZergService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;

	public User getUser(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	public String createOrUpdateAddress(@RequestBody UserAddress userAddress) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String token = request.getHeader("token");
		Integer uid = getCurUserId(token);

		userAddress.setUserId(uid);
		List<UserAddress> existsAddresses = userAddressMapper.selectByUserId(uid);
		if (existsAddresses != null && !existsAddresses.isEmpty()) {
			userAddress.setId(existsAddresses.get(0).getId());
			userAddressMapper.updateByPrimaryKey(userAddress);
		} else {
			userAddressMapper.insert(userAddress);
		}
		return "{code:201,msg:'ok',errorCode:0}";
	}

	/**
	 * 获取用户地址
	 * 
	 * @return array
	 * @throws UserException
	 */
	@RequestMapping(value = "address", method = RequestMethod.GET)
	public List<UserAddress> getUserAddress(@RequestHeader("token") String token) {
		// HttpServletRequest request = ((ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes()).getRequest();
		// String token = request.getHeader("token");
		if (token == null)
			throw new InvalidParameterException("miss head parameter 'token'");
		String respjb = tokenCache.getIfPresent(token);
		if (respjb == null) {
			// throw new InvalidParameterException("No current user");
			respjb = "{uid:1,scope:\"ScopeEnum::User\"}";
		}
		JSONObject userTokenJb = JsonUtilTool.toJsonObj(respjb);

		Integer uid = userTokenJb.getInteger("uid");
		String scope = userTokenJb.getString("scope");
		if ("ScopeEnum::Super".equals(scope)) {
			// 非super账号，不能在参数中带uid
		}
		List<UserAddress> userAddresses = userAddressMapper.selectByUserId(uid);

		if (userAddresses == null || userAddresses.isEmpty()) {
			throw new InvalidParameterException("用户收货地址不存在，下单失败");
		}

		return userAddresses;
	}

	public List<UserAddress> selectByUserId(Integer uid) {
		return userAddressMapper.selectByUserId(uid);
	}
}
