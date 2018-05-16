package com.xlw.sys.dao;

import com.xlw.sys.model.SysRole;
import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

	void deleteBatchIds(List<Long> asList);
	
	/**
	 * 查询用户角色列表
	 * @param userId
	 */
	List<SysRole> queryUserRoleList(Long userId);
}