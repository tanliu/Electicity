package com.zhbit.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.excel.InnerVo;

public class GrantscholarshipExcel extends BaseExcelBean implements Cloneable{

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
	    
	    
	    @Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
		private String studentNo;
	    @Lang(value="姓名",isNull=Lang.TYPE_NONULL)
		private String stuName;
	    @Lang(value="性别",toExcle={"男","女"},toEntity={"1","0"})
		private String sex;
	    @Lang(value="学院")
	 	private String orgName;
	    @Lang(value="专业")
	 	private String major;
	    @Lang(value="民族")
	 	private String nation;
	    @Lang(value="入学年月",date=Lang.TYPE_DATE)
	 	private String acceptanceDate;
	    @Lang(value="经济困难程度",isNull=Lang.TYPE_NONULL)
	 	private String familyEconomic;
	    @Lang(value="备注")
	 	private String memo;
//------------------get&set----------------------------
	    public GrantscholarshipExcel(){
	    	super();
	    }
	    
	    public GrantscholarshipExcel(String studentNo,String stuName,String sex,String orgName,
	    		String major,String nation,String acceptanceDate,String familyEconomic,String memo){
	    	super();
	    	this.studentNo=studentNo;
	    	this.stuName=stuName;
	    	this.sex=sex;
	    	this.orgName=orgName;
	    	this.major=major;
	    	this.nation=nation;
	    	this.acceptanceDate=acceptanceDate;
	    	this.familyEconomic=familyEconomic;
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
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public String getNation() {
			return nation;
		}
		public void setNation(String nation) {
			this.nation = nation;
		}
		public String getAcceptanceDate() {
			return acceptanceDate;
		}
		public void setAcceptanceDate(String acceptanceDate) {
			this.acceptanceDate = acceptanceDate;
		}
		public String getFamilyEconomic() {
			return familyEconomic;
		}
		public void setFamilyEconomic(String familyEconomic) {
			this.familyEconomic = familyEconomic;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
	    
}
