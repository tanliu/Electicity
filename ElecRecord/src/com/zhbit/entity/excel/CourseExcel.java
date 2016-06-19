package com.zhbit.entity.excel;

import java.sql.Timestamp;

import org.zhbit.excel.annotation.Lang;

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
public class CourseExcel extends BaseExcelBean implements java.io.Serializable,Cloneable {


	
	@Lang(value="课程名称",isNull=Lang.TYPE_NONULL)
	private String courseName;
	@Lang(value="教师姓名",isNull=Lang.TYPE_NONULL)
	private String employName;
	@Lang(value="选课课号",isNull=Lang.TYPE_NONULL)
	private String selectedCourseNo;
	@Lang(value="课程性质",isNull=Lang.TYPE_NONULL)
	private String courseType;
	@Lang(value="总学时",isNull=Lang.TYPE_NONULL,isNum=Lang.TYPE_ISNUM)
	private String totalHours;
	@Lang(value="实验学时",isNull=Lang.TYPE_NONULL,isNum=Lang.TYPE_ISNUM)
	private String labHours;
	@Lang(value="教学班组成")
	private String classInfo;
	@Lang(value="已选",isNum=Lang.TYPE_ISNUM)
	private String studentNum;

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public CourseExcel() {
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

	public String getSelectedCourseNo() {
		return selectedCourseNo;
	}

	public void setSelectedCourseNo(String selectedCourseNo) {
		this.selectedCourseNo = selectedCourseNo;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public String getLabHours() {
		return labHours;
	}

	public void setLabHours(String labHours) {
		this.labHours = labHours;
	}

	public String getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(String classInfo) {
		this.classInfo = classInfo;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}



}