/**
 * 
 */
package com.zhbit.services.system;

import java.util.Hashtable;
import java.util.List;

import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

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

	/**
	 * 方法描述:保存角色信息
	 * @param role
	 * @param authoritys
	 */
	void saveRole(Role role, String[] authoritys);

	/**
	 * 方法描述:通过角色编号取得角色权限
	 * @param roleId 角色编号
	 * @return
	 */
	List<RoleAuthority> getRoleAuthority(String roleId);

	/**
	 * 方法描述:获得分布工具
	 * @param querycon
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	PageUtils getPageUtils(String querycon, int pageNO, int pageSize);

	/**
	 * 方法描述:修改权限
	 * @param authoritys 
	 * @param role 
	 */
	void editorRole(Role role, String[] authoritys);

	/**
	 * 方法描述:删除角色
	 * @param selectedRow
	 */
	void deleteRole(String[] selectedRow);

	/**
	 * 方法描述:能过角色查找所有权限
	 * @param userRoleht
	 * @return
	 */
	String findPopedomByRoleIDs(Hashtable<String, String> userRoleht);

	/**
	 * 方法描述:通过角色名查找到角色
	 * @param string
	 * @return
	 */
	Role findObjectByName(String roleName);	
	

}
