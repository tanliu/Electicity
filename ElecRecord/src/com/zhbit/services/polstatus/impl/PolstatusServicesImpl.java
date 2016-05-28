package com.zhbit.services.polstatus.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.polstatus.PolstatusServices;


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
	public String add(Politicalstatus politicalstatus){
		polstatusDao.add(politicalstatus);
		return null;
	}
	
}
