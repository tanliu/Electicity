/**
 * 
 */
package com.zhbit.services.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.BaseDao;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Organization;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.util.QueryUtils;

import freemarker.template.utility.StringUtil;

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
	@Override
	public void editorChild(String oldparentId, Organization organize) {
		//查找到旧结点的所有父结点
		Organization oldOrganize=findObjectById(oldparentId);
		//查找到新的父结点的所有结点
		Organization newOrganize=findObjectById(organize.getParentId());
		//查找所有含有与旧结点想同的子结点
		QueryUtils queryUtils=new QueryUtils(Organization.class,"o");
		queryUtils.addCondition("o.parentIds like ?", "%"+oldOrganize.getParentIds()+"%");
		List<Organization> organizations=this.findObjectByFields(queryUtils);
		//遍历替换所有子结点
		for (Organization organization : organizations) {
			String parentIds=organization.getParentIds();
			if(!StringUtils.isEmpty(parentIds)){
				parentIds.replace(oldOrganize.getParentIds(), newOrganize.getParentIds());
				organization.setParentIds(parentIds);
			}
		}
		organizeDao.saveOrUpdateAll(organizations);
		
		
	}
}
