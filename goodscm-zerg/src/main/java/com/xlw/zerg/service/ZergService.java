package com.xlw.zerg.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.xlw.goodscm.utils.JsonUtilTool;
import com.xlw.zerg.WXPublicUtils;

public class ZergService {

	@Autowired
	protected Cache<String, String> tokenCache;

	// 写入缓存
	protected String saveToCache(JSONObject resp) {
		String key = WXPublicUtils.generateToken();
		String value = JsonUtilTool.toJson(resp);

		tokenCache.put(key, value);
		return key;
	}

	protected Integer getCurUserId(String token) {
		if (token == null)
			throw new InvalidParameterException("miss head parameter 'token'");
		// 设置user id
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
		return uid;
	}
}
