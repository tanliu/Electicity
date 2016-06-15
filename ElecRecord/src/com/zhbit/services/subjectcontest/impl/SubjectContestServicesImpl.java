package com.zhbit.services.subjectcontest.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.subjectcontest.SubjectContestDao;
import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.Student;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.subjectcontest.SubjectContestServices;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.EncryptUtils;
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
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	
	SubjectContestDao subjectContestDao;
	@Resource(name=SubjectContestDao.DAO_NAME)
	 public void setSubjectContestDao(SubjectContestDao subjectContestDao) {
	    	super.setBaseDao(subjectContestDao);
			this.subjectContestDao = subjectContestDao;
			
		}
	@Override
	public void save(Subjectcontest subjectcontest) {
		subjectContestDao.add(subjectcontest);
	}
	@Override
	public void saveFromExcel(List<Object> subjectcontests, String creator) {
		if(subjectcontests!=null&&subjectcontests.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : subjectcontests) {
				Subjectcontest subjectcontest=(Subjectcontest) object;
				//判断是否存在这个学生
				Boolean flag=this.hasStudent(subjectcontest.getStudentNo());
				if(!flag){ //如果系统中没有这个学生的信息
					subjectcontest.setCreateTime(new Timestamp(new Date().getTime()));
					subjectcontest.setCreator(creator);
					//设置学生id（到数据库中找）
					System.out.println(subjectcontest.getStudentNo());
					Student student=studentServices.getStudentByNo(subjectcontest.getStudentNo());
					String sid=student.getStuId();
					subjectcontest.setStuId(sid);
					this.save(subjectcontest);					
				}
			}
		}
		
	}

	public Boolean hasStudent(String studentNo) {
		String[] fields={"studentNo=?"};
		String[] params={studentNo};
		List<Subjectcontest> subjectcontest = findObjectByFields(fields, params);
		if(subjectcontest==null||subjectcontest.size()==0){
			return false;
		}
		return true;
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
				fields=new String[]{"stuName like ?","studentNo=?","grantUnits like ?","rewardName like ?"};
				params=new String[]{"%"+subjectcontest.getStuName()+"%",subjectcontest.getStudentNo(),"%"+subjectcontest.getGrantUnits()+"%","%"+subjectcontest.getRewardName()+"%"};
			}else if(!StringUtils.isEmpty(subjectcontest.getStudentNo())){
				fields=new String[]{"studentNo=?","stuName like ?","grantUnits like ?","rewardName like ?"};
				params=new String[]{subjectcontest.getStudentNo(),"%"+subjectcontest.getStuName()+"%","%"+subjectcontest.getGrantUnits()+"%","%"+subjectcontest.getRewardName()+"%"};
			}else if(!StringUtils.isEmpty(subjectcontest.getGrantUnits())){
				fields=new String[]{"grantUnits like ?","stuName like ?","studentNo=?","rewardName like ?"};
				params=new String[]{"%"+subjectcontest.getGrantUnits()+"%","%"+subjectcontest.getStuName()+"%",subjectcontest.getStudentNo(),"%"+subjectcontest.getRewardName()+"%"};
			}else  if(!StringUtils.isEmpty(subjectcontest.getRewardName())){
				fields=new String[]{"rewardName like ?","stuName like ?","studentNo=?","grantUnits like ?"};
				params=new String[]{"%"+subjectcontest.getRewardName()+"%","%"+subjectcontest.getStuName()+"%",subjectcontest.getStudentNo(),"%"+subjectcontest.getGrantUnits()+"%"};
			}
		}

		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	
	
	public List<Subjectcontest> queryListDownload(Serializable... id) {
		List<Subjectcontest> list=subjectContestDao.queryListDownload(id);
		return list;
	}
	@Override
	public List<Subjectcontest> queryAllList() {
		return subjectContestDao.queryAllList();
	}
	
}