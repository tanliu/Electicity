/**
 * 
 */
package com.zhbit.dao.system.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.User;
import com.zhbit.entity.UserRole;

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

	@Override
	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	@Override
	public void deleteUserRole(String userId) {
		String Hql="From "+UserRole.class.getSimpleName()+" where  user.userId = ?";
		Query query=getSession().createQuery(Hql);
		query.setParameter(0, userId);
		if(query.list()!=null){
			getHibernateTemplate().deleteAll(query.list());			
		}
		
	}

}
