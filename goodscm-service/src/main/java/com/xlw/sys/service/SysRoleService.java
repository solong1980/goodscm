package com.xlw.sys.service;

import java.util.List;

import com.xlw.goodscm.pojo.CmPage;
import com.xlw.sys.model.SysRole;

/**
 * 角色
 * 
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService {

	CmPage<SysRole, List<SysRole>> queryPage(CmPage<SysRole, List<SysRole>> page);

	void save(SysRole role);

	void update(SysRole role);

	void deleteBatch(Long[] roleIds);

}
