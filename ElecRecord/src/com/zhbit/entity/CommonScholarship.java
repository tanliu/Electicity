package com.zhbit.entity;
// default package

import java.sql.Timestamp;

/**
 * TCommonScholarship entity. @author MyEclipse Persistence Tools
 */

public class CommonScholarship implements java.io.Serializable {

	// Fields

	private String id;
	private String stuId;
	private String studentNo;
	private String stuName;
	private String major;
	private String rewardName;
	private String academicYear;
	private String term;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public CommonScholarship() {
	}

	/** minimal constructor */
	public CommonScholarship(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public CommonScholarship(String stuId, String studentNo, String stuName,
			String major, String rewardName, String academicYear, String term,
			String memo, Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.major = major;
		this.rewardName = rewardName;
		this.academicYear = academicYear;
		this.term = term;
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

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRewardName() {
		return this.rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
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