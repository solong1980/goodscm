package com.xlw.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlw.sys.MapUtils;
import com.xlw.sys.dao.SysUserRoleMapper;
import com.xlw.sys.model.SysUserRole;
import com.xlw.sys.service.SysUserRoleService;

/**
 * 用户与角色对应关系
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		// 先删除用户与角色关系
		sysUserRoleMapper.deleteByMap(new MapUtils().put("user_id", userId));

		if (roleIdList == null || roleIdList.size() == 0) {
			return;
		}

		// 保存用户与角色关系
		List<SysUserRole> list = new ArrayList<>(roleIdList.size());
		for (Long roleId : roleIdList) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(userId);
			sysUserRole.setRoleId(roleId);

			list.add(sysUserRole);
		}
		sysUserRoleMapper.insertBatch(list);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return sysUserRoleMapper.queryRoleIdList(userId);
	}

	@Override
	public int deleteBatch(Long[] roleIds) {
		return sysUserRoleMapper.deleteBatch(roleIds);
	}
}
