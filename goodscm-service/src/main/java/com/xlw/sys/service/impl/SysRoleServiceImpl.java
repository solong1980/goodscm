package com.xlw.sys.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xlw.goodscm.pojo.CmPage;
import com.xlw.sys.dao.SysRoleMapper;
import com.xlw.sys.model.SysRole;
import com.xlw.sys.service.SysRoleMenuService;
import com.xlw.sys.service.SysRoleService;
import com.xlw.sys.service.SysUserRoleService;


/**
 * 角色
 */
@Service 
public class SysRoleServiceImpl  implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Override
	public CmPage<SysRole, List<SysRole>> queryPage(CmPage<SysRole, List<SysRole>> page) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleMapper.insert(role);

		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysRole role) {
		sysRoleMapper.updateByPrimaryKey(role);

		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] roleIds) {
		//删除角色
		sysRoleMapper.deleteBatchIds(Arrays.asList(roleIds));

		//删除角色与菜单关联
		sysRoleMenuService.deleteBatch(roleIds);

		//删除角色与用户关联
		sysUserRoleService.deleteBatch(roleIds);
	}
}
