package com.xlw.sys.shiro;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xlw.sys.Constant;
import com.xlw.sys.dao.SysMenuMapper;
import com.xlw.sys.dao.SysRoleMapper;
import com.xlw.sys.dao.SysUserMapper;
import com.xlw.sys.model.SysMenu;
import com.xlw.sys.model.SysRole;
import com.xlw.sys.model.SysUser;

/**
 * 认证
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserMapper sysUserMapper;
 
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser user = (SysUser)principals.getPrimaryPrincipal();
		Long userId = user.getUserId();
		
		List<String> permsList;
		
		//系统管理员，拥有最高权限
		if(userId == Constant.SUPER_ADMIN){
			List<SysMenu> menuList = sysMenuMapper.selectAll();
			permsList = new ArrayList<>(menuList.size());
			for(SysMenu menu : menuList){
				permsList.add(menu.getPerms());
			}
		}else{
			permsList = sysUserMapper.queryAllPerms(userId);
		}

		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StringUtils.isEmpty(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		
		List<Long> userRoleIds = new ArrayList<>();
		Set<String> userRoleIdentifiers = new HashSet<>();
		List<SysRole> userRoles = sysRoleMapper.queryUserRoleList(userId);
		if(userRoles!=null) {
			for (SysRole sysRole : userRoles) {
				userRoleIds.add(sysRole.getRoleId());
				userRoleIdentifiers.add(sysRole.getRoleName());
			}
			user.setRoleIdList(userRoleIds);
			info.setRoles(userRoleIdentifiers);
		}
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

		//查询用户信息
		SysUser user = new SysUser();
		user.setUsername(token.getUsername());
		user = sysUserMapper.selectOne(user);

		//账号不存在
		if(user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
		return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
