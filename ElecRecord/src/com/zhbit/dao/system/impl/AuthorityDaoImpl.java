/**
 * 
 */
package com.zhbit.dao.system.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.AuthorityDao;
import com.zhbit.entity.Authority;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityDaoImpl 
 * 类描述： 权限管理实现Dao层接口数
 * 创建人：谭柳
 * 创建时间：2016年5月29日 下午10:47:24
 * 修改人：TanLiu 
 * 修改时间：2016年5月29日 下午10:47:24
 * 修改备注： 
 * @version 
 */
@Repository(value=AuthorityDao.DAO_NAME)
public class AuthorityDaoImpl extends BaseDaoImpl<Authority> implements AuthorityDao {

	@Override
	public List<Authority> findNodeAndChild(String authorityId) {
		String Hql="From "+Authority.class.getSimpleName()+" Where authorityId=? or parentIds like ?";
		Query query=getSession().createQuery(Hql);
		query.setParameter(0, authorityId);
		query.setParameter(1, "%"+authorityId+"%");		
		return query.list();
	}

	@Override
	public List<Authority> findAuthByAuthAndType(String condition, Integer typeMenu) {
		String Hql="From "+Authority.class.getSimpleName()+" Where authorityId in ("+condition+") and authorityType ="+typeMenu+" order by menuNo ASC";

		return getHibernateTemplate().find(Hql);
	}

	@Override
	public List<Authority> findUrlByAuth(String condition) {
		String Hql="From "+Authority.class.getSimpleName()+" Where authorityId in ("+condition+")";

		return getHibernateTemplate().find(Hql);
	}

}
