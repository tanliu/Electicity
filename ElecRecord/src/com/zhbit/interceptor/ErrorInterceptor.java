/**
 * 
 */
package com.zhbit.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/** 
 * 项目名称：ElecRecord
 * 类名称：ErrorInterceptor 
 * 类描述： 错误信息的拦截器
 * 创建人：谭柳
 * 创建时间：2016年6月6日 下午3:35:47
 * 修改人：TanLiu 
 * 修改时间：2016年6月6日 下午3:35:47
 * 修改备注： 
 * @version 
 */
public class ErrorInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得requst
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		try {
			String result=invocation.invoke();
			return result;
		} catch (Exception e) {
			
			String erroeMessage="出现错误信息，请查看日志";
			if(e instanceof RuntimeException){
				//未知的运行时异常   
				RuntimeException re = (RuntimeException) e;
				//re.printStackTrace();
				erroeMessage = re.getMessage().trim();
			}
			request.setAttribute("error", "服务器正忙！！请联系管理员");
			return "error";
		}
	}

}
