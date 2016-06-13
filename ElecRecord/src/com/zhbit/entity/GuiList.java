package com.zhbit.entity;

import java.sql.Timestamp;

/**
 * TLearningguidStudentslist entity. @author MyEclipse Persistence Tools
 */

/** 
 * 项目名称：ElecRecord
 * 类名称： GuiList
 * 类描述：导学名单实体类
 * 创建人：罗建鑫
 * 创建时间：2016年6月11日 下午8:27:21
 * 修改人：罗建鑫
 * 修改时间：2016年6月11日 下午8:27:21
 * 修改备注： 
 * @version 
 */ 
public class GuiList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String stuId;
	private String studentNo;
	private String stuName;
	private String academicYear;
	private String term;
	private String className;
	private String teacherNo;
	private String teacherName;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public GuiList() {
	}

	/** minimal constructor */
	public GuiList(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public GuiList(String stuId, String studentNo,
			String stuName, String academicYear, String term, String className,
			String teacherNo, String teacherName, Timestamp createTime,
			String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.academicYear = academicYear;
		this.term = term;
		this.className = className;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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