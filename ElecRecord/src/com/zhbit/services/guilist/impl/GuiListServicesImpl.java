package com.zhbit.services.guilist.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.guilist.GuiListDao;
import com.zhbit.entity.GuiList;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.guilist.GuiListServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Service(value=GuiListServices.SERVICES_NAME)
public class GuiListServicesImpl extends BaseServicesImpl<GuiList> implements GuiListServices {
	
	GuiListDao guiListDao;
	
	@Resource(name=GuiListDao.DAO_NAME)
	public void setGuiContentDao(GuiListDao guiListDao) {
		super.setBaseDao(guiListDao);
		this.guiListDao = guiListDao;
	}

	@Override
	public GuiList trimGuiList(GuiList guiList) {
		// TODO Auto-generated method stub
		if(guiList!=null){
			if(!StringUtils.isEmpty(guiList.getStudentNo())){
				guiList.setStudentNo(guiList.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(guiList.getClassName())){
				guiList.setClassName(guiList.getClassName().trim());
			}
			if(!StringUtils.isEmpty(guiList.getStuName())){
				guiList.setStuName(guiList.getStuName().trim());
			}
			if(!StringUtils.isEmpty(guiList.getTeacherName())){
				guiList.setTeacherName(guiList.getTeacherName().trim());
			}
		}
		
		return guiList;
	}

	@Override
	public PageUtils queryList(GuiList guiList, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";		
		if(guiList!=null){ //当stuStatus不为空时
			//先去除学号和学生姓名、导师姓名中可能存在的空格
			if(!StringUtils.isEmpty(guiList.getStuName())){
				guiList.setStuName(guiList.getStuName().trim());
			}
			if(!StringUtils.isEmpty(guiList.getStudentNo())){
				guiList.setStudentNo(guiList.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(guiList.getTeacherName())){
				guiList.setTeacherName(guiList.getTeacherName().trim());
			}
				fields=new String[]{"teacherName like ?","studentNo=?","stuName like ?"};
				params=new String[]{"%"+guiList.getTeacherName()+"%",guiList.getStudentNo(),"%"+guiList.getStuName()+"%"};
			
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	

}
