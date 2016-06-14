package com.zhbit.entity;

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TGuidanceinfo entity. @author MyEclipse Persistence Tools
 */

/** 
 * 项目名称：ElecRecord
 * 类名称： Tutor
 * 类描述：用于记录辅导信息的实体类
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午9:16:44
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午9:16:44
 * 修改备注： 
 * @version 
 */ 
public class Tutor implements java.io.Serializable,Cloneable {

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
	@Transform(name="辅导时间")
	private Timestamp guidDate;
	@Transform(name="辅导内容")
	private String guidContent;
	@Transform(name="辅导地点")
	private String guidAddress;
	@Transform(name="备注")
	private String demo;
	private Timestamp createTime;
	private String creator;

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	public Tutor() {
		// TODO Auto-generated constructor stub
	}


	public Tutor(String id, String stuId, String studentNo, String stuName, String className, Timestamp guidDate,
			String guidContent, String guidAddress, String demo, Timestamp createTime, String creator) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.className = className;
		this.guidDate = guidDate;
		this.guidContent = guidContent;
		this.guidAddress = guidAddress;
		this.demo = demo;
		this.createTime = createTime;
		this.creator = creator;
	}

//---------------------------getter&setter----------------------------
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getStuId() {
		return stuId;
	}


	public void setStuId(String stuId) {
		this.stuId = stuId;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public Timestamp getGuidDate() {
		return guidDate;
	}


	public void setGuidDate(Timestamp guidDate) {
		this.guidDate = guidDate;
	}


	public String getGuidContent() {
		return guidContent;
	}


	public void setGuidContent(String guidContent) {
		this.guidContent = guidContent;
	}


	public String getGuidAddress() {
		return guidAddress;
	}


	public void setGuidAddress(String guidAddress) {
		this.guidAddress = guidAddress;
	}


	public String getDemo() {
		return demo;
	}


	public void setDemo(String demo) {
		this.demo = demo;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}