/**
 * 
 */
package com.zhbit.dao.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.system.LoginLogDao;
import com.zhbit.entity.LoginLog;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogDaoImpl 
 * 类描述： 系统登录日志Dao层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月5日 上午10:50:39
 * 修改人：TanLiu 
 * 修改时间：2016年6月5日 上午10:50:39
 * 修改备注： 
 * @version 
 */
@Repository(value=LoginLogDao.DAO_NAME)
public class LoginLogDaoImpl extends HibernateDaoSupport implements LoginLogDao {

	@Resource(name="sessionFactory")
	public void setDi(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public List<LoginLog> findLoginLogByUserNO(String employNo) {
		String Hql="From "+LoginLog.class.getSimpleName()+" where employNo = "+employNo+" order by loginTime DESC";		
		return getHibernateTemplate().find(Hql);
	}

	@Override
	public void save(LoginLog loginLog) {
           getHibernateTemplate().save(loginLog);		
	}
}
