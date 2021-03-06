/**
 * 
 */
package com.zhbit.dao.system.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.RoleDao;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.entity.UserRole;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleDaoImpl 
 * 类描述： 角色模块的Dao层实现类
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:28:37
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:28:37
 * 修改备注： 
 * @version 
 */
@Repository(value=RoleDao.DAO_NAME)
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void saveRoleAuthority(RoleAuthority roleAuthority) {
		getSession().save(roleAuthority);
		
	}

	@Override
	public List<RoleAuthority> getRoleAuthority(String roleId) {
		String Hql="from "+RoleAuthority.class.getSimpleName()+" where roleId = ?";
		Query query=getSession().createQuery(Hql);
		query.setParameter(0, roleId);
		return query.list();
	}

	@Override
	public void deleteRoleAuthority(List<RoleAuthority> roleAuthorities) {
		if(roleAuthorities!=null){
			getHibernateTemplate().deleteAll(roleAuthorities);			
		}
		
		
	}




}
