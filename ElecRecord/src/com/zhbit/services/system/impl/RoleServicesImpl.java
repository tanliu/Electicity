/**
 * 
 */
package com.zhbit.services.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.system.RoleDao;
import com.zhbit.entity.Role;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.RoleServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleServicesImpl 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:39:33
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:39:33
 * 修改备注： 
 * @version 
 */
@Service(value=RoleServices.SEVICES_NAME)
public class RoleServicesImpl extends BaseServicesImpl<Role> implements RoleServices {

	RoleDao roleDao;
	@Resource(name=RoleDao.DAO_NAME)
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
}
