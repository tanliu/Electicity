/**
 * 
 */
package com.zhbit.services.system;

import com.zhbit.entity.Role;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleServices 
 * 类描述： 角色 模块的Services层接口
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:37:41
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:37:41
 * 修改备注： 
 * @version 
 */
public interface RoleServices extends BaseServices<Role> {
	public static String SEVICES_NAME="com.zhbit.services.system.impl.RoleServicesImpl";	
	

}
