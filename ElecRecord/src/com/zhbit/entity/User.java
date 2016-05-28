package com.zhbit.entity;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class User implements java.io.Serializable {

	// Fields

	private String userId;   //用户id
	private Organization organization;
	private String employNo;
	private String employName;
	private Timestamp createTime;
	private Integer sex;
	private String tell;
	private Integer status;
	private String address;
	private String email;
	private String password;
	private String userType;
	//private Set userRoles = new HashSet(0);


	public User() {
	}

	public User(Organization organization, String employNo,
			String employName, Timestamp createTime, Integer sex, String tell,
			Integer status, String address, String email, String password,
			String userType/*, Set userRoles*/) {
		this.organization = organization;
		this.employNo = employNo;
		this.employName = employName;
		this.createTime = createTime;
		this.sex = sex;
		this.tell = tell;
		this.status = status;
		this.address = address;
		this.email = email;
		this.password = password;
		this.userType = userType;
		//this.userRoles = userRoles;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getEmployNo() {
		return this.employNo;
	}

	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}

	public String getEmployName() {
		return this.employName;
	}

	public void setEmployName(String employName) {
		this.employName = employName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTell() {
		return this.tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

/*	public Set getTbSysUserRoles() {
		return this.userRoles;
	}

	public void setTbSysUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}
*/
}