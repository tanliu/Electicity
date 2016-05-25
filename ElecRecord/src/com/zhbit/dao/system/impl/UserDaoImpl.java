/**
 * 
 */
package com.zhbit.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.User;

/** 
 * 项目名称：ElecRecord
 * 类名称：UserDaoImpl 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年5月24日 上午10:41:28
 * 修改人：TanLiu 
 * 修改时间：2016年5月24日 上午10:41:28
 * 修改备注： 
 * @version 
 */
@Repository(value=UserDao.DAO_NAME)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
