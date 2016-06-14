package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.annotation.Transform;
import com.zhbit.excel.InnerVo;

public class ComscholarshipExcel extends BaseExcelBean implements Cloneable{

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
		@Lang(value="专业")
		private String major;
		@Lang(value="获奖名称")
		private String rewardName;
		@Lang(value="备注")
		private String memo;
//---------------------get&set-----------------------
		
		public ComscholarshipExcel(String studentNo,String stuName,String major,
				String rewardName,String memo){
			super();
			this.studentNo=studentNo;
			this.stuName=stuName;
			this.major=major;
			this.rewardName=rewardName;
			this.memo=memo;
		}
		
		public ComscholarshipExcel(){
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
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
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
