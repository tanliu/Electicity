package com.zhbit.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

@ExcelVoConfig
public class GuiListEntity extends BaseExcelBean implements Cloneable {
	
	@Lang(value="序号")
	private String xuhao;
	@Lang(value="学号",isNull=Lang.TYPE_NONULL,type="^[0-9]{12}$")
	private String studentNo;
	@Lang(value="专业班级",isNull=Lang.TYPE_NONULL)
	private String className;
	@Lang(value="姓名",isNull=Lang.TYPE_NONULL)
	private String stuName;
	@Lang(value="导学老师",isNull=Lang.TYPE_NONULL)
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
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
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
