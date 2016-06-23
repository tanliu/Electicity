/**
 * 
 */
package com.zhbit.util;

import javax.servlet.http.HttpServletRequest;

import com.zhbit.entity.Student;
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

	/**
	 * 方法描述:判断是否是学生，如果是学生的话，就把查询条件强加
	 * @param request
	 * @param queryNO
	 * @return
	 */
	public static String checkStudentAuthority(HttpServletRequest request, String queryNO) {
		Student student=(Student) request.getSession().getAttribute("student");
		if(student!=null){
			queryNO=student.getStudentNo();
		}
		return queryNO;
	}
	/**
	 * 方法描述:判断是否是学生，如果是学生的话，就把查询条件强加为自己的名字
	 * @param request
	 * @param queryNO
	 * @return
	 */
	public static String checkStudentName(HttpServletRequest request, String query_stuName) {
		Student student=(Student) request.getSession().getAttribute("student");
		if(student!=null){
			query_stuName=student.getStuName();
		}
		return query_stuName;
	}
}
