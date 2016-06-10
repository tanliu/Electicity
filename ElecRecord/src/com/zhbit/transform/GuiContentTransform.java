package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zhbit.entity.GuiContent;

import com.zhbit.entity.excel.GuiContentEntity;

public class GuiContentTransform implements BaseTransfrom {

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		List<Object> guiContents = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
				GuiContentEntity GuiContentEntity=(GuiContentEntity) object;
				
				if(GuiContentEntity.getXuhao()!=null||GuiContentEntity.getStudentNo()!=null){//当序号或学号不为空时，才进行转换操作
					GuiContent guiContent=new GuiContent();
					
					//将stuid设定死
					guiContent.setStuId("9528");
					//首先设定好创建时间
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					guiContent.setCreateTime(createtime);
					
					//设定好对应的各个属性值
					if(!StringUtils.isEmpty(GuiContentEntity.getStudentNo())){
						guiContent.setStudentNo(GuiContentEntity.getStudentNo().trim());
					}
					if(!StringUtils.isEmpty(GuiContentEntity.getClassName())){
						guiContent.setClassName(GuiContentEntity.getClassName().trim());
					}
					
					if(!StringUtils.isEmpty(GuiContentEntity.getStuName())){
						guiContent.setStuName(GuiContentEntity.getStuName().trim());
					}
					//对于辅导时间要进行相应的转换处理
					if(!StringUtils.isEmpty(GuiContentEntity.getGuidDate())){
						guiContent.setGuidDate(Timestamp.valueOf(GuiContentEntity.getGuidDate().trim()));
					}
					if(!StringUtils.isEmpty(GuiContentEntity.getGuidContent())){
						guiContent.setGuidContent(GuiContentEntity.getGuidContent().trim());
					}
					if(!StringUtils.isEmpty(GuiContentEntity.getMemo())){
						guiContent.setMemo(GuiContentEntity.getMemo().trim());
					}
					
					guiContents.add(guiContent);
				}
		}
					return guiContents;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
