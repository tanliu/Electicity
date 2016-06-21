package com.zhbit.entity.excel;

import java.sql.Timestamp;

import org.zhbit.excel.annotation.Lang;


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
public class TeachExcel extends BaseExcelBean implements java.io.Serializable,Cloneable {


	private String id;
	@Lang(value="职工号",isNull=Lang.TYPE_NONULL,isNum=Lang.TYPE_ISNUM)
	private String employNo;
	@Lang(value="姓名",isNull=Lang.TYPE_NONULL)
	private String employName;
	@Lang(value="性别")
	private String sex;
	@Lang(value="出生日期")
	private String birthday;
	@Lang(value="部门（学院）")
	private String orgName;
	@Lang(value="科室（系）")
	private String department;
	@Lang(value="联系电话",type="(1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8})|(^\\d{6})")
	private String telNo;
	@Lang(value="E_mail地址",type=Lang.TYPE_EMAIL)
	private String email;
	@Lang(value="教职工类别")
	private String category;
	@Lang(value="学历")
	private String education;
	@Lang(value="学位")
	private String degree;
	@Lang(value="职务")
	private String duty;
	@Lang(value="职称")
	private String acdemicTitle;
	@Lang(value="派监考老师可用否")
	private String invigilatorFlag;
	@Lang(value="教学研究方向")
	private String researchDirection;
	@Lang(value="教师简介")
	private String summary;
	@Lang(value="专业名称")
	private String major;
	@Lang(value="毕业院校")
	private String graduate;
	@Lang(value="教师资格",toExcle={"有","无"},toEntity={"Y","N"})
	private String qualificationFlag;
	@Lang(value="教师级别")
	private String level;
	@Lang(value="是否实验室人员",toExcle={"是","否"},toEntity={"Y","N"})
	private String isLab;
	@Lang(value="是否外聘")
	private String isOutHire;
	@Lang(value="政治面貌")
	private String politicalStatus;
	@Lang(value="民族")
	private String nation;

	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	public TeachExcel() {
	}


	public TeachExcel(String id, String employNo, String employName, String sex, String birthday, String orgName,
			String department, String telNo, String email, String category, String education, String degree,
			String duty, String acdemicTitle, String invigilatorFlag, String researchDirection, String summary,
			String major, String graduate, String qualificationFlag, String level, String isLab, String isOutHire,
			String politicalStatus, String nation) {
		super();
		this.id = id;
		this.employNo = employNo;
		this.employName = employName;
		this.sex = sex;
		this.birthday = birthday;
		this.orgName = orgName;
		this.department = department;
		this.telNo = telNo;
		this.email = email;
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
		this.level = level;
		this.isLab = isLab;
		this.isOutHire = isOutHire;
		this.politicalStatus = politicalStatus;
		this.nation = nation;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getTelNo() {
		return telNo;
	}


	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getDuty() {
		return duty;
	}


	public void setDuty(String duty) {
		this.duty = duty;
	}


	public String getAcdemicTitle() {
		return acdemicTitle;
	}


	public void setAcdemicTitle(String acdemicTitle) {
		this.acdemicTitle = acdemicTitle;
	}


	public String getInvigilatorFlag() {
		return invigilatorFlag;
	}


	public void setInvigilatorFlag(String invigilatorFlag) {
		this.invigilatorFlag = invigilatorFlag;
	}


	public String getResearchDirection() {
		return researchDirection;
	}


	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getGraduate() {
		return graduate;
	}


	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}


	public String getQualificationFlag() {
		return qualificationFlag;
	}


	public void setQualificationFlag(String qualificationFlag) {
		this.qualificationFlag = qualificationFlag;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getIsLab() {
		return isLab;
	}


	public void setIsLab(String isLab) {
		this.isLab = isLab;
	}


	public String getIsOutHire() {
		return isOutHire;
	}


	public void setIsOutHire(String isOutHire) {
		this.isOutHire = isOutHire;
	}


	public String getPoliticalStatus() {
		return politicalStatus;
	}


	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}
   
	



}