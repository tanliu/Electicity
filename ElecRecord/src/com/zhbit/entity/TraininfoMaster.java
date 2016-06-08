// default package
package com.zhbit.entity;
import java.sql.Timestamp;

/**
 * TTraininfoMaster entity. @author MyEclipse Persistence Tools
 */

public class TraininfoMaster implements java.io.Serializable {

	// Fields

	private String id;
	private Timestamp trainsDate;
	private String trainsGrade;
	private String manager;
	private String trainsTopic;
	private String trainsContent;
	private String trainsAddress;
	private String memo;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public TraininfoMaster() {
	}

	/** full constructor */
	public TraininfoMaster(Timestamp trainsDate, String trainsGrade,
			String manager, String trainsTopic, String trainsContent,
			String trainsAddress, String memo, Timestamp createTime,
			String creator) {
		this.trainsDate = trainsDate;
		this.trainsGrade = trainsGrade;
		this.manager = manager;
		this.trainsTopic = trainsTopic;
		this.trainsContent = trainsContent;
		this.trainsAddress = trainsAddress;
		this.memo = memo;
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

	public Timestamp getTrainsDate() {
		return this.trainsDate;
	}

	public void setTrainsDate(Timestamp trainsDate) {
		this.trainsDate = trainsDate;
	}

	public String getTrainsGrade() {
		return this.trainsGrade;
	}

	public void setTrainsGrade(String trainsGrade) {
		this.trainsGrade = trainsGrade;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTrainsTopic() {
		return this.trainsTopic;
	}

	public void setTrainsTopic(String trainsTopic) {
		this.trainsTopic = trainsTopic;
	}

	public String getTrainsContent() {
		return this.trainsContent;
	}

	public void setTrainsContent(String trainsContent) {
		this.trainsContent = trainsContent;
	}

	public String getTrainsAddress() {
		return this.trainsAddress;
	}

	public void setTrainsAddress(String trainsAddress) {
		this.trainsAddress = trainsAddress;
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