package com.xlw.sys.service;

import java.util.List;

import com.xlw.goodscm.pojo.CmPage;
import com.xlw.sys.model.SysUser;

/**
 * 系统用户
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService {

	CmPage<SysUser, List<SysUser>> queryPage(CmPage<SysUser, List<SysUser>> page);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 保存用户
	 */
	void save(SysUser user);

	/**
	 * 修改用户
	 */
	void update(SysUser user);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 *            用户ID
	 * @param password
	 *            原密码
	 * @param newPassword
	 *            新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);
	
	/**
	 * 管理员重置密码
	 * @param sysUser
	 * @return
	 */
	boolean resetPassword(SysUser sysUser);
}
