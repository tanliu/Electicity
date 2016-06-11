package com.zhbit.entity.excel;

import java.sql.Timestamp;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;


/** 
 * 项目名称：ElecRecord
 * 类名称：Student 
 * 类描述： 学生基本信息Excel实体
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午5:55:38
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午5:55:38
 * 修改备注： 
 * @version 
 */ 
public class StuExcel extends BaseExcelBean implements Cloneable{


	@Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
	private String studentNo;
	@Lang(value="姓名",isNull=Lang.TYPE_NONULL)
	private String stuName;
	@Lang(value="性别",toExcle={"男","女"},toEntity={"1","0"})
	private String sex;
	@Lang(value="出生日期",date=Lang.TYPE_DATE)
	private String birthday;
	@Lang(value="政治面貌")
	private String politicalStatus;
	@Lang(value="民族")
	private String nation;
	@Lang(value="籍贯")
	private String nativePlace;
	@Lang(value="来源地区")
	private String fromPlace;
	@Lang(value="学院")
	private String orgName;
	@Lang(value="系")
	private String department;
	@Lang(value="专业名称")
	private String major;
	@Lang(value="专业方向")
	private String majorField;
	@Lang(value="专业类别")
	private String majorCategories;
	@Lang(value="行政班")
	private String className;
	@Lang(value="学制",isNum=Lang.TYPE_ISNUM)
	private String educationSystem;
	@Lang(value="XXNX",isNum=Lang.TYPE_ISNUM)
	private String schoolingLength;
	@Lang(value="入学日期",date=Lang.TYPE_DATE)
	private String acceptanceDate;
	@Lang(value="毕业中学")
	private String middleSchool;
	@Lang(value="XJZT")
	private String schoolStatus;
	@Lang(value="DQSZJ")
	private String dqszj;
	
	
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}



	public StuExcel() {
		super();
	}



	public StuExcel(String studentNo, String stuName, String sex, String birthday, String politicalStatus,
			String nation, String nativePlace, String fromPlace, String orgName, String department, String major,
			String majorField, String majorCategories, String className, String educationSystem, String schoolingLength,
			String acceptanceDate, String middleSchool, String schoolStatus, String dqszj) {
		super();
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.birthday = birthday;
		this.politicalStatus = politicalStatus;
		this.nation = nation;
		this.nativePlace = nativePlace;
		this.fromPlace = fromPlace;
		this.orgName = orgName;
		this.department = department;
		this.major = major;
		this.majorField = majorField;
		this.majorCategories = majorCategories;
		this.className = className;
		this.educationSystem = educationSystem;
		this.schoolingLength = schoolingLength;
		this.acceptanceDate = acceptanceDate;
		this.middleSchool = middleSchool;
		this.schoolStatus = schoolStatus;
		this.dqszj = dqszj;
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



	public String getNativePlace() {
		return nativePlace;
	}



	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}



	public String getFromPlace() {
		return fromPlace;
	}



	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
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



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public String getMajorField() {
		return majorField;
	}



	public void setMajorField(String majorField) {
		this.majorField = majorField;
	}



	public String getMajorCategories() {
		return majorCategories;
	}



	public void setMajorCategories(String majorCategories) {
		this.majorCategories = majorCategories;
	}



	public String getClassName() {
		return className;
	}



	public void setClassName(String className) {
		this.className = className;
	}



	public String getEducationSystem() {
		return educationSystem;
	}



	public void setEducationSystem(String educationSystem) {
		this.educationSystem = educationSystem;
	}



	public String getSchoolingLength() {
		return schoolingLength;
	}



	public void setSchoolingLength(String schoolingLength) {
		this.schoolingLength = schoolingLength;
	}



	public String getAcceptanceDate() {
		return acceptanceDate;
	}



	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}



	public String getMiddleSchool() {
		return middleSchool;
	}



	public void setMiddleSchool(String middleSchool) {
		this.middleSchool = middleSchool;
	}



	public String getSchoolStatus() {
		return schoolStatus;
	}



	public void setSchoolStatus(String schoolStatus) {
		this.schoolStatus = schoolStatus;
	}



	public String getDqszj() {
		return dqszj;
	}



	public void setDqszj(String dqszj) {
		this.dqszj = dqszj;
	}

	


	@Override
	public String toString() {
		return "StuExcel [studentNo=" + studentNo + ", stuName=" + stuName + ", sex=" + sex + ", birthday=" + birthday
				+ ", politicalStatus=" + politicalStatus + ", nation=" + nation + ", nativePlace=" + nativePlace
				+ ", fromPlace=" + fromPlace + ", orgName=" + orgName + ", department=" + department + ", major="
				+ major + ", majorField=" + majorField + ", majorCategories=" + majorCategories + ", className="
				+ className + ", educationSystem=" + educationSystem + ", schoolingLength=" + schoolingLength
				+ ", acceptanceDate=" + acceptanceDate + ", middleSchool=" + middleSchool + ", schoolStatus="
				+ schoolStatus + ", dqszj=" + dqszj + "]";
	}









}