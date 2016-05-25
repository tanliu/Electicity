package com.zhbit.services.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.UserServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：UserServicesImpl 
 * 类描述： 用户管理Services实现类
 * 创建人：谭柳
 * 创建时间：2016年5月24日 上午10:43:53
 * 修改人：TanLiu 
 * 修改时间：2016年5月24日 上午10:43:53
 * 修改备注： 
 * @version 
 */ 
@Service(value=UserServices.SERVER_NAME)
public class UserServicesImpl extends BaseServicesImpl<User> implements UserServices {
	UserDao userDao;
	@Resource(name=UserDao.DAO_NAME)
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	
}
