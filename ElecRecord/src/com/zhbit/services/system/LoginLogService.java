/**
 * 
 */
package com.zhbit.services.system;

import java.util.List;

import com.zhbit.entity.LoginLog;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogService 
 * 类描述： 系统登录日志Service层接口
 * 创建人：谭柳
 * 创建时间：2016年6月5日 上午10:57:13
 * 修改人：TanLiu 
 * 修改时间：2016年6月5日 上午10:57:13
 * 修改备注： 
 * @version 
 */
public interface LoginLogService {

	public final static String SERVICES_NAME="com.zhbit.services.system.LoginLogServiceImpl";
	
	public List<LoginLog> findLoginLogByUserNO(String employNo);
	public void save(LoginLog loginLog);
}
