package com.zhbit.entity;
// default package

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TGrantScholarship entity. @author MyEclipse Persistence Tools
 */

public class GrantScholarship implements java.io.Serializable,Cloneable {

	// Fields

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private String id;
	private String stuId;
	@Transform(name="学号")
	private String studentNo;
	@Transform(name="姓名")
	private String stuName;
	@Transform(name="性别")
	private String sex;
	private String politicalStatus;
	@Transform(name="民族")
	private String nation;
	private String orgId;
	@Transform(name="学院")
	private String orgName;
	@Transform(name="专业")
	private String major;
	@Transform(name="入学年月")
	private String acceptanceDate;
	@Transform(name="经济困难程度")
	private String familyEconomic;
	@Transform(name="备注")
	private String memo;
	private String academicYear;
	private String term;
	private Timestamp reportDate;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public GrantScholarship() {
	}

	/** minimal constructor */
	public GrantScholarship(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public GrantScholarship(String stuId, String studentNo, String stuName,
			String sex, String politicalStatus, String nation, String orgId,
			String orgName, String major, String acceptanceDate,
			String familyEconomic, String memo, String academicYear,
			String term, Timestamp reportDate, Timestamp createTime,
			String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.politicalStatus = politicalStatus;
		this.nation = nation;
		this.orgId = orgId;
		this.orgName = orgName;
		this.major = major;
		this.acceptanceDate = acceptanceDate;
		this.familyEconomic = familyEconomic;
		this.memo = memo;
		this.academicYear = academicYear;
		this.term = term;
		this.reportDate = reportDate;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAcceptanceDate() {
		return this.acceptanceDate;
	}

	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public String getFamilyEconomic() {
		return this.familyEconomic;
	}

	public void setFamilyEconomic(String familyEconomic) {
		this.familyEconomic = familyEconomic;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public Timestamp getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
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