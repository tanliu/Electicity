/**
 * 
 */
package com.zhbit.dao.system;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.dao.system.impl.SystemDllDaoImpl;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.system.impl.SystemDllServicesImpl;

/** 
 * 项目名称：ElecRecord
 * 类名称：SystemDllDao 
 * 类描述： 数据字典有Dao层接口
 * 创建人：谭柳
 * 创建时间：2016年4月28日 上午9:39:40
 * 修改人：谭柳
 * 修改时间：2016年4月28日 上午9:39:40
 * 修改备注： 
 * @version 
 */
public interface SystemDllDao extends BaseDao<SystemDll> {
	public static final String DAO_NAME="com.zhbit.dao.system.impl.SystemDllDaoImpl";

	List<SystemDll> findKeyWordByDistinct();


	
}
