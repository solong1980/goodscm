package com.xlw.zerg.service;

import java.security.InvalidParameterException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xlw.goodscm.utils.JsonUtilTool;
import com.xlw.zerg.WxSetting;
import com.xlw.zerg.dao.UserMapper;
import com.xlw.zerg.model.User;

@Service
public class TokenService extends ZergService {

	@Autowired
	private UserMapper userMapper;

	public String tokenVerify(@RequestBody Map<String, String> to) {
		if (to != null && to.get("token") != null && tokenCache.getIfPresent(to.get("token")) != null) {
			return "{isValid:true}";
		} else
			return "{isValid:false}";
	}

	// 颁发令牌
	// 只要调用登陆就颁发新令牌
	// 但旧的令牌依然可以使用
	// 所以通常令牌的有效时间比较短
	// 目前微信的express_in时间是7200秒
	// 在不设置刷新令牌（refresh_token）的情况下
	// 只能延迟自有token的过期时间超过7200秒（目前还无法确定，在express_in时间到期后
	// 还能否进行微信支付
	// 没有刷新令牌会有一个问题，就是用户的操作有可能会被突然中断
	private String grantToken(JSONObject resp) {
		// 此处生成令牌使用的是TP5自带的令牌
		// 如果想要更加安全可以考虑自己生成更复杂的令牌
		// 比如使用JWT并加入盐，如果不加入盐有一定的几率伪造令牌
		// $token = Request::instance()->token('token', 'md5');
		String openId = resp.getString("openid");

		User user = userMapper.selectByOpenId(openId);
		Integer uid = null;
		if (user == null)
		// 借助微信的openid作为用户标识
		// 但在系统中的相关查询还是使用自己的uid
		{
			user = new User();
			user.setOpenid(openId);
			userMapper.insert(user);

		}
		uid = user.getId();

		// 写入缓存（key:令牌 value:wxResult.uid,scope）
		resp.put("uid", uid);
		resp.put("scope", "ScopeEnum::User");
		return saveToCache(resp);
	}

	public String tokenUser(String code) {
		if (code != null) {
			String url = String.format(WxSetting.wxLoginUrl, code);
			String response = HttpRequest.get(url).body();

			if (response == null) {
				throw new RuntimeException("获取session_key及openID时异常，微信内部错误");
			}
			JSONObject resjb = JsonUtilTool.fromJson(response, JSONObject.class);
			// 建议用明确的变量来表示是否成功
			// 微信服务器并不会将错误标记为400，无论成功还是失败都标记成200
			// 这样非常不好判断，只能使用errcode是否存在来判断
			boolean containsErrCode = resjb.containsKey("errcode");
			if (containsErrCode) {
				// 错误异常封装后易于扩展
				throw new RuntimeException(resjb.toJSONString());
			} else {
				return "{token:" + grantToken(resjb) + "}";
			}
		} else {
			throw new InvalidParameterException("miss code");
		}
	}
}
