/**
 * 
 */
package com.zhbit.dao.system;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.entity.UserRole;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleDao 
 * 类描述： 角色Dao层的接口
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:27:26
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:27:26
 * 修改备注： 
 * @version 
 */
public interface RoleDao extends BaseDao<Role> {
	public static String DAO_NAME="com.zhbit.dao.system.impl.RoleDaoImpl";
	

	

}
