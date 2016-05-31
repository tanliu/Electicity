package com.zhbit.entity;


import java.util.HashSet;
import java.util.Set;



public class Authority implements java.io.Serializable {

	// Fields

	private String authorityId;
	private String parentId;
	private String parentIds;
	private String authorityName;
	private Integer authorityType;
	private String moduleName;
	private String url;
	private String operation;
	private String menuNo;
	private String memo;
/*	private Set tbSysRoleAuthorities = new HashSet(0);*/


	public Authority() {
	}

	/** minimal constructor */
	public Authority(String authorityName, Integer authorityType) {
		this.authorityName = authorityName;
		this.authorityType = authorityType;
	}

	/** full constructor */
	public Authority(String parentId, String parentIds,
			String authorityName, Integer authorityType, String moduleName,
			String url, String operation, String menuNo, String memo/*,
			Set tbSysRoleAuthorities*/) {
		this.parentId = parentId;
		this.parentIds = parentIds;
		this.authorityName = authorityName;
		this.authorityType = authorityType;
		this.moduleName = moduleName;
		this.url = url;
		this.operation = operation;
		this.menuNo = menuNo;
		this.memo = memo;
		//this.tbSysRoleAuthorities = tbSysRoleAuthorities;
	}



	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return this.parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public Integer getAuthorityType() {
		return this.authorityType;
	}

	public void setAuthorityType(Integer authorityType) {
		this.authorityType = authorityType;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMenuNo() {
		return this.menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

/*	public Set getTbSysRoleAuthorities() {
		return this.tbSysRoleAuthorities;
	}

	public void setTbSysRoleAuthorities(Set tbSysRoleAuthorities) {
		this.tbSysRoleAuthorities = tbSysRoleAuthorities;
	}*/

}