package com.zhbit.services.system;

import com.zhbit.entity.StuStatus;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：UserServices 
 * 类描述： 用户管理的Service层接口
 * 创建人：谭柳
 * 创建时间：2016年5月24日 上午10:42:59
 * 修改人：TanLiu 
 * 修改时间：2016年5月24日 上午10:42:59
 * 修改备注： 
 * @version 
 */ 
public interface UserServices extends BaseServices<User> {
   public final static String SERVER_NAME="com.zhbit.services.system.impl.UserServicesImpl";
   
   public PageUtils queryList(User user,int pageNO,int pageSize);

    /**
     * 方法描述:修改密码
     * @param user 用户信息
     * @param confirmpwd 确认密码
     * @return
     */
    public boolean editorPwd(User user, String confirmpwd);

	/**
	 * 方法描述:保存用户
	 * @param user
	 * @param roleIds 
	 */
	public void saveUser(User user, String[] roleIds);

	/**
	 * 方法描述:修改用户
	 * @param user
	 * @param roleIds
	 */
	public void editorUser(User user, String[] roleIds);

	/**
	 * 方法描述:删除用户
	 * @param selectedRow
	 */
	public void deleteUser(String[] selectedRow);
    
}
