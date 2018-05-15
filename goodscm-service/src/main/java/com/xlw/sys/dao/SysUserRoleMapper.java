package com.xlw.sys.dao;

import java.util.List;
import java.util.Map;

import com.xlw.sys.model.SysUserRole;

public interface SysUserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUserRole record);

	SysUserRole selectByPrimaryKey(Long id);

	List<SysUserRole> selectAll();

	int updateByPrimaryKey(SysUserRole record);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);

	void deleteByMap(Map<String,Object> params);

	void insertBatch(List<SysUserRole> list);
}