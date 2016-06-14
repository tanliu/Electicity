package com.zhbit.entity.excel;
// default package

import java.sql.Timestamp;

import org.zhbit.excel.annotation.Lang;


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
public class FamilyExcel extends BaseExcelBean implements java.io.Serializable ,Cloneable{


	@Lang(value="学号")
	private String studentNo;
	@Lang(value="姓名")
	private String stuName;
	@Lang(value="家庭住址")
	private String addrees;
	@Lang(value="家庭邮编")
	private String familypostCode;
	@Lang(value="家庭电话")
	private String familyTelNo;
	
	
	@Lang(value="父亲姓名")
	private String fname;
	@Lang(value="FQZZMM")
	private String fpoliticalStatus;
	@Lang(value="父亲单位电话")
	private String ftelNo;
	@Lang(value="父亲单位")
	private String fcompany;
	@Lang(value="父亲单位邮编")
	private String fpostCode;

	@Lang(value="母亲姓名")
	private String mname;
	@Lang(value="MQZZMM")
	private String mpoliticalStatus;
	@Lang(value="母亲单位电话")
	private String mtelNo;
	@Lang(value="母亲单位")
	private String mcompany;
	@Lang(value="母亲单位邮编")
	private String mpostCode;

	public FamilyExcel() {
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getAddrees() {
		return addrees;
	}

	public void setAddrees(String addrees) {
		this.addrees = addrees;
	}

	public String getFamilypostCode() {
		return familypostCode;
	}

	public void setFamilypostCode(String familypostCode) {
		this.familypostCode = familypostCode;
	}

	public String getFamilyTelNo() {
		return familyTelNo;
	}

	public void setFamilyTelNo(String familyTelNo) {
		this.familyTelNo = familyTelNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFpoliticalStatus() {
		return fpoliticalStatus;
	}

	public void setFpoliticalStatus(String fpoliticalStatus) {
		this.fpoliticalStatus = fpoliticalStatus;
	}

	public String getFtelNo() {
		return ftelNo;
	}

	public void setFtelNo(String ftelNo) {
		this.ftelNo = ftelNo;
	}

	public String getFcompany() {
		return fcompany;
	}

	public void setFcompany(String fcompany) {
		this.fcompany = fcompany;
	}

	public String getFpostCode() {
		return fpostCode;
	}

	public void setFpostCode(String fpostCode) {
		this.fpostCode = fpostCode;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpoliticalStatus() {
		return mpoliticalStatus;
	}

	public void setMpoliticalStatus(String mpoliticalStatus) {
		this.mpoliticalStatus = mpoliticalStatus;
	}

	public String getMtelNo() {
		return mtelNo;
	}

	public void setMtelNo(String mtelNo) {
		this.mtelNo = mtelNo;
	}

	public String getMcompany() {
		return mcompany;
	}

	public void setMcompany(String mcompany) {
		this.mcompany = mcompany;
	}

	public String getMpostCode() {
		return mpostCode;
	}

	public void setMpostCode(String mpostCode) {
		this.mpostCode = mpostCode;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



}