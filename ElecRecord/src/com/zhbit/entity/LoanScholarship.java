package com.zhbit.entity;
// default package

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TLoanScholarship entity. @author MyEclipse Persistence Tools
 */

public class LoanScholarship implements java.io.Serializable ,Cloneable{

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
	private String sex;
	@Transform(name="身份证号")
	private String idCardNo;
	private String orgId;
	private String orgName;
	@Transform(name="专业")
	private String major;
	@Transform(name="班级")
	private String className;
	@Transform(name="年级")
	private String grade;
	@Transform(name="贷款金额")
	private Double loanAmount;
	@Transform(name="是否通过专业学院资格审核")
	private String censoredFlag;
	@Transform(name="被拒绝原因")
	private String refuseReason;
	@Transform(name="备注")
	private String memo;
	private String academicYear;
	private String term;
	private Timestamp createTime;
	private String creator;
	private String repayFlag;
	private Double repayAmount;
	private Timestamp repayDate;
	private Timestamp modifyDate;
	private String modifier;

	// Constructors

	/** default constructor */
	public LoanScholarship() {
	}

	/** minimal constructor */
	public LoanScholarship(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public LoanScholarship(String stuId, String studentNo, String stuName,
			String sex, String idCardNo, String orgId, String orgName,
			String major, String className, String grade, Double loanAmount,
			String censoredFlag, String refuseReason, String memo,
			String academicYear, String term, Timestamp createTime,
			String creator, String repayFlag, Double repayAmount,
			Timestamp repayDate, Timestamp modifyDate, String modifier) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.idCardNo = idCardNo;
		this.orgId = orgId;
		this.orgName = orgName;
		this.major = major;
		this.className = className;
		this.grade = grade;
		this.loanAmount = loanAmount;
		this.censoredFlag = censoredFlag;
		this.refuseReason = refuseReason;
		this.memo = memo;
		this.academicYear = academicYear;
		this.term = term;
		this.createTime = createTime;
		this.creator = creator;
		this.repayFlag = repayFlag;
		this.repayAmount = repayAmount;
		this.repayDate = repayDate;
		this.modifyDate = modifyDate;
		this.modifier = modifier;
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

	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Double getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCensoredFlag() {
		return this.censoredFlag;
	}

	public void setCensoredFlag(String censoredFlag) {
		this.censoredFlag = censoredFlag;
	}

	public String getRefuseReason() {
		return this.refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
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

	public String getRepayFlag() {
		return this.repayFlag;
	}

	public void setRepayFlag(String repayFlag) {
		this.repayFlag = repayFlag;
	}

	public Double getRepayAmount() {
		return this.repayAmount;
	}

	public void setRepayAmount(Double repayAmount) {
		this.repayAmount = repayAmount;
	}

	public Timestamp getRepayDate() {
		return this.repayDate;
	}

	public void setRepayDate(Timestamp repayDate) {
		this.repayDate = repayDate;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

}