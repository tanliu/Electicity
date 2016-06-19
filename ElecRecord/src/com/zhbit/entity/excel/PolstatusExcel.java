package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

import com.zhbit.excel.InnerVo;
@ExcelVoConfig
public class PolstatusExcel extends BaseExcelBean implements Cloneable{

	

	  @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
		private String studentNo;
	  
	  @Lang(value="姓名",isNull=Lang.TYPE_NONULL)
		private String stuName;
	  
	  @Lang(value="入党团日期",date=Lang.TYPE_DATE)
		private String joinDate;
	  
	  @Lang(value="政治面貌",isNull=Lang.TYPE_NONULL)
		private String politicalStatus;
	  
	  @Lang(value="备注")
		private String memo;
	  
	 
	  
	  public PolstatusExcel(String studentNo,String stuName,String joinDate,String politicalStatus
			  ,String memo){
		  super();
		  this.studentNo=studentNo;
		  this.stuName=stuName;
		  this.joinDate=joinDate;
		  this.politicalStatus=politicalStatus;
		  this.memo=memo;
		 
	  }
	  
	  
	//非对就
	  @ExcelColumnGroup(type = String.class)
	    private List<String> baseArray;
	    @ExcelColumnGroup(type = InnerVo.class)
	    private List<InnerVo> innerVoArray;
	    
//----------------get&set---------------------- 
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	

	public PolstatusExcel(){
		super();
	  }

}
