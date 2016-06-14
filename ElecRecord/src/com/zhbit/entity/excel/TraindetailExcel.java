package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

import com.zhbit.excel.InnerVo;

public class TraindetailExcel extends BaseExcelBean implements Cloneable{

	

	      @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
		 @Lang(value="学号")
			private String studentNo;
		  
		  @Lang(value="主题")
			private String master_trainsTopic;
		  
		  @Lang(value="参训人")
			private String stuName;
		  
		  @Lang(value="参训结果")
			private String trainsResult;
		  
		  @Lang(value="备注")
			private String memo;
		  
		  public TraindetailExcel(String studentNo,String stuName,String master_trainsTopic,String trainsResult
				  ,String memo){
			  super();
			  this.studentNo=studentNo;
			  this.stuName=stuName;
			  this.master_trainsTopic=master_trainsTopic;
			  this.trainsResult=trainsResult;
			  this.memo=memo;
			 
		  }
		  public TraindetailExcel(){
			  super();
		  }
		//非对就
		  @ExcelColumnGroup(type = String.class)
		    private List<String> baseArray;
		    @ExcelColumnGroup(type = InnerVo.class)
		    private List<InnerVo> innerVoArray;

		
//------------------------get&set----------------------------
			public String getStudentNo() {
				return studentNo;
			}
			public void setStudentNo(String studentNo) {
				this.studentNo = studentNo;
			}
			public String getMaster_trainsTopic() {
				return master_trainsTopic;
			}
			public void setMaster_trainsTopic(String master_trainsTopic) {
				this.master_trainsTopic = master_trainsTopic;
			}
			public String getStuName() {
				return stuName;
			}
			public void setStuName(String stuName) {
				this.stuName = stuName;
			}
			public String getTrainsResult() {
				return trainsResult;
			}
			public void setTrainsResult(String trainsResult) {
				this.trainsResult = trainsResult;
			}
			public String getMemo() {
				return memo;
			}
			public void setMemo(String memo) {
				this.memo = memo;
			}
		    
}
