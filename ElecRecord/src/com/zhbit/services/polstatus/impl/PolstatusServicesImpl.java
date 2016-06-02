package com.zhbit.services.polstatus.impl;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;


/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:07:52
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:07:52
 * 修改备注： 
 * @version 
 */
@Service(value=PolstatusServices.SERVICES_NAME)
public class PolstatusServicesImpl extends BaseServicesImpl<Politicalstatus> implements
    PolstatusServices{
	PolstatusDao polstatusDao;
	@Resource(name=PolstatusDao.DAO_NAME)
	 public void setPolstatusDao(PolstatusDao polstatusDao) {
    	super.setBaseDao(polstatusDao);
		this.polstatusDao = polstatusDao;
		
	}
	//调用Dao层的增加信息的add方法
	public String add(Politicalstatus politicalstatus){
		polstatusDao.add(politicalstatus);
		return null;
	}
	
	//继承Services接口的queryList方法，实现数据查询
	@Override
	public PageUtils queryList(Politicalstatus politicalstatus, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		if(politicalstatus!=null){ //判定politicalstatus不为空时
			////多个查询条件组合
			if(!StringUtils.isEmpty(politicalstatus.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?"};
				params=new String[]{"%"+politicalstatus.getStuName()+"%"};
			}else if(!StringUtils.isEmpty(politicalstatus.getStudentNo())){
				fields=new String[]{"studentNo=?"};
				params=new String[]{politicalstatus.getStudentNo()};
			}//else if(politicalstatus.getJoinDate()!=null){
				//politicalstatus.setJoinDate(new Timestamp(new Date().getTime()));
			//	String time=politicalstatus.getJoinDate();
				
			//	fields=new String[]{"joinDate=?"};
			//	params=new String[]{time};
			//}
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
}
