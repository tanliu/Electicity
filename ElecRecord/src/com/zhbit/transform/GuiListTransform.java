package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zhbit.entity.GuiContent;
import com.zhbit.entity.GuiList;
import com.zhbit.entity.excel.GuiContentEntity;
import com.zhbit.entity.excel.GuiListEntity;

public class GuiListTransform implements BaseTransfrom {

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		// TODO Auto-generated method stub
		List<Object> guiLists = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
				GuiListEntity guiListEntity=(GuiListEntity) object;
				
				if(guiListEntity.getXuhao()!=null||guiListEntity.getStudentNo()!=null){//当序号或学号不为空时，才进行转换操作
					GuiList guiList=new GuiList();
					
					//将stuid设定死
					guiList.setStuId("9528");
					//首先设定好创建时间
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					guiList.setCreateTime(createtime);
					//设定学年为2013-2014学年，学期为第一学期
					guiList.setAcademicYear("2013-2014");
					guiList.setTerm("1");
					
					//设定好对应的各个属性值
					if(!StringUtils.isEmpty(guiListEntity.getStudentNo())){
						guiList.setStudentNo(guiListEntity.getStudentNo().trim());
					}
					if(!StringUtils.isEmpty(guiListEntity.getClassName())){
						guiList.setClassName(guiListEntity.getClassName().trim());
					}	
					if(!StringUtils.isEmpty(guiListEntity.getStuName())){
						guiList.setStuName(guiListEntity.getStuName().trim());
					}
					if(!StringUtils.isEmpty(guiListEntity.getTeacherName())){
						guiList.setTeacherName(guiListEntity.getTeacherName().trim());
					}
					
					
					guiLists.add(guiList);
				}
		}
					return guiLists;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
