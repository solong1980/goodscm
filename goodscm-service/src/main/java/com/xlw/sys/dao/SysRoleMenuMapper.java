package com.xlw.sys.dao;

import com.xlw.sys.model.SysRoleMenu;
import java.util.List;
import java.util.Map;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    List<SysRoleMenu> selectAll();

    int updateByPrimaryKey(SysRoleMenu record);
    

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);

	void insertBatch(List<SysRoleMenu> list);

	void deleteByMap(Map<String, Object> params);
}