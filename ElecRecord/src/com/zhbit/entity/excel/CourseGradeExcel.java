package com.zhbit.entity.excel;


import java.sql.Timestamp;

import org.zhbit.excel.annotation.Lang;




/**
 * @author Administrator
 *
 */
public class CourseGradeExcel extends BaseExcelBean implements java.io.Serializable,Cloneable {



	private String selectId;
	@Lang(value="选课课号")
	private String selectedCourseNo;	//课程选课号;
	private String employNo; //教师
	@Lang(value="教师姓名")
	private String employName; //教师
	@Lang(value="课程性质")
	private String courseType;  //课程类型
	@Lang(value="课程名称")
	private String courseName;  //课程名称

	@Lang(value="学号")
	private String studentNo;
	@Lang(value="姓名")
	private String orgId;
	@Lang(value="学院")
	private String orgName;
	@Lang(value="行政班")
	private String className;
	
	@Lang(value="专业代码")
	private String majorCode;
	@Lang(value="专业名称")
	private String major;
	@Lang(value="重修标记")
	private String retakeFlag;
	@Lang(value="平时成绩")
	private String usualScore;
	@Lang(value="期中成绩")
	private String middleScore;
	@Lang(value="期末成绩")
	private String endScore;
	@Lang(value="实验成绩")
	private String labScore;
	@Lang(value="总评成绩")
	private String finalScore;
	@Lang(value="折算成绩")
	private String convertScore;
	@Lang(value="补考成绩")
	private String resitScore;
	@Lang(value="补考成绩备注")
	private String resitMemo;
	@Lang(value="重修成绩")
	private String repairScore;
	@Lang(value="绩点")
	private String gradePoint;


	/** default constructor */
	public CourseGradeExcel() {
	}

	/** minimal constructor */
	public CourseGradeExcel(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public String getSelectedCourseNo() {
		return selectedCourseNo;
	}

	public void setSelectedCourseNo(String selectedCourseNo) {
		this.selectedCourseNo = selectedCourseNo;
	}

	public String getEmployNo() {
		return employNo;
	}

	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}

	public String getEmployName() {
		return employName;
	}

	public void setEmployName(String employName) {
		this.employName = employName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRetakeFlag() {
		return retakeFlag;
	}

	public void setRetakeFlag(String retakeFlag) {
		this.retakeFlag = retakeFlag;
	}

	public String getUsualScore() {
		return usualScore;
	}

	public void setUsualScore(String usualScore) {
		this.usualScore = usualScore;
	}

	public String getMiddleScore() {
		return middleScore;
	}

	public void setMiddleScore(String middleScore) {
		this.middleScore = middleScore;
	}

	public String getEndScore() {
		return endScore;
	}

	public void setEndScore(String endScore) {
		this.endScore = endScore;
	}

	public String getLabScore() {
		return labScore;
	}

	public void setLabScore(String labScore) {
		this.labScore = labScore;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}

	public String getConvertScore() {
		return convertScore;
	}

	public void setConvertScore(String convertScore) {
		this.convertScore = convertScore;
	}

	public String getResitScore() {
		return resitScore;
	}

	public void setResitScore(String resitScore) {
		this.resitScore = resitScore;
	}

	public String getResitMemo() {
		return resitMemo;
	}

	public void setResitMemo(String resitMemo) {
		this.resitMemo = resitMemo;
	}

	public String getRepairScore() {
		return repairScore;
	}

	public void setRepairScore(String repairScore) {
		this.repairScore = repairScore;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


}