package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.annotation.Transform;
import com.zhbit.excel.InnerVo;

public class CouscholarshipExcel extends BaseExcelBean implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	//非对就
	  @ExcelColumnGroup(type = String.class)
	    private List<String> baseArray;
	    @ExcelColumnGroup(type = InnerVo.class)
	    private List<InnerVo> innerVoArray;
	    
	    @Lang(value="学号")
		private String studentNo;
	    @Lang(value="姓名")
		private String stuName;
	    @Lang(value="性别")
		private String sex;
	    @Lang(value="年级")
		private String grade;
	    @Lang(value="政治面貌")
		private String politicalStatus;
	    @Lang(value="专业学院")
		private String orgName;
	    @Lang(value="获本校奖学金情况")
		private String schoolScholarInfo;
		@Lang(value="获省级及省级以上奖学金情况")
		private String provinceScholarIinfo;
		@Lang(value="评优获奖情况")
		private String awardInfo;
		@Lang(value="比赛、竞赛类获奖情况")
		private String competitionInfo;
		@Lang(value="担任职务")
		private String duty;
		@Lang(value="获奖名称")
		private String rewardName;
		@Lang(value="备注")
		private String memo;
		
		
//------------------get&set----------------------------------
		public CouscholarshipExcel(String studentNo,String stuName,String sex,String grade,String politicalStatus,String orgName,
				String schoolScholarInfo,String provinceScholarIinfo,String awardInfo,String competitionInfo,String duty,String rewardName
				,String memo){
			super();
			  this.studentNo=studentNo;
			  this.stuName=stuName;
			  this.sex=sex;
			  this.grade=grade;
			  this.politicalStatus=politicalStatus;
			  this.orgName=orgName;
			  this.schoolScholarInfo=schoolScholarInfo;
			  this.provinceScholarIinfo=provinceScholarIinfo;
			  this.awardInfo=awardInfo;
			  this.competitionInfo=competitionInfo;
			  this.duty=duty;
			  this.rewardName=rewardName;
			  this.memo=memo;
		}
		
		
		public CouscholarshipExcel(){
			super();
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
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getPoliticalStatus() {
			return politicalStatus;
		}
		public void setPoliticalStatus(String politicalStatus) {
			this.politicalStatus = politicalStatus;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getSchoolScholarInfo() {
			return schoolScholarInfo;
		}
		public void setSchoolScholarInfo(String schoolScholarInfo) {
			this.schoolScholarInfo = schoolScholarInfo;
		}
		public String getProvinceScholarIinfo() {
			return provinceScholarIinfo;
		}
		public void setProvinceScholarIinfo(String provinceScholarIinfo) {
			this.provinceScholarIinfo = provinceScholarIinfo;
		}
		public String getAwardInfo() {
			return awardInfo;
		}
		public void setAwardInfo(String awardInfo) {
			this.awardInfo = awardInfo;
		}
		public String getCompetitionInfo() {
			return competitionInfo;
		}
		public void setCompetitionInfo(String competitionInfo) {
			this.competitionInfo = competitionInfo;
		}
		public String getDuty() {
			return duty;
		}
		public void setDuty(String duty) {
			this.duty = duty;
		}
		public String getRewardName() {
			return rewardName;
		}
		public void setRewardName(String rewardName) {
			this.rewardName = rewardName;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
		
		
}
