package com.zhbit.entity;

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;



/** 
 * 项目名称：ElecRecord
 * 类名称：Course 
 * 类描述： 开课信息的实体
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:43:57
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:43:57
 * 修改备注： 
 * @version 
 */ 
public class Course implements java.io.Serializable,Cloneable {


	private String id;
	private String courseCode;
	@Transform(name="课程名称")
	private String courseName;
	private String academicYear;
	private String term;
	private String employNo;
	@Transform(name="教师姓名")
	private String employName;
	@Transform(name="选课课号")
	private String selectedCourseNo;
	@Transform(name="课程性质")
	private String courseType;
	@Transform(name="总学时")
	private Integer totalHours;
	@Transform(name="实验学时")
	private Integer labHours;
	@Transform(name="教学班组成")
	private String classInfo;
	@Transform(name="已选")
	private Integer studentNum;
	private Double credit;
	private String belongTo;
	private String memo;
	private Timestamp createTime;
	private String creator;

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Course() {
	}

	public Course(String courseCode, String courseName,
			String academicYear, String term, String employNo,
			String employName, String selectedCourseNo, String courseType,
			Integer totalHours, Integer labHours, String classInfo,
			Integer studentNum, Double credit, String belongTo, String memo,
			Timestamp createTime, String creator) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.academicYear = academicYear;
		this.term = term;
		this.employNo = employNo;
		this.employName = employName;
		this.selectedCourseNo = selectedCourseNo;
		this.courseType = courseType;
		this.totalHours = totalHours;
		this.labHours = labHours;
		this.classInfo = classInfo;
		this.studentNum = studentNum;
		this.credit = credit;
		this.belongTo = belongTo;
		this.memo = memo;
		this.createTime = createTime;
		this.creator = creator;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getEmployNo() {
		return this.employNo;
	}

	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}

	public String getEmployName() {
		return this.employName;
	}

	public void setEmployName(String employName) {
		this.employName = employName;
	}

	public String getSelectedCourseNo() {
		return this.selectedCourseNo;
	}

	public void setSelectedCourseNo(String selectedCourseNo) {
		this.selectedCourseNo = selectedCourseNo;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Integer getTotalHours() {
		return this.totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getLabHours() {
		return this.labHours;
	}

	public void setLabHours(Integer labHours) {
		this.labHours = labHours;
	}

	public String getClassInfo() {
		return this.classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public Integer getStudentNum() {
		return this.studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getBelongTo() {
		return this.belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
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