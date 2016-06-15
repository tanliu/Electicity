package com.zhbit.entity;
// default package

import java.sql.Timestamp;


/** 
 * 项目名称：ElecRecord
 * 类名称：LearningExperience 
 * 类描述： 学习经历的实体类
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午3:42:18
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午3:42:18
 * 修改备注： 
 * @version 
 */ 
public class LearningExperience implements java.io.Serializable {

	// Fields

	private String id;
	private String stuId;
	private String studentNo;
	private String stuName;
	private String duration;
	private String schoolName;
	private String duty;
	private String witness;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public LearningExperience() {
	}

	/** minimal constructor */
	public LearningExperience(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public LearningExperience(String stuId, String studentNo, String stuName,
			String duration, String schoolName, String duty, String witness,
			Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.duration = duration;
		this.schoolName = schoolName;
		this.duty = duty;
		this.witness = witness;
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

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getWitness() {
		return this.witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
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