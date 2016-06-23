package com.zhbit.services.couscholarship.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.couscholarship.CouscholarshipDao;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.Student;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.couscholarship.CouscholarshipServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：CouscholarshipServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:47:40
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:47:40
 * 修改备注： 
 * @version 
 */
@Service(value=CouscholarshipServices.SERVICES_NAME)
public class CouscholarshipServicesImpl extends BaseServicesImpl<CountryScholarship> implements
CouscholarshipServices{
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	//初始化Dao层
	CouscholarshipDao couscholarshipDao;
		@Resource(name=CouscholarshipDao.DAO_NAME)
		 public void setPolstatusDao(CouscholarshipDao couscholarshipDao) {
	    	super.setBaseDao(couscholarshipDao);
			this.couscholarshipDao = couscholarshipDao;
			
		}
	@Override
	public PageUtils queryList(CountryScholarship countryScholarship, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		if(countryScholarship!=null){ //判定countryScholarship不为空时
			
			//先去除存在的空格
			if(!StringUtils.isEmpty(countryScholarship.getStuName())){
				countryScholarship.setStuName(countryScholarship.getStuName().trim());
		    }
		    if(!StringUtils.isEmpty(countryScholarship.getOrgName())){
		    	countryScholarship.setOrgName(countryScholarship.getOrgName().trim());
			}
		    if(!StringUtils.isEmpty(countryScholarship.getRewardName())){
		    	countryScholarship.setRewardName(countryScholarship.getRewardName().trim());
			}
			////多个查询条件组合
			if(!StringUtils.isEmpty(countryScholarship.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","orgName=?","rewardName=?"};
				params=new String[]{"%"+countryScholarship.getStuName()+"%",countryScholarship.getOrgName(),countryScholarship.getRewardName()};
			}else if(!StringUtils.isEmpty(countryScholarship.getOrgName())){
				fields=new String[]{"orgName=?","stuName like ?","rewardName=?"};
				params=new String[]{countryScholarship.getOrgName(),"%"+countryScholarship.getStuName()+"%",countryScholarship.getRewardName()};
			}else if(!StringUtils.isEmpty(countryScholarship.getRewardName())){
				fields=new String[]{"rewardName=?","orgName=?","stuName like ?",};
				params=new String[]{countryScholarship.getRewardName(),countryScholarship.getOrgName(),"%"+countryScholarship.getStuName()+"%"};
			}
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	@Override
	public void saveFromExcel(List<Object> countryScholarships, String creator) {
		if(countryScholarships!=null&&countryScholarships.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : countryScholarships) {
				CountryScholarship countryScholarship=(CountryScholarship) object;
				
				String[] fields;
				Object[] params;
	               fields=new String[]{"studentNo=?","rewardName=?"};
	               params=new Object[]{countryScholarship.getStudentNo(),countryScholarship.getRewardName()};
	               if(this.findObjectByFields(fields, params)==null){
	            	   //先查询要插入的数据系统中是否为空，为空才插入
	            	 //获取学生的学号,将学号赋给countryScholarship实体。
	   				Student student=studentServices.getStudentByNo(countryScholarship.getStudentNo());
	   				countryScholarship.setStuId(student.getStuId());
			
				countryScholarship.setCreator(creator);
				countryScholarship.setCreateTime(new Timestamp(new Date().getTime()));
				this.save(countryScholarship);
			}
			}
		}
		
	}

}
