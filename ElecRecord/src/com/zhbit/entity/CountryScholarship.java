// default package
package com.zhbit.entity;
import java.sql.Timestamp;

import com.zhbit.annotation.Transform;

/**
 * TCountryScholarship entity. @author MyEclipse Persistence Tools
 */
/** 
 * 项目名称：ElecRecord
 * 类名称：CountryScholarship
 * 类描述： CountryScholarship实体类
 * 创建人：罗吉林
 * 创建时间：
 * 修改人：罗吉林
 * 修改时间：
 * 修改备注： 
 * @version 
 */
public class CountryScholarship implements java.io.Serializable,Cloneable {

	// Fields

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private String id;
	private String stuId;
	@Transform(name="学号")
	private String studentNo;
	@Transform(name="姓名")
	private String stuName;
	@Transform(name="性别")
	private String sex;
	@Transform(name="年级")
	private String grade;
	@Transform(name="政治面貌")
	private String politicalStatus;
	private String orgId;
	@Transform(name="专业学院")
	private String orgName;
	private String major;
	@Transform(name="获本校奖学金情况")
	private String schoolScholarInfo;
	@Transform(name="获省级及省级以上奖学金情况")
	private String provinceScholarIinfo;
	@Transform(name="评优获奖情况")
	private String awardInfo;
	@Transform(name="比赛、竞赛类获奖情况")
	private String competitionInfo;
	@Transform(name="担任职务")
	private String duty;
	@Transform(name="获奖名称")
	private String rewardName;
	@Transform(name="备注")
	private String memo;
	private String academicYear;
	private String term;
	private Timestamp createTime;
	private String creator;

	// Constructors

	/** default constructor */
	public CountryScholarship() {
	}

	/** minimal constructor */
	public CountryScholarship(String stuId) {
		this.stuId = stuId;
	}

	/** full constructor */
	public CountryScholarship(String stuId, String studentNo, String stuName,
			String sex, String grade, String politicalStatus, String orgId,
			String orgName, String major, String schoolScholarInfo,
			String provinceScholarIinfo, String awardInfo,
			String competitionInfo, String duty, String rewardName,
			String memo, String academicYear, String term,
			Timestamp createTime, String creator) {
		this.stuId = stuId;
		this.studentNo = studentNo;
		this.stuName = stuName;
		this.sex = sex;
		this.grade = grade;
		this.politicalStatus = politicalStatus;
		this.orgId = orgId;
		this.orgName = orgName;
		this.major = major;
		this.schoolScholarInfo = schoolScholarInfo;
		this.provinceScholarIinfo = provinceScholarIinfo;
		this.awardInfo = awardInfo;
		this.competitionInfo = competitionInfo;
		this.duty = duty;
		this.rewardName = rewardName;
		this.memo = memo;
		this.academicYear = academicYear;
		this.term = term;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
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

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchoolScholarInfo() {
		return this.schoolScholarInfo;
	}

	public void setSchoolScholarInfo(String schoolScholarInfo) {
		this.schoolScholarInfo = schoolScholarInfo;
	}

	public String getProvinceScholarIinfo() {
		return this.provinceScholarIinfo;
	}

	public void setProvinceScholarIinfo(String provinceScholarIinfo) {
		this.provinceScholarIinfo = provinceScholarIinfo;
	}

	public String getAwardInfo() {
		return this.awardInfo;
	}

	public void setAwardInfo(String awardInfo) {
		this.awardInfo = awardInfo;
	}

	public String getCompetitionInfo() {
		return this.competitionInfo;
	}

	public void setCompetitionInfo(String competitionInfo) {
		this.competitionInfo = competitionInfo;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getRewardName() {
		return this.rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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