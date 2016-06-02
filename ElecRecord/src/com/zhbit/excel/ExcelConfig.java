package com.zhbit.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.zhbit.excel.annotation.Lang;


/** 
 * 项目名称：ElecRecord
 * 类名称：ExcelConfig 
 * 类描述： Excel文件的属性，有实体类，属性列表、从哪一行起的设置，输入、输入出流、表名、实体集合、生成表格的标题
 * 创建人：谭柳
 * 创建时间：2016年4月27日 下午7:54:59
 * 修改人：谭柳
 * 修改时间：2016年4月27日 下午7:54:59
 * 修改备注： 
 * @version 
 */ 
public class ExcelConfig {
	
	private String fileName;          //文件名
	private String[] entityFiled;    //实体的属性
	private int startRow=0;           //导入数据的开始行
	private FileInputStream fio;      //文件输入流
	private OutputStream fos; //文件输出流
	private String sheetName;        //实读取的表名
	private Class clazz;             //被操作的实体
	
	private List entitys;    //导出excel的数据
	private String title;            //生成表格的标题
	
	//---------------------------------Constructor-----------------
	public ExcelConfig(Class clazz,String sheetName,int startRow,String fileName) {
		this.sheetName=sheetName;
		this.clazz=clazz;
		this.startRow=startRow;
		this.fileName=fileName;
	}
	public ExcelConfig(Class clazz,String sheetName,int startRow,FileInputStream fis,String fileName) {
		this.sheetName=sheetName;
		this.clazz=clazz;
		this.startRow=startRow;
		this.fio=fis;
		this.fileName=fileName;
	}
	
	public ExcelConfig(Class clazz,String sheetName,String fileName) {
		this.sheetName=sheetName;
		this.clazz=clazz;
		this.fileName=fileName;
	}
	
	public ExcelConfig(Class clazz,String sheetName,OutputStream fos) {
		this.sheetName=sheetName;
		this.clazz=clazz;
		this.fos=fos;
	}
	
	//------------------------------------getter&setter---------------------
	public String[] getEntityFiled() throws Exception {
		
		if(clazz!=null){
			List<String> lists=new ArrayList<String>();
			Field[]  fs =  clazz.getDeclaredFields();
			// 遍历：输出每一个属性名称、值
			for (Field f : fs) {
				// 设置强制访问
				f.setAccessible(true);				

				//取得注解
				Lang lang=f.getAnnotation(Lang.class);
                //判断是还是被注解成属性的
				if(lang!=null){	
					// 名称
				  String name = f.getName();
				  lists.add(name);
	            }
			}
			entityFiled=new String[lists.size()];
			entityFiled=(String[]) lists.toArray(entityFiled);
		}
		return entityFiled;
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setEntityFiled(String[] entityFiled) {
		this.entityFiled = entityFiled;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public FileInputStream getFio() {
		return fio;
	}

	public void setFio(FileInputStream fio) {
		this.fio = fio;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public List getEntitys() {
		return entitys;
	}

	public void setEntitys(List entitys) {
		this.entitys = entitys;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public OutputStream getFos() {
		return fos;
	}

	public void setFos(OutputStream fos) {
		this.fos = fos;
	}


	
	

}
