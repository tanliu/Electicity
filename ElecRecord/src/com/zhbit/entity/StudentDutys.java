package com.zhbit.entity;

import org.zhbit.excel.annotation.ExcelVoConfig;

import com.zhbit.annotation.Transform;


@ExcelVoConfig
public class StudentDutys implements java.io.Serializable,Cloneable {

	// Fields

	private String id; 
	@Transform(name="学院")
	private String college; //学院
	@Transform(name="年级")
	private String grade;  //年级
	@Transform(name="班级")
	private String className;  //班级
	private String stuId;		//学生Id
	@Transform(name="学号")
	private String studentNo;	//学号
	@Transform(name="姓名")
	private String stuName;    //姓名
	@Transform(name="性别")
	private String sex;		//性别
	@Transform(name="手机")
	private String telNo;    //手机
	@Transform(name="短号")
	private String shortTelNo;		//短号
	@Transform(name="职务")
	private String duty;	//职务
	@Transform(name="宿舍")
	private String address;		//宿舍
	private String memo;		//备注

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	// Constructors

	/** default constructor */
	public StudentDutys() {
	}

	/** minimal constructor */
	public StudentDutys(String stuId, String studentNo) {
		this.stuId = stuId;
		this.studentNo = studentNo;
	}

	/** full constructor */
	public StudentDutys(String grade, String className, String stuId,
			String studentNo, String stuName, String sex, String telNo,
			String shortTelNo, String duty, String address, String memo) {
		this.grade = grade;
		this.className = className;
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.telNo = telNo;
		this.shortTelNo = shortTelNo;
		this.duty = duty;
		this.address = address;
		this.memo = memo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getShortTelNo() {
		return this.shortTelNo;
	}

	public void setShortTelNo(String shortTelNo) {
		this.shortTelNo = shortTelNo;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}