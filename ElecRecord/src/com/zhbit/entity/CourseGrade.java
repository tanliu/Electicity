package com.zhbit.entity;


import java.sql.Timestamp;

import com.zhbit.annotation.Transform;



/**
 * @author Administrator
 *
 */
public class CourseGrade implements java.io.Serializable,Cloneable {



	private String id;
	private String selectId;
	@Transform(name="选课课号")
	private String selectedCourseNo;	//课程选课号;
	private String employNo; //教师
	@Transform(name="教师姓名")
	private String employName; //教师
	@Transform(name="课程性质")
	private String courseType;  //课程类型
	@Transform(name="课程名称")
	private String courseName;  //课程名称

	private String stuId;
	@Transform(name="学号")
	private String studentNo;
	@Transform(name="姓名")
	private String stuName;	
	private String orgId;
	@Transform(name="学院")
	private String orgName;
	@Transform(name="行政班")
	private String className;
	
	@Transform(name="专业代码")
	private String majorCode;
	@Transform(name="专业名称")
	private String major;
	@Transform(name="重修标记")
	private String retakeFlag;
	@Transform(name="平时成绩")
	private Double usualScore;
	@Transform(name="期中成绩")
	private Double middleScore;
	@Transform(name="期末成绩")
	private Double endScore;
	@Transform(name="实验成绩")
	private Double labScore;
	@Transform(name="总评成绩")
	private Double finalScore;
	@Transform(name="折算成绩")
	private Double convertScore;
	@Transform(name="补考成绩")
	private Double resitScore;
	@Transform(name="补考成绩备注")
	private String resitMemo;
	@Transform(name="重修成绩")
	private Double repairScore;
	@Transform(name="绩点")
	private Double gradePoint;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public CourseGrade() {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/** minimal constructor */
	public CourseGrade(String studentNo) {
		this.studentNo = studentNo;
	}

	/** full constructor */
	public CourseGrade(String stuId, String studentNo, String stuName,
			String orgId, String orgName, String className, String majorCode,
			String major, String retakeFlag, Double usualScore,
			Double middleScore, Double endScore, Double labScore,
			Double finalScore, Double convertScore, Double resitScore,
			String resitMemo, Double repairScore, Double gradePoint,
			String memo, Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.orgId = orgId;
		this.orgName = orgName;
		this.className = className;
		this.majorCode = majorCode;
		this.major = major;
		this.retakeFlag = retakeFlag;
		this.usualScore = usualScore;
		this.middleScore = middleScore;
		this.endScore = endScore;
		this.labScore = labScore;
		this.finalScore = finalScore;
		this.convertScore = convertScore;
		this.resitScore = resitScore;
		this.resitMemo = resitMemo;
		this.repairScore = repairScore;
		this.gradePoint = gradePoint;
		this.memo = memo;
		this.createTime = createTime;
		this.creator = creator;
	}

	// Property accessors
	public String getSelectId() {
		return selectId;
	}
	
	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}
	
	public String getEmployNo() {
		return employNo;
	}

	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getId() {
		return this.id;
	}

	public String getSelectedCourseNo() {
		return selectedCourseNo;
	}

	public void setSelectedCourseNo(String selectedCourseNo) {
		this.selectedCourseNo = selectedCourseNo;
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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMajorCode() {
		return this.majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRetakeFlag() {
		return this.retakeFlag;
	}

	public void setRetakeFlag(String retakeFlag) {
		this.retakeFlag = retakeFlag;
	}

	public Double getUsualScore() {
		return this.usualScore;
	}

	public void setUsualScore(Double usualScore) {
		this.usualScore = usualScore;
	}

	public Double getMiddleScore() {
		return this.middleScore;
	}

	public void setMiddleScore(Double middleScore) {
		this.middleScore = middleScore;
	}

	public Double getEndScore() {
		return this.endScore;
	}

	public void setEndScore(Double endScore) {
		this.endScore = endScore;
	}

	public Double getLabScore() {
		return this.labScore;
	}

	public void setLabScore(Double labScore) {
		this.labScore = labScore;
	}

	public Double getFinalScore() {
		return this.finalScore;
	}

	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}

	public Double getConvertScore() {
		return this.convertScore;
	}

	public void setConvertScore(Double convertScore) {
		this.convertScore = convertScore;
	}

	public Double getResitScore() {
		return this.resitScore;
	}

	public void setResitScore(Double resitScore) {
		this.resitScore = resitScore;
	}

	public String getResitMemo() {
		return this.resitMemo;
	}

	public void setResitMemo(String resitMemo) {
		this.resitMemo = resitMemo;
	}

	public Double getRepairScore() {
		return this.repairScore;
	}

	public void setRepairScore(Double repairScore) {
		this.repairScore = repairScore;
	}

	public Double getGradePoint() {
		return this.gradePoint;
	}

	public void setGradePoint(Double gradePoint) {
		this.gradePoint = gradePoint;
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