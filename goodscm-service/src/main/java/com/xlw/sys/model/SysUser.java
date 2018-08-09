package com.xlw.sys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 系统用户
 * 
 * @date 2016年9月18日 上午9:28:55
 */
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	/**
	 * 原密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String originPassword;
	
	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	@NotBlank(message = "邮箱不能为空")
	@Email(message = "邮箱格式不正确")
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态 0：禁用 1：正常
	 */
	private Integer status;

	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList;

	/**
	 * 角色列表
	 */
	private List<SysRole> roleList;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 部门ID
	 */
	//@NotNull(message = "部门不能为空")
	private Long deptId;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 设置：
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：
	 * 
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置：用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置：密码
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	public String getOriginPassword() {
		return originPassword;
	}

	public void setOriginPassword(String originPassword) {
		this.originPassword = originPassword;
	}

	/**
	 * 设置：邮箱
	 * 
	 * @param email
	 *            邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：手机号
	 * 
	 * @param mobile
	 *            手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号
	 * 
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置：状态 0：禁用 1：正常
	 * 
	 * @param status
	 *            状态 0：禁用 1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态 0：禁用 1：正常
	 * 
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：创建时间
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * 
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	private Serializable sessionId;

	public Serializable getSessionId() {
		return sessionId;
	}

	public void setSessionId(Serializable sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", username=" + username + "]";
	}
	
	
}
