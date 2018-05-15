package com.xlw.sys.dao;

import com.xlw.sys.model.SysUser;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(SysUser record);

	SysUser selectByPrimaryKey(Long userId);

	List<SysUser> selectAll();

	int updateByPrimaryKey(SysUser record);

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 *            用户ID
	 */
	List<String> queryAllPerms(Long userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户账号查询一条记录
	 * 
	 * @param user
	 * @return
	 */
	SysUser selectOne(SysUser user);

	boolean updatePassword(@Param("userId") Long userId, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);
}