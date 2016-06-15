package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class SubjectContestExcel extends BaseExcelBean implements Cloneable{

		@Lang(value = "学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
		private String studentNo;
		@Lang(value = "获奖者姓名",isNull=Lang.TYPE_NONULL)
		private String stuName;
		@Lang(value = "奖励名称")
		private String rewardName;
		@Lang(value = "获奖级别")
		private String rewardLevel;
		@Lang(value = "获奖等级")
		private String rewardGrade;
		@Lang(value = "授予单位")
		private String grantUnits;
		@Lang(value = "获奖项目")
		private String rewardProject;
		@Lang(value = "指导老师")
		private String guidTeacher;
		@Lang(value = "获奖时间",date=Lang.TYPE_DATE)
		private String rewardDate;
		@Lang(value = "备注")
		private String memo;
		
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		// Constructors

		/** default constructor */
		public SubjectContestExcel() {
		}


		/** full constructor */
		public SubjectContestExcel(String stuName,
				String rewardName,String rewardLevel, String rewardGrade, 
				String grantUnits,String rewardProject, String guidTeacher, 
				String rewardDate,String memo) {
			this.stuName = stuName;
			this.rewardName = rewardName;
			this.rewardLevel = rewardLevel;
			this.rewardGrade = rewardGrade;
			this.grantUnits = grantUnits;
			this.rewardProject = rewardProject;
			this.guidTeacher = guidTeacher;
			this.rewardDate = rewardDate;
			this.memo = memo;
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


	public String getRewardName() {
		return rewardName;
	}


	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}


	public String getRewardLevel() {
		return rewardLevel;
	}


	public void setRewardLevel(String rewardLevel) {
		this.rewardLevel = rewardLevel;
	}


	public String getRewardGrade() {
		return rewardGrade;
	}


	public void setRewardGrade(String rewardGrade) {
		this.rewardGrade = rewardGrade;
	}


	public String getGrantUnits() {
		return grantUnits;
	}


	public void setGrantUnits(String grantUnits) {
		this.grantUnits = grantUnits;
	}


	public String getRewardProject() {
		return rewardProject;
	}


	public void setRewardProject(String rewardProject) {
		this.rewardProject = rewardProject;
	}


	public String getGuidTeacher() {
		return guidTeacher;
	}


	public void setGuidTeacher(String guidTeacher) {
		this.guidTeacher = guidTeacher;
	}


	public String getRewardDate() {
		return rewardDate;
	}


	public void setRewardDate(String rewardDate) {
		this.rewardDate = rewardDate;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}

	
	
}