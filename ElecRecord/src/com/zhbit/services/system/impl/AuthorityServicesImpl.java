/**
 * 
 */
package com.zhbit.services.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.system.AuthorityDao;
import com.zhbit.entity.Authority;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.AuthorityServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityServicesImpl 
 * 类描述： 权限管理Services层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年5月29日 下午10:52:27
 * 修改人：TanLiu 
 * 修改时间：2016年5月29日 下午10:52:27
 * 修改备注： 
 * @version 
 */
@Service(value=AuthorityServices.SERVICE_NAME)
public class AuthorityServicesImpl extends BaseServicesImpl<Authority> implements AuthorityServices {
	
	AuthorityDao authorityDao;
	@Resource(name=AuthorityDao.DAO_NAME)
	public void setAuthorityDao(AuthorityDao authorityDao) {
		super.setBaseDao(authorityDao);
		this.authorityDao = authorityDao;
	}
	@Override
	public void saveAuthoity(Authority authority) {
		
		// 设定子结点所有父结点的=父结的所有交结点+父结点本身
		if(!authority.getParentId().equals("0")){
			//查找父结的所有父结点
			Authority temp=authorityDao.findObjectById(authority.getParentId());
			authority.setParentIds(temp.getParentIds()+","+temp.getParentId());
		}else{
			authority.setParentIds(authority.getParentId());
		}
		//持久化权限结点
		authorityDao.save(authority);
		
	}


}
