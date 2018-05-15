package com.xlw.sys.service;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * 
 * @date 2016年9月18日 上午9:42:30
 */
public interface SysRoleMenuService {

	void saveOrUpdate(Long roleId, List<Long> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);

	void deleteByMap(Map<String,Object> put);

}
