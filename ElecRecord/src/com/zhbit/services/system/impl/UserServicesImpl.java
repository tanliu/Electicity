package com.zhbit.services.system.impl;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

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
	@Override
	public PageUtils queryList(User user, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";		
		if(user!=null){ //user不为空时
			if(!StringUtils.isEmpty(user.getEmployNo())){ //查询条件是用户编号
				fields=new String[]{"employNo=?"};
				params=new String[]{user.getEmployNo()};
			}else if(!StringUtils.isEmpty(user.getEmployName())){ //查询条件是用户名
				fields=new String[]{"employName like ?"};
				params=new String[]{"%"+user.getEmployName()+"%"};
				
			}
			
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
}
