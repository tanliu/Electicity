package com.zhbit.services.grantscholarship.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.couscholarship.CouscholarshipDao;
import com.zhbit.dao.grantscholarship.GrantscholarshipDao;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.couscholarship.CouscholarshipServices;
import com.zhbit.services.grantscholarship.GrantscholarshipServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：GrantscholarshipServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月14日 下午9:33:18
 * 修改人：罗吉林
 * 修改时间：2016年6月14日 下午9:33:18
 * 修改备注： 
 * @version 
 */

@Service(value=GrantscholarshipServices.SERVICES_NAME)
public class GrantscholarshipServicesImpl extends BaseServicesImpl<GrantScholarship> implements
GrantscholarshipServices{
	//初始化Dao层
	GrantscholarshipDao grantscholarshipDao;
		@Resource(name=GrantscholarshipDao.DAO_NAME)
		 public void setPolstatusDao(GrantscholarshipDao grantscholarshipDao) {
	    	super.setBaseDao(grantscholarshipDao);
			this.grantscholarshipDao = grantscholarshipDao;
		}
	
	@Override
	public PageUtils queryList(GrantScholarship grantScholarship, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		if(grantScholarship!=null){ //判定grantScholarship不为空时
			
			//先去除存在的空格
			if(!StringUtils.isEmpty(grantScholarship.getStuName())){
				grantScholarship.setStuName(grantScholarship.getStuName().trim());
		    }
		    if(!StringUtils.isEmpty(grantScholarship.getOrgName())){
		    	grantScholarship.setOrgName(grantScholarship.getOrgName().trim());
			}
		    if(!StringUtils.isEmpty(grantScholarship.getStudentNo())){
		    	grantScholarship.setStudentNo(grantScholarship.getStudentNo().trim());
			}
			////多个查询条件组合
			if(!StringUtils.isEmpty(grantScholarship.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","orgName=?","studentNo=?"};
				params=new String[]{"%"+grantScholarship.getStuName()+"%",grantScholarship.getOrgName(),grantScholarship.getStudentNo()};
			}else if(!StringUtils.isEmpty(grantScholarship.getOrgName())){
				fields=new String[]{"orgName=?","stuName like ?","studentNo=?"};
				params=new String[]{grantScholarship.getOrgName(),"%"+grantScholarship.getStuName()+"%",grantScholarship.getStudentNo()};
			}else if(!StringUtils.isEmpty(grantScholarship.getStudentNo())){
				fields=new String[]{"studentNo=?","orgName=?","stuName like ?",};
				params=new String[]{grantScholarship.getStudentNo(),grantScholarship.getOrgName(),"%"+grantScholarship.getStuName()+"%"};
			}
		}
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

	@Override
	public void saveFromExcel(List<Object> grantScholarships, String creator) {
		if(grantScholarships!=null&&grantScholarships.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : grantScholarships) {
				GrantScholarship grantScholarship=(GrantScholarship) object;
				//获取学生的学号,将学号赋给countryScholarship实体。
				//Student student=studentServices.getStudentByNo(politicalstatus.getStudentNo());
				//politicalstatus.setStuId(student.getStuId());

				String[] fields;
				Object[] params;
				
               fields=new String[]{"studentNo=?",};
               params=new Object[]{grantScholarship.getStudentNo()};
               if(this.findObjectByFields(fields, params)==null){
            	   //先查询要插入的数据系统中是否为空，为空才插入
				//这里先设置一个值用来测试
				grantScholarship.setStuId("9527");
				grantScholarship.setCreator(creator);
				grantScholarship.setCreateTime(new Timestamp(new Date().getTime()));
				this.save(grantScholarship);
			}
			}
		}
		
	}

}
