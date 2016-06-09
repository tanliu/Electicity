package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TPostinfo entity. @author MyEclipse Persistence Tools
 */

public class Postinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String emsno;
	private String schoolNo;
	private String stuId;
	private String studentNo;
	private String stuName;
	private String major;
	private String sex;
	private String dispatchType;
	private String chargeUnit;
	private String mailNo;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public Postinfo() {
	}

	/** minimal constructor */
	public Postinfo(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public Postinfo(String emsno, String schoolNo, String stuId,
			String studentNo, String stuName, String major, String sex,
			String dispatchType, String chargeUnit, String mailNo, String memo,
			Timestamp createTime, String creator) {
		this.emsno = emsno;
		this.schoolNo = schoolNo;
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.major = major;
		this.sex = sex;
		this.dispatchType = dispatchType;
		this.chargeUnit = chargeUnit;
		this.mailNo = mailNo;
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

	public String getEmsno() {
		return this.emsno;
	}

	public void setEmsno(String emsno) {
		this.emsno = emsno;
	}

	public String getSchoolNo() {
		return this.schoolNo;
	}

	public void setSchoolNo(String schoolNo) {
		this.schoolNo = schoolNo;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDispatchType() {
		return this.dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getChargeUnit() {
		return this.chargeUnit;
	}

	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public String getMailNo() {
		return this.mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
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