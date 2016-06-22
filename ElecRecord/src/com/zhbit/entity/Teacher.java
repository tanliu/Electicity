package com.zhbit.entity;

import java.sql.Timestamp;

import com.zhbit.annotation.Transform;


/** 
 * 项目名称：ElecRecord
 * 类名称：Teacher 
 * 类描述： 教师信息实体类
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:39:28
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:39:28
 * 修改备注： 
 * @version 
 */ 
public class Teacher implements java.io.Serializable,Cloneable {


	private String id;
	@Transform(name="职工号")
	private String employNo;
	@Transform(name="姓名")
	private String employName;
	@Transform(name="性别")
	private String sex;
	@Transform(name="出生日期")
	private Timestamp birthday;
	
	private String orgId;
	@Transform(name="部门（学院）")
	private String orgName;
	@Transform(name="科室（系）")
	private String department;
	@Transform(name="联系电话")
	private String telNo;
	@Transform(name="E_mail地址")
	private String email;
	
	private String address;
	@Transform(name="教职工类别")
	private String category;
	@Transform(name="学历")
	private String education;
	@Transform(name="学位")
	private String degree;
	@Transform(name="职务")
	private String duty;
	@Transform(name="职称")
	private String acdemicTitle;
	@Transform(name="派监考老师可用否")
	private String invigilatorFlag;
	@Transform(name="教学研究方向")
	private String researchDirection;
	@Transform(name="教师简介")
	private String summary;
	@Transform(name="专业名称")
	private String major;
	@Transform(name="毕业院校")
	private String graduate;
	@Transform(name="教师资格")
	private String qualificationFlag;	
	private String jobStatus;
	@Transform(name="教师级别")
	private String level;
	@Transform(name="是否实验室人员")
	private String isLab;
	@Transform(name="是否外聘")
	private String isOutHire;
	@Transform(name="政治面貌")
	private String politicalStatus;
	@Transform(name="民族")
	private String nation;	
	private Timestamp createTime;
	private String creator;

	
	public final static String ROLE_NAME="老师";

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	public Teacher() {
	}


	public Teacher(String employNo, String employName, String sex,
			Timestamp birthday, String orgId, String orgName,
			String department, String telNo, String email, String address,
			String category, String education, String degree, String duty,
			String acdemicTitle, String invigilatorFlag,
			String researchDirection, String summary, String major,
			String graduate, String qualificationFlag, String jobStatus,
			String level, String isLab, String isOutHire,
			String politicalStatus, String nation, Timestamp createTime,
			String creator) {
		this.employNo = employNo;
		this.employName = employName;
		this.sex = sex;
		this.birthday = birthday;
		this.orgId = orgId;
		this.orgName = orgName;
		this.department = department;
		this.telNo = telNo;
		this.email = email;
		this.address = address;
		this.category = category;
		this.education = education;
		this.degree = degree;
		this.duty = duty;
		this.acdemicTitle = acdemicTitle;
		this.invigilatorFlag = invigilatorFlag;
		this.researchDirection = researchDirection;
		this.summary = summary;
		this.major = major;
		this.graduate = graduate;
		this.qualificationFlag = qualificationFlag;
		this.jobStatus = jobStatus;
		this.level = level;
		this.isLab = isLab;
		this.isOutHire = isOutHire;
		this.politicalStatus = politicalStatus;
		this.nation = nation;
		this.createTime = createTime;
		this.creator = creator;
	}



	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
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

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getAcdemicTitle() {
		return this.acdemicTitle;
	}

	public void setAcdemicTitle(String acdemicTitle) {
		this.acdemicTitle = acdemicTitle;
	}

	public String getInvigilatorFlag() {
		return this.invigilatorFlag;
	}

	public void setInvigilatorFlag(String invigilatorFlag) {
		this.invigilatorFlag = invigilatorFlag;
	}

	public String getResearchDirection() {
		return this.researchDirection;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGraduate() {
		return this.graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getQualificationFlag() {
		return this.qualificationFlag;
	}

	public void setQualificationFlag(String qualificationFlag) {
		this.qualificationFlag = qualificationFlag;
	}

	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsLab() {
		return this.isLab;
	}

	public void setIsLab(String isLab) {
		this.isLab = isLab;
	}

	public String getIsOutHire() {
		return this.isOutHire;
	}

	public void setIsOutHire(String isOutHire) {
		this.isOutHire = isOutHire;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
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