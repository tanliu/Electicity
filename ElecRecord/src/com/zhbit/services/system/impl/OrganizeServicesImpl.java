/**
 * 
 */
package com.zhbit.services.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.BaseDao;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Organization;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.OrganizeServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：OrganizeServicesImpl 
 * 类描述： 部门模块下Service接口的实现类
 * 创建人：谭柳
 * 创建时间：2016年5月6日 下午12:58:36
 * 修改人：谭柳
 * 修改时间：2016年5月6日 下午12:58:36
 * 修改备注： 
 * @version 
 */
@Service(value=OrganizeServices.SERVICE_NAME)
public class OrganizeServicesImpl extends BaseServicesImpl<Organization> implements
		OrganizeServices {
	OrganizeDao organizeDao;
	@Resource(name=OrganizeDao.DAO_NAME)
    public void setOrganizeDao(OrganizeDao organizeDao) {
    	super.setBaseDao(organizeDao);
		this.organizeDao = organizeDao;
		
	}
}
