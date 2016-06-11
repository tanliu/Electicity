/**
 * 
 */
package com.zhbit.util;

import javax.servlet.http.HttpServletRequest;

import com.zhbit.entity.User;

/** 
 * 项目名称：ElecRecord
 * 类名称：RequstUtils 
 * 类描述： 对request中的数据进行处理的
 * 创建人：谭柳
 * 创建时间：2016年6月9日 下午5:10:18
 * 修改人：TanLiu 
 * 修改时间：2016年6月9日 下午5:10:18
 * 修改备注： 
 * @version 
 */
public class RequestUtils {

	public static String getUserName(HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute(User.SESSION_NAME);
		return user.getEmployName();
	}

}
