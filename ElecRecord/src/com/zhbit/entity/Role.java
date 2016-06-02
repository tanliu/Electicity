package com.zhbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/** 
 * 项目名称：ElecRecord
 * 类名称：Role 
 * 类描述： 角色实体
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午4:00:57
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午4:00:57
 * 修改备注： 
 * @version 
 */ 
public class Role implements java.io.Serializable {


	private String roleId;
	private String roleName;
	private Timestamp createTime;
	private String roleNo;
	private String memo;
	private Set<RoleAuthority> roleAuthorities;
	private Set<UserRole> userRoles;


	public Role() {
	}


	public Role(String roleName, Timestamp createTime, String roleNo,
			String memo, Set<RoleAuthority> roleAuthorities, Set<UserRole> userRoles) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.roleNo = roleNo;
		this.memo = memo;
		this.roleAuthorities = roleAuthorities;
		this.userRoles = userRoles;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public String getRoleNo() {
		return roleNo;
	}


	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public Set<RoleAuthority> getRoleAuthorities() {
		return roleAuthorities;
	}


	public void setRoleAuthorities(Set<RoleAuthority> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}







}