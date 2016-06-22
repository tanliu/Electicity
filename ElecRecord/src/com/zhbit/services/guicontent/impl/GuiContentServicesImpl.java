package com.zhbit.services.guicontent.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.GuiContent;

import com.zhbit.entity.GuiContent;
import com.zhbit.services.BaseServices;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.guicontent.GuiContentServices;
import com.zhbit.dao.guicontent.GuiContentDao;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Service(value=GuiContentServices.SERVICES_NAME)
public class GuiContentServicesImpl extends BaseServicesImpl<GuiContent> implements GuiContentServices {

	GuiContentDao guiContentDao;
	Timestamp nextday;
	@Resource(name=GuiContentDao.DAO_NAME)
	public void setGuiContentDao(GuiContentDao guiContentDao) {
		super.setBaseDao(guiContentDao);
		this.guiContentDao = guiContentDao;
	}
	
	@Override
	public PageUtils queryList(GuiContent guiContent, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String[] fields=null;
		Object[] params=null;
		String proterty="createTime";
		
		if(guiContent!=null){
			//先去除学号和姓名中可能存在的空格
			if(!StringUtils.isEmpty(guiContent.getStuName())){
				guiContent.setStuName(guiContent.getStuName().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getStudentNo())){
				guiContent.setStudentNo(guiContent.getStudentNo().trim());
			}
			
			//用于查询某个具体日期的数据
			if(guiContent.getGuidDate()!=null){
				long time=guiContent.getGuidDate().getTime();
				time=time+24*60*60*1000; 
				nextday=new Timestamp(time);
			}
			
			
			if(guiContent.getGuidDate()==null){//此处与学籍异动信息模块不同，这里要对辅导日期进行判空处理
				fields=new String[]{"studentNo=?","stuName like ?"};
				params=new Object[]{guiContent.getStudentNo(),"%"+guiContent.getStuName()+"%"};
			}else{
				fields=new String[]{"stuName like ?","studentNo=?","guidDate>=?","guidDate<=?"};
				params=new Object[]{"%"+guiContent.getStuName()+"%",guiContent.getStudentNo(),guiContent.getGuidDate(),nextday};
			}
				
		}
		
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	/**
		 * 方法描述:重写getPageUtils方法，因为此模块的查询条件中有比较特殊的查询条件
		 * @param
		 * @param 
		 */
	
	public PageUtils getPageUtils(String[] fields, Object[] params, String proterty, String order, int pageNO,
			int pageSize) {
		
		// TODO Auto-generated method stub
		QueryUtils queryUtils=new QueryUtils(GuiContent.class, "entity");
		//添加查询条件
		if(fields!=null&&fields.length>0&&params!=null&&params.length>0&&fields.length==params.length){
			for(int i=0;i<fields.length;i++){
				if(!StringUtils.isEmpty(fields[i])&&!StringUtils.isEmpty((params[i])+"")){
					queryUtils.addCondition("entity."+fields[i], params[i]);				
				}
			}
		}
		
		//添加排序
		if(!StringUtils.isEmpty(proterty)&&!StringUtils.isEmpty(order)){
			queryUtils.addOrderByProperty("entity."+proterty, order);
		}
		
		return guiContentDao.getPageUtils(queryUtils, pageNO, pageSize);
		
	}

	@Override
	public GuiContent trimGuiContent(GuiContent guiContent) {
		// TODO Auto-generated method stub
		if(guiContent!=null){
			if(!StringUtils.isEmpty(guiContent.getStudentNo())){
				guiContent.setStudentNo(guiContent.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getClassName())){
				guiContent.setClassName(guiContent.getClassName().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getStuName())){
				guiContent.setStuName(guiContent.getStuName().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getGuidAddress())){
				guiContent.setGuidAddress(guiContent.getGuidAddress().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getGuidContent())){
				guiContent.setGuidContent(guiContent.getGuidContent().trim());
			}
			if(!StringUtils.isEmpty(guiContent.getMemo())){
				guiContent.setMemo(guiContent.getMemo().trim());
			}
		}
		
		return guiContent;
	}

	@Override
	public void saveGuiContents(List<GuiContent> guiContents){
		guiContentDao.saveGuiContents(guiContents);
	}
	

	@Override
	public List<GuiContent> findObjectByFields(String[] fields,Object[] params) {
		QueryUtils queryUtils=new QueryUtils(GuiContent.class, "entity");
		if(fields!=null&&fields.length>0&&params!=null&&params.length>0){
			for(int i=0;i<fields.length;i++){
			if(!StringUtils.isEmpty(fields[i])&&!StringUtils.isEmpty((params[i]+""))){
				queryUtils.addCondition("entity."+fields[i], params[i]);				
			}
			}
		}
		return guiContentDao.findObjectByFields(queryUtils);
	}

	
	
}
