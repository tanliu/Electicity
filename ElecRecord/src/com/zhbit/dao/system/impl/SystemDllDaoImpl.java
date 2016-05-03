package com.zhbit.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.SystemDllDao;
import com.zhbit.entity.SystemDll;

/** 
 * 项目名称：ElecRecord
 * 类名称：SystemDllDaoImpl 
 * 类描述： 数据字典Dao层实现类
 * 创建人：谭柳
 * 创建时间：2016年4月28日 上午10:00:53
 * 修改人：谭柳
 * 修改时间：2016年4月28日 上午10:00:53
 * 修改备注： 
 * @version 
 */ 
@Repository(value=SystemDllDao.DAO_NAME)
public class SystemDllDaoImpl extends BaseDaoImpl<SystemDll> implements SystemDllDao {

	/**
	 * 方法描述:查找数据字典中的所有类型
	 * @return
	 */
	@Override
	public List<SystemDll> findKeyWordByDistinct() {
		List<SystemDll> systemDlls=null;
		String hql="SELECT DISTINCT new "+SystemDll.class.getCanonicalName()+"(o.keyword) from "+SystemDll.class.getName()+" o";
		//String hql="SELECT DISTINCT new com.zhbit.entity.SystemDll(s.keyword) from SystemDll s";
		systemDlls=getHibernateTemplate().find(hql);
		return systemDlls;
	}


	
}
