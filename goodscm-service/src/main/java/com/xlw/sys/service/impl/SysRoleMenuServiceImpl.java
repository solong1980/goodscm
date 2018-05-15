package com.xlw.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xlw.sys.dao.SysRoleMenuMapper;
import com.xlw.sys.model.SysRoleMenu;
import com.xlw.sys.service.SysRoleMenuService;



/**
 * 角色与菜单对应关系
 */
@Service
public class SysRoleMenuServiceImpl  implements SysRoleMenuService {
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		//先删除角色与菜单关系
		deleteBatch(new Long[]{roleId});

		if(menuIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		List<SysRoleMenu> list = new ArrayList<>(menuIdList.size());
		for(Long menuId : menuIdList){
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setMenuId(menuId);
			sysRoleMenu.setRoleId(roleId);

			list.add(sysRoleMenu);
		}
		sysRoleMenuMapper.insertBatch(list);
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return sysRoleMenuMapper.queryMenuIdList(roleId);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return sysRoleMenuMapper.deleteBatch(roleIds);
	}

	@Override
	public void deleteByMap(Map<String, Object> params) {
		sysRoleMenuMapper.deleteByMap(params);
	}

}
