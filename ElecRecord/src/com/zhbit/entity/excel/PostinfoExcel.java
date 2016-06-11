package com.zhbit.entity.excel;

import java.sql.Timestamp;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;


@ExcelVoConfig
public class PostinfoExcel extends BaseExcelVo {

	// Fields
	@Lang(value="EMS编号")
	private String emsno;   //	EMS编号
	@Lang(value="北理工编号")
	private String schoolNo;  //北理工编号
	@Lang(value="专业名称")
	private String major;	  //专业
	@Lang(value="姓名")
	private String stuName;    //姓名
	@Lang(value = "学号")
	private String studentNo;	
	@Lang(value="性别")
	private String sex;		//性别
	@Lang(value="派遣性质")
	private String dispatchType;	//派遣性质
	@Lang(value="主管单位")
	private String chargeUnit;    //主管单位
	@Lang(value="邮件号")
	private String mailNo;		//邮件号

	
	// Constructors

	/** default constructor */
	public PostinfoExcel() {
	}

	

	/** full constructor */
	public PostinfoExcel(String emsno, String schoolNo,String studentNo, String stuName, String major, String sex,
			String dispatchType, String chargeUnit, String mailNo) {
		this.emsno = emsno;
		this.schoolNo = schoolNo;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.major = major;
		this.sex = sex;
		this.dispatchType = dispatchType;
		this.chargeUnit = chargeUnit;
		this.mailNo = mailNo;
	}



	public String getEmsno() {
		return emsno;
	}



	public void setEmsno(String emsno) {
		this.emsno = emsno;
	}



	public String getSchoolNo() {
		return schoolNo;
	}



	public void setSchoolNo(String schoolNo) {
		this.schoolNo = schoolNo;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public String getStuName() {
		return stuName;
	}



	public void setStuName(String stuName) {
		this.stuName = stuName;
	}



	public String getStudentNo() {
		return studentNo;
	}



	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getDispatchType() {
		return dispatchType;
	}



	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}



	public String getChargeUnit() {
		return chargeUnit;
	}



	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}



	public String getMailNo() {
		return mailNo;
	}



	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}



	@Override
	public int getHashVal() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Property accessors

}