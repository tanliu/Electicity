package com.zhbit.entity;

import java.sql.Timestamp;


/** 
 * 项目名称：ElecRecord
 * 类名称：Student 
 * 类描述： 学生基本信息实体
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午5:55:38
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午5:55:38
 * 修改备注： 
 * @version 
 */ 
public class Student implements java.io.Serializable {


	private String stuId;
	private String studentNo;
	private String stuName;
	private String sex;
	private Timestamp birthday;
	private String politicalStatus;
	private String nation;
	private String nativePlace;
	private String fromPlace;
	private String idCardNo;
	private String orgId;
	private String orgName;
	private String department;
	private String major;
	private String majorField;
	private String majorCategories;
	private String cultivateDirection;
	private String className;
	private Integer educationSystem;
	private Integer schoolingLength;
	private Timestamp acceptanceDate;
	private String middleSchool;
	private String mobileNo;
	private String familyTelNo;
	private String postCode;
	private String travelRange;
	private String address;
	private String skill;
	private String selfDescription;
	private String awards;
	private String schoolStatus;
	private String dqszj;
	private String photoPath;
	private String graduateFlag;
	private String alumniFlag;
	private Timestamp createTime;
	private String creator;
	private String password;


	public Student() {
	}

	public Student(String studentNo, String stuName, String sex,
			Timestamp birthday, String politicalStatus, String nation,
			String nativePlace, String fromPlace, String idCardNo,
			String orgId, String orgName, String department, String major,
			String majorField, String majorCategories,
			String cultivateDirection, String className,
			Integer educationSystem, Integer schoolingLength,
			Timestamp acceptanceDate, String middleSchool, String mobileNo,
			String familyTelNo, String postCode, String travelRange,
			String address, String skill, String selfDescription,
			String awards, String schoolStatus, String dqszj, String photoPath,
			String graduateFlag, String alumniFlag, Timestamp createTime,
			String creator, String password) {
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.birthday = birthday;
		this.politicalStatus = politicalStatus;
		this.nation = nation;
		this.nativePlace = nativePlace;
		this.fromPlace = fromPlace;
		this.idCardNo = idCardNo;
		this.orgId = orgId;
		this.orgName = orgName;
		this.department = department;
		this.major = major;
		this.majorField = majorField;
		this.majorCategories = majorCategories;
		this.cultivateDirection = cultivateDirection;
		this.className = className;
		this.educationSystem = educationSystem;
		this.schoolingLength = schoolingLength;
		this.acceptanceDate = acceptanceDate;
		this.middleSchool = middleSchool;
		this.mobileNo = mobileNo;
		this.familyTelNo = familyTelNo;
		this.postCode = postCode;
		this.travelRange = travelRange;
		this.address = address;
		this.skill = skill;
		this.selfDescription = selfDescription;
		this.awards = awards;
		this.schoolStatus = schoolStatus;
		this.dqszj = dqszj;
		this.photoPath = photoPath;
		this.graduateFlag = graduateFlag;
		this.alumniFlag = alumniFlag;
		this.createTime = createTime;
		this.creator = creator;
		this.password = password;
	}

	// Property accessors

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

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getFromPlace() {
		return this.fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getIdCardNo() {
		return this.idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
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

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajorField() {
		return this.majorField;
	}

	public void setMajorField(String majorField) {
		this.majorField = majorField;
	}

	public String getMajorCategories() {
		return this.majorCategories;
	}

	public void setMajorCategories(String majorCategories) {
		this.majorCategories = majorCategories;
	}

	public String getCultivateDirection() {
		return this.cultivateDirection;
	}

	public void setCultivateDirection(String cultivateDirection) {
		this.cultivateDirection = cultivateDirection;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getEducationSystem() {
		return this.educationSystem;
	}

	public void setEducationSystem(Integer educationSystem) {
		this.educationSystem = educationSystem;
	}

	public Integer getSchoolingLength() {
		return this.schoolingLength;
	}

	public void setSchoolingLength(Integer schoolingLength) {
		this.schoolingLength = schoolingLength;
	}

	public Timestamp getAcceptanceDate() {
		return this.acceptanceDate;
	}

	public void setAcceptanceDate(Timestamp acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public String getMiddleSchool() {
		return this.middleSchool;
	}

	public void setMiddleSchool(String middleSchool) {
		this.middleSchool = middleSchool;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFamilyTelNo() {
		return this.familyTelNo;
	}

	public void setFamilyTelNo(String familyTelNo) {
		this.familyTelNo = familyTelNo;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTravelRange() {
		return this.travelRange;
	}

	public void setTravelRange(String travelRange) {
		this.travelRange = travelRange;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSelfDescription() {
		return this.selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getAwards() {
		return this.awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getSchoolStatus() {
		return this.schoolStatus;
	}

	public void setSchoolStatus(String schoolStatus) {
		this.schoolStatus = schoolStatus;
	}

	public String getDqszj() {
		return this.dqszj;
	}

	public void setDqszj(String dqszj) {
		this.dqszj = dqszj;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getGraduateFlag() {
		return this.graduateFlag;
	}

	public void setGraduateFlag(String graduateFlag) {
		this.graduateFlag = graduateFlag;
	}

	public String getAlumniFlag() {
		return this.alumniFlag;
	}

	public void setAlumniFlag(String alumniFlag) {
		this.alumniFlag = alumniFlag;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}