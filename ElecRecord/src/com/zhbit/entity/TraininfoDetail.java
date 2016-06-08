package com.zhbit.entity;

/**
 * TTraininfoDetail entity. @author MyEclipse Persistence Tools
 */

public class TraininfoDetail implements java.io.Serializable {

	// Fields

	private String id;
	private String stuId;
	private String master_id;
	private String studentNo;
	private String stuName;
	private String trainsResult;
	private String master_trainsTopic;
	private String memo;

	// Constructors

	/** default constructor */
	public TraininfoDetail() {
	}

	/** minimal constructor */
	public TraininfoDetail(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public TraininfoDetail(String stuId, String studentNo, String stuName,
			String trainsResult, String memo) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.trainsResult = trainsResult;
		this.memo = memo;
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

	public String getTrainsResult() {
		return this.trainsResult;
	}

	public void setTrainsResult(String trainsResult) {
		this.trainsResult = trainsResult;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMaster_id() {
		return master_id;
	}

	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}
	public String getMaster_trainsTopic() {
		return master_trainsTopic;
	}

	public void setMaster_trainsTopic(String master_trainsTopic) {
		this.master_trainsTopic = master_trainsTopic;
	}
	

}