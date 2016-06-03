package com.zhbit.services.SubjectContest.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.SubjectContest.SubjectContestDao;
import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.SubjectContest.SubjectContestServices;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/**
 * 项目名称：ElecRecord
 * 类名称：SubjectContestServicesImpl 
 * 类描述： 学科竞赛信息管理Services层实现类
 * 创建人：朱嘉鑫
 * 创建时间：2016年5月28日 下午21:53:02
 * 修改人：zjx 
 * 修改时间：2016年5月28日 下午21:53:02
 * 修改备注： 
 * @version 
 */ 
@Service(value=SubjectContestServices.SERVER_NAME)
public class SubjectContestServicesImpl extends BaseServicesImpl<Subjectcontest> 
	implements SubjectContestServices {
	
	SubjectContestDao subjectContestDao;
	@Resource(name=SubjectContestDao.DAO_NAME)
	 public void setPolstatusDao(SubjectContestDao subjectContestDao) {
	    	super.setBaseDao(subjectContestDao);
			this.subjectContestDao = subjectContestDao;
			
		}
	@Override
	public void save(Subjectcontest subjectcontest) {
		subjectContestDao.add(subjectcontest);
	}


	

	@Override
	public PageUtils queryList(Subjectcontest subjectcontest, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";		
		if(subjectcontest!=null){ //判定politicalstatus不为空时
			////多个查询条件组合
			if(!StringUtils.isEmpty(subjectcontest.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","studentNo=?"};
				params=new String[]{"%"+subjectcontest.getStuName()+"%",subjectcontest.getStudentNo()};
			}else if(!StringUtils.isEmpty(subjectcontest.getStudentNo())){
				fields=new String[]{"studentNo=?","stuName like ?",};
				params=new String[]{subjectcontest.getStudentNo(),"%"+subjectcontest.getStuName()+"%"};
			}
		}

		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	
	
	public List<Subjectcontest> queryListDownload(Serializable... id) {
		List<Subjectcontest> list=subjectContestDao.queryListDownload(id);
		return list;
	}
	
}
