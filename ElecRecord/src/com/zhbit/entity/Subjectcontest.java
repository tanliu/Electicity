package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TSubjectcontest entity. @author MyEclipse Persistence Tools
 */

public class Subjectcontest implements java.io.Serializable {

	// Fields

	private String id;
	private String stuId;
	private String studentNo;
	private String stuName;
	private String academicYear;
	private String term;
	private String rewardName;
	private String rewardLevel;
	private String rewardGrade;
	private String grantUnits;
	private String rewardProject;
	private String guidTeacher;
	private Timestamp rewardDate;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public Subjectcontest() {
	}

	/** minimal constructor */
	public Subjectcontest(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public Subjectcontest(String stuId, String studentNo, String stuName,
			String academicYear, String term, String rewardName,
			String rewardLevel, String rewardGrade, String grantUnits,
			String rewardProject, String guidTeacher, Timestamp rewardDate,
			String memo, Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.academicYear = academicYear;
		this.term = term;
		this.rewardName = rewardName;
		this.rewardLevel = rewardLevel;
		this.rewardGrade = rewardGrade;
		this.grantUnits = grantUnits;
		this.rewardProject = rewardProject;
		this.guidTeacher = guidTeacher;
		this.rewardDate = rewardDate;
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

	public String getRewardName() {
		return this.rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getRewardLevel() {
		return this.rewardLevel;
	}

	public void setRewardLevel(String rewardLevel) {
		this.rewardLevel = rewardLevel;
	}

	public String getRewardGrade() {
		return this.rewardGrade;
	}

	public void setRewardGrade(String rewardGrade) {
		this.rewardGrade = rewardGrade;
	}

	public String getGrantUnits() {
		return this.grantUnits;
	}

	public void setGrantUnits(String grantUnits) {
		this.grantUnits = grantUnits;
	}

	public String getRewardProject() {
		return this.rewardProject;
	}

	public void setRewardProject(String rewardProject) {
		this.rewardProject = rewardProject;
	}

	public String getGuidTeacher() {
		return this.guidTeacher;
	}

	public void setGuidTeacher(String guidTeacher) {
		this.guidTeacher = guidTeacher;
	}

	public Timestamp getRewardDate() {
		return this.rewardDate;
	}

	public void setRewardDate(Timestamp rewardDate) {
		this.rewardDate = rewardDate;
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