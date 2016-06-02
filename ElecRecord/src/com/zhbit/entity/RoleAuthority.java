package com.zhbit.entity;


public class RoleAuthority implements java.io.Serializable {


	private String id;
	private Authority authority;
	private Role role;

	public RoleAuthority() {
	}

	public RoleAuthority(Authority authority, Role role) {
		this.authority = authority;
		this.role = role;
	}


	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}



}