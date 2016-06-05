package com.zhbit.services.tutor.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
	@Resource(name=TutorDao.DAO_NAME)
	public void setTutorDao(TutorDao tutorDao) {
		super.setBaseDao(tutorDao);
		this.tutorDao = tutorDao;
	}
	@Override
	public PageUtils queryList(Tutor tutor, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";
		
		if(tutor!=null){//当tutor不为空时
			//先去除学号和姓名中可能存在的空格
			if(!StringUtils.isEmpty(tutor.getStuName())){
				tutor.setStuName(tutor.getStuName().trim());
			}
			if(!StringUtils.isEmpty(tutor.getStudentNo())){
				tutor.setStudentNo(tutor.getStudentNo().trim());
			}
			
			if(!StringUtils.isEmpty(tutor.getStudentNo())){
				fields=new String[]{"studentNo=?","stuName like ?","guidDate like ?"};
				params=new String[]{tutor.getStudentNo(),"%"+tutor.getStuName()+"%","%"+tutor.getGuidDate()+"%"};
			}
			else if(!StringUtils.isEmpty(tutor.getStuName())){
				fields=new String[]{"stuName like ?","studentNo=?","guidDate like ?"};
				params=new String[]{"%"+tutor.getStuName()+"%",tutor.getStudentNo(),"%"+tutor.getGuidDate()+"%"};
			}
			else if(!StringUtils.isEmpty(tutor.getGuidDate()+"")){
				fields=new String[]{"guidDate like ?","stuName like ?","studentNo=?"};
				params=new String[]{"%"+tutor.getGuidDate()+"%","%"+tutor.getStuName()+"%",tutor.getStudentNo()};
			}
		}
		
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	
}
