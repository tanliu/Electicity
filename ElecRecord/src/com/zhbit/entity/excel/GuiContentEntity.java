package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class GuiContentEntity extends BaseExcelBean implements Cloneable {

	@Lang(value="序号")
	private String xuhao;
	@Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
	private String studentNo;
	@Lang(value="专业班级",isNull=Lang.TYPE_NONULL)
	private String className;
	@Lang(value="姓名",isNull=Lang.TYPE_NONULL)
	private String stuName;
	@Lang(value="导学时间",isNull=Lang.TYPE_NONULL)
	private String guidDate;
	@Lang(value="导学地点",isNull=Lang.TYPE_NONULL)
	private String guidAddress;
	@Lang(value="导学内容")
	private String guidContent;
	@Lang(value="备注")
	private String memo;
	
	
	
	
	public GuiContentEntity() {
		// TODO Auto-generated constructor stub
	}

	public GuiContentEntity(String xuhao, String studentNo, String className, String stuName, String guidDate,
			String guidAddress, String guidContent, String demo) {
		super();
		this.xuhao = xuhao;
		this.studentNo = studentNo;
		this.className = className;
		this.stuName = stuName;
		this.guidDate = guidDate;
		this.guidAddress = guidAddress;
		this.guidContent = guidContent;
		this.memo = demo;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	
//-----------------------------getter&setter---------------------------
	
	
	public String getXuhao() {
		return xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getGuidDate() {
		return guidDate;
	}

	public void setGuidDate(String guidDate) {
		this.guidDate = guidDate;
	}

	public String getGuidAddress() {
		return guidAddress;
	}

	public void setGuidAddress(String guidAddress) {
		this.guidAddress = guidAddress;
	}

	public String getGuidContent() {
		return guidContent;
	}

	public void setGuidContent(String guidContent) {
		this.guidContent = guidContent;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	

}
