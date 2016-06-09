package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class StudentDutysExcel extends BaseExcelVo{
		
		
		@Lang(value="年级")
		private String grade;  //年级
		@Lang(value="学院")
		private String college; //学院
		@Lang(value="班级")
		private String className;  //班级
		@Lang(value="姓名")
		private String stuName;    //姓名
		@Lang(value="性别")
		private String sex;		//性别
		@Lang(value="职务")
		private String duty;	//职务
		@Lang(value="手机")
		private String telNo;    //手机
		@Lang(value="短号")
		private String shortTelNo;		//短号
		@Lang(value="宿舍")
		private String address;		//宿舍
		// Constructors

		/** default constructor */
		public StudentDutysExcel() {
		}

		
	@Override
	public int getHashVal() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getTelNo() {
		return telNo;
	}


	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}


	public String getShortTelNo() {
		return shortTelNo;
	}


	public void setShortTelNo(String shortTelNo) {
		this.shortTelNo = shortTelNo;
	}


	public String getDuty() {
		return duty;
	}


	public void setDuty(String duty) {
		this.duty = duty;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
}