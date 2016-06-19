package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.annotation.Transform;
import com.zhbit.excel.InnerVo;

public class LoanscholarshipExcel extends BaseExcelBean implements Cloneable{

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
	    
	    @Lang(value="专业")
	    private String major;
	    @Lang(value="班级")
	 	private String className;
	    @Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
		private String studentNo;
	    @Lang(value="姓名",isNull=Lang.TYPE_NONULL)
		private String stuName;
	    @Lang(value="身份证号")
		private String idCardNo;
	    @Lang(value="年级")
	 	private String grade;
	    @Lang(value="贷款金额")
	 	private String loanAmount;
	    @Lang(value="是否通过专业学院资格审核",toExcle={"是","否"},toEntity={"1","0"})
	 	private String censoredFlag;
	    @Lang(value="被拒绝原因")
	 	private String refuseReason;
	    @Lang(value="备注")
	 	private String memo;
	    
//-----------------------get&set---------------------------------
	    public LoanscholarshipExcel(){
	    	super();
	    }
	    public LoanscholarshipExcel(String studentNo,String stuName,String idCardNo,String grade,
	    		String major,String className,String loanAmount,String censoredFlag,String refuseReason,String memo){
	    	super();
	    	this.studentNo=studentNo;
	    	this.stuName=stuName;
	    	this.idCardNo=idCardNo;
	    	this.grade=grade;
	    	this.major=major;
	    	this.className=className;
	    	this.loanAmount=loanAmount;
	    	this.censoredFlag=censoredFlag;
	    	this.refuseReason=refuseReason;
	    	this.memo=memo;	
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
		public String getIdCardNo() {
			return idCardNo;
		}
		public void setIdCardNo(String idCardNo) {
			this.idCardNo = idCardNo;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(String loanAmount) {
			this.loanAmount = loanAmount;
		}
		public String getCensoredFlag() {
			return censoredFlag;
		}
		public void setCensoredFlag(String censoredFlag) {
			this.censoredFlag = censoredFlag;
		}
		public String getRefuseReason() {
			return refuseReason;
		}
		public void setRefuseReason(String refuseReason) {
			this.refuseReason = refuseReason;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
	    
	    
}
