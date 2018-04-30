package com.xlw.goodscm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.goodscm.dao.UserMapper;
import com.xlw.goodscm.model.User;
import com.xlw.goodscm.service.UserService;

/**
 * @author longlianghua
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User queryUser(User user) {
		return userMapper.selectByAccount(user.getAccount());
	}

	@Override
	public User findByAccount(String account) {
		return userMapper.selectByAccount(account);
	};
}
