package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TPoliticalstatus entity. @author MyEclipse Persistence Tools
 */

/** 
 * 项目名称：ElecRecord
 * 类名称：Politicalstatus
 * 类描述： Politicalstatus实体类
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:07:07
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:07:07
 * 修改备注： 
 * @version 
 */
public class Politicalstatus implements java.io.Serializable {

	// Fields

	private String id;
	private String stuId;
	private String studentNo;
	private String stuName;
	private Timestamp joinDate;
	private String politicalStatus;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public Politicalstatus() {
	}

	/** minimal constructor */
	public Politicalstatus(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public Politicalstatus(String stuId, String studentNo, String stuName,
			Timestamp joinDate, String politicalStatus, String memo,
			Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.joinDate = joinDate;
		this.politicalStatus = politicalStatus;
		this.memo = memo;
		this.createTime = createTime;
		this.creator = creator;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Timestamp getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}