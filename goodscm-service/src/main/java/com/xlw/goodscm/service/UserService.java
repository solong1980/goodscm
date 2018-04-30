package com.xlw.goodscm.service;

import com.xlw.goodscm.model.User;

/**
 * @author longlianghua
 */
public interface UserService {
	public User queryUser(User user);

	public User findByAccount(String account);
}
