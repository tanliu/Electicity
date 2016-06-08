package com.zhbit.services.tutor.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.BaseDao;
import com.zhbit.dao.tutor.TutorDao;
import com.zhbit.entity.Tutor;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.tutor.TutorServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： TutorServicesImpl
 * 类描述：用于辅导信息模块的Services实现层
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午8:49:09
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午8:49:09
 * 修改备注： 
 * @version 
 */ 
@Service(value=TutorServices.SERVICE_NAME)
public class TutorServicesImpl extends BaseServicesImpl<Tutor> implements TutorServices {
	
	
	TutorDao tutorDao;
	Timestamp nextday;
	@Resource(name=TutorDao.DAO_NAME)
	public void setTutorDao(TutorDao tutorDao) {
		super.setBaseDao(tutorDao);
		this.tutorDao = tutorDao;
	}
	
	@Override
	public PageUtils queryList(Tutor tutor, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String[] fields=null;
		Object[] params=null;
		String proterty="createTime";
		
		if(tutor!=null){//当tutor不为空时
			//先去除学号和姓名中可能存在的空格
			if(!StringUtils.isEmpty(tutor.getStuName())){
				tutor.setStuName(tutor.getStuName().trim());
			}
			if(!StringUtils.isEmpty(tutor.getStudentNo())){
				tutor.setStudentNo(tutor.getStudentNo().trim());
			}
			
			//用于查询某个具体日期的数据
			if(tutor.getGuidDate()!=null){
				long time=tutor.getGuidDate().getTime();
				time=time+24*60*60*1000; 
				nextday=new Timestamp(time);
			}
			
			
			if(tutor.getGuidDate()==null){//此处与学籍异动信息模块不同，这里要对辅导日期进行判空处理
				fields=new String[]{"studentNo=?","stuName like ?"};
				params=new Object[]{tutor.getStudentNo(),"%"+tutor.getStuName()+"%"};
			}else{
				fields=new String[]{"stuName like ?","studentNo=?","guidDate>?","guidDate<?"};
				params=new Object[]{"%"+tutor.getStuName()+"%",tutor.getStudentNo(),tutor.getGuidDate(),nextday};
			}
				
		}
		
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	/**
		 * 方法描述:重写getPageUtils方法，因为此模块的查询条件中有比较特殊的查询条件
		 * @param
		 * @param 
		 */
	@Override
	public PageUtils getPageUtils(String[] fields, Object[] params, String proterty, String order, int pageNO,
			int pageSize) {
		
		// TODO Auto-generated method stub
		QueryUtils queryUtils=new QueryUtils(Tutor.class, "entity");
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
		
		return tutorDao.getPageUtils(queryUtils, pageNO, pageSize);
		
	}

	@Override
	public Tutor trimTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		if(tutor!=null){
			if(!StringUtils.isEmpty(tutor.getStudentNo())){
				tutor.setStudentNo(tutor.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(tutor.getClassName())){
				tutor.setClassName(tutor.getClassName().trim());
			}
			if(!StringUtils.isEmpty(tutor.getStuName())){
				tutor.setStuName(tutor.getStuName().trim());
			}
			if(!StringUtils.isEmpty(tutor.getGuidAddress())){
				tutor.setGuidAddress(tutor.getGuidAddress().trim());
			}
			if(!StringUtils.isEmpty(tutor.getGuidContent())){
				tutor.setGuidContent(tutor.getGuidContent().trim());
			}
			if(!StringUtils.isEmpty(tutor.getDemo())){
				tutor.setDemo(tutor.getDemo().trim());
			}
		}
		
		return tutor;
	}
	
	
	
	
	
	
}
