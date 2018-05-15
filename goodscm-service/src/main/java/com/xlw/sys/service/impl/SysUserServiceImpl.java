package com.xlw.sys.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xlw.goodscm.pojo.CmPage;
import com.xlw.sys.dao.SysUserMapper;
import com.xlw.sys.model.SysUser;
import com.xlw.sys.service.SysUserRoleService;
import com.xlw.sys.service.SysUserService;
import com.xlw.sys.shiro.ShiroUtils;


/**
 * 系统用户
 */
@Service("sysUserService")
public class SysUserServiceImpl  implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserRoleService sysUserRoleService;


	@Override
	public CmPage<SysUser, List<SysUser>> queryPage(CmPage<SysUser, List<SysUser>> page) {
		return null;
	}
	
	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return sysUserMapper.queryAllMenuId(userId);
	}

	 

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUser user) {
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		sysUserMapper.insert(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUser user) {
		if(StringUtils.isEmpty(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		}
		sysUserMapper.updateByPrimaryKey(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	/**
	 * 修改密码，需要原密码（此处使用的是加密后的密码串）
	 */
	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
        return sysUserMapper.updatePassword(userId,password,newPassword);
    }

}
