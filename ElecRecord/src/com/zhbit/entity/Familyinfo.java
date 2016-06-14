package com.zhbit.entity;
// default package

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;


/** 
 * 项目名称：ElecRecord
 * 类名称：Familyinfo 
 * 类描述： 家庭信息实体类
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午1:47:38
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午1:47:38
 * 修改备注： 
 * @version 
 */ 
public class Familyinfo implements java.io.Serializable ,Cloneable{


	private String id;
	private String stuId;
	@Transform(name="学号")
	private String studentNo;
	@Transform(name="姓名")
	private String stuName;
	@Transform(name="")
	private String relation;
	@Transform(name="父亲姓名")
	private String name;
	@Transform(name="FQZZMM")
	private String politicalStatus;
	private String jobDuty;
	@Transform(name="父亲单位电话")
	private String telNo;
	@Transform(name="父亲单位")
	private String company;
	private String companyAddress;
	@Transform(name="父亲单位邮编")
	private String postCode;
	private Timestamp createTime;
	private String creator;

	public Familyinfo() {
	}

	/** minimal constructor */
	public Familyinfo(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public Familyinfo(String stuId, String studentNo, String stuName,
			String relation, String name, String politicalStatus,
			String jobDuty, String telNo, String company,
			String companyAddress, String postCode, Timestamp createTime,
			String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.relation = relation;
		this.name = name;
		this.politicalStatus = politicalStatus;
		this.jobDuty = jobDuty;
		this.telNo = telNo;
		this.company = company;
		this.companyAddress = companyAddress;
		this.postCode = postCode;
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

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getJobDuty() {
		return this.jobDuty;
	}

	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}