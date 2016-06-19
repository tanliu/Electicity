package com.zhbit.services.loanscholarship.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.grantscholarship.GrantscholarshipDao;
import com.zhbit.dao.loanscholarship.LoanscholarshipDao;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.entity.LoanScholarship;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.couscholarship.CouscholarshipServices;
import com.zhbit.services.loanscholarship.LoanscholarshipServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoanscholarshipServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月15日 下午5:01:25
 * 修改人：罗吉林
 * 修改时间：2016年6月15日 下午5:01:25
 * 修改备注： 
 * @version 
 */
@Service(value=LoanscholarshipServices.SERVICES_NAME)
public class LoanscholarshipServicesImpl extends BaseServicesImpl<LoanScholarship> implements
LoanscholarshipServices{
	//初始化Dao层
		LoanscholarshipDao loanscholarshipDao;
			@Resource(name=LoanscholarshipDao.DAO_NAME)
			 public void setPolstatusDao(LoanscholarshipDao loanscholarshipDao) {
		    	super.setBaseDao(loanscholarshipDao);
				this.loanscholarshipDao = loanscholarshipDao;
			}
	@Override
	public PageUtils queryList(LoanScholarship loanscholarship, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		if(loanscholarship!=null){ //判定grantScholarship不为空时
			
			//先去除存在的空格
			if(!StringUtils.isEmpty(loanscholarship.getStuName())){
				loanscholarship.setStuName(loanscholarship.getStuName().trim());
		    }
		    if(!StringUtils.isEmpty(loanscholarship.getCensoredFlag())){
		    	loanscholarship.setCensoredFlag(loanscholarship.getCensoredFlag().trim());
			}
		    if(!StringUtils.isEmpty(loanscholarship.getStudentNo())){
		    	loanscholarship.setStudentNo(loanscholarship.getStudentNo().trim());
			}
			////多个查询条件组合
			if(!StringUtils.isEmpty(loanscholarship.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","censoredFlag=?","studentNo=?"};
				params=new String[]{"%"+loanscholarship.getStuName()+"%",loanscholarship.getCensoredFlag(),loanscholarship.getStudentNo()};
			}else if(!StringUtils.isEmpty(loanscholarship.getCensoredFlag())){
				fields=new String[]{"censoredFlag=?","stuName like ?","studentNo=?"};
				params=new String[]{loanscholarship.getCensoredFlag(),"%"+loanscholarship.getStuName()+"%",loanscholarship.getStudentNo()};
			}else if(!StringUtils.isEmpty(loanscholarship.getStudentNo())){
				fields=new String[]{"studentNo=?","censoredFlag=?","stuName like ?",};
				params=new String[]{loanscholarship.getStudentNo(),loanscholarship.getCensoredFlag(),"%"+loanscholarship.getStuName()+"%"};
			}
		}
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

	@Override
	public void saveFromExcel(List<Object> loanscholarships, String creator) {
		if(loanscholarships!=null&&loanscholarships.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : loanscholarships) {
				LoanScholarship loanscholarship=(LoanScholarship) object;
				//获取学生的学号,将学号赋给countryScholarship实体。
				//Student student=studentServices.getStudentByNo(politicalstatus.getStudentNo());
				//politicalstatus.setStuId(student.getStuId());
				//这里先设置一个值用来测试
				loanscholarship.setStuId("9527");
				loanscholarship.setCreator(creator);
				loanscholarship.setCreateTime(new Timestamp(new Date().getTime()));
				this.save(loanscholarship);
			}
		}
		
	}

}
