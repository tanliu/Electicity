package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class GuiListEntity extends BaseExcelVo {
	
	@Lang(value="序号")
	private String xuhao;
	@Lang(value="学号")
	private String studentNo;
	@Lang(value="专业班级")
	private String className;
	@Lang(value="姓名")
	private String stuName;
	@Lang(value="导学老师")
	private String teacherName;
	
	
	
	public GuiListEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public GuiListEntity(String xuhao, String studentNo, String className, String stuName, String teacherName) {
		super();
		this.xuhao = xuhao;
		this.studentNo = studentNo;
		this.className = className;
		this.stuName = stuName;
		this.teacherName = teacherName;
	}

	@Override
	public int getHashVal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
//-------------------getter&setter-------------------------------------

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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	
}
