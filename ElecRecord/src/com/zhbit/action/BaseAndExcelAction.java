package com.zhbit.action;

import java.io.File;

import javax.annotation.Resource;

import com.zhbit.services.ExcelServices;


/** 
 * 项目名称：ElecRecord
 * 类名称：BaseAndExcelAction 
 * 类描述： 能对excel处理的抽象类
 * 创建人：谭柳
 * 创建时间：2016年4月26日 下午12:46:29
 * 修改人：谭柳
 * 修改时间：2016年4月26日 下午12:46:29
 * 修改备注： 
 * @version 
 */ 
public abstract class BaseAndExcelAction extends BaseAction {
	//excel文件上传的属性
	protected File excel;
	protected String excelFileName;
	protected String excelContentType;
	
	@Resource(name="excelServices")
	protected ExcelServices excelServices;

	public abstract String importExcel();
	public abstract void exportExcel();
	
	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getExcelContentType() {
		return excelContentType;
	}

	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}
	
	
	
	
    
	
	
	
}
