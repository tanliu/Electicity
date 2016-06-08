package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * 系统的登录日志
 */

public class LoginLog implements java.io.Serializable {


	private String logicId;  //id
	private String employNo; //用户帐号
	private Timestamp loginTime; //登录的时间
	private String loginIp;     //登录ip
	private Integer ifSuccess;  //登录是否成功

	public final static Integer LOGIN_STATE_SUCCESS=1; 
	public final static Integer LOGIN_STATE_FAIL=0; 

	public LoginLog() {
	}

	public LoginLog(String employNo, Timestamp loginTime, String loginIp,
			Integer ifSuccess) {
		this.employNo = employNo;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.ifSuccess = ifSuccess;
	}

//-----------------------getter&&setter------------------------------
	public String getLogicId() {
		return this.logicId;
	}

	public void setLogicId(String logicId) {
		this.logicId = logicId;
	}

	public String getEmployNo() {
		return this.employNo;
	}

	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getIfSuccess() {
		return this.ifSuccess;
	}

	public void setIfSuccess(Integer ifSuccess) {
		this.ifSuccess = ifSuccess;
	}

}