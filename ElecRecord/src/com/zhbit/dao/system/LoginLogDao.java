/**
 * 
 */
package com.zhbit.dao.system;

import java.util.List;

import com.zhbit.entity.LoginLog;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogDao 
 * 类描述： 系统登录日志Dao层接口
 * 创建人：谭柳
 * 创建时间：2016年6月5日 上午10:48:17
 * 修改人：TanLiu 
 * 修改时间：2016年6月5日 上午10:48:17
 * 修改备注： 
 * @version 
 */
public interface LoginLogDao {
	public final static String DAO_NAME="com.zhbit.dao.system.LoginLogDaoImpl";
	
	public List<LoginLog> findLoginLogByUserNO(String employNo);
	public void save(LoginLog loginLog);

}
