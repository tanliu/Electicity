package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

import com.zhbit.excel.InnerVo;

public class TrainmasterExcel extends BaseExcelBean implements Cloneable{

	
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
	
	 @Lang(value="主题")
		private String trainsTopic;
	  
	  @Lang(value="主讲人")
		private String manager;
	  
	  @Lang(value="时间")
		private String trainsDate;
	  
	  @Lang(value="年级")
		private String trainsGrade;
	  
	  @Lang(value="内容")
		private String trainsContent;
	  
	  @Lang(value="地点")
		private String trainsAddress;
	  
	  @Lang(value="备注")
		private String memo;
	  
	  public TrainmasterExcel(String trainsTopic,String manager,String trainsDate,String trainsAddress
			  ,String memo){
		  super();
		  this.trainsTopic=trainsTopic;
		  this.manager=manager;
		  this.trainsDate=trainsDate;
		  this.trainsAddress=trainsAddress;
		  this.memo=memo;
	  }
	  
      public TrainmasterExcel(){
    	  super();
	  }

      
      //----------------get&set----------------------
	public String getTrainsTopic() {
		return trainsTopic;
	}

	public void setTrainsTopic(String trainsTopic) {
		this.trainsTopic = trainsTopic;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTrainsDate() {
		return trainsDate;
	}

	public void setTrainsDate(String trainsDate) {
		this.trainsDate = trainsDate;
	}

	public String getTrainsAddress() {
		return trainsAddress;
	}

	public void setTrainsAddress(String trainsAddress) {
		this.trainsAddress = trainsAddress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
      
   
      
}
