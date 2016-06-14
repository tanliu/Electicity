package com.zhbit.entity;
import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TLearningguidInfo entity. @author MyEclipse Persistence Tools
 */

public class GuiContent implements java.io.Serializable,Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String stuId;
	@Transform(name="学号")
	private String studentNo;
	@Transform(name="姓名")
	private String stuName;
	@Transform(name="专业班级")
	private String className;
	@Transform(name="导学时间")
	private Timestamp guidDate;
	@Transform(name="导学内容")
	private String guidContent;
	@Transform(name="导学地点")
	private String guidAddress;
	private String docPath;
	@Transform(name="备注")
	private String memo;
	private Timestamp createTime;
	private String creator;

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
	// Constructors
	
	/** default constructor */
	public GuiContent() {
	}

	/** minimal constructor */
	public GuiContent(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public GuiContent(String stuId, String studentNo, String stuName,
			Timestamp guidDate, String guidContent, String guidAddress,
			String docPath, String memo, Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.guidDate = guidDate;
		this.guidContent = guidContent;
		this.guidAddress = guidAddress;
		this.docPath = docPath;
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

	public Timestamp getGuidDate() {
		return this.guidDate;
	}

	public void setGuidDate(Timestamp guidDate) {
		this.guidDate = guidDate;
	}

	public String getGuidContent() {
		return this.guidContent;
	}

	public void setGuidContent(String guidContent) {
		this.guidContent = guidContent;
	}

	public String getGuidAddress() {
		return this.guidAddress;
	}

	public void setGuidAddress(String guidAddress) {
		this.guidAddress = guidAddress;
	}

	public String getDocPath() {
		return this.docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
}