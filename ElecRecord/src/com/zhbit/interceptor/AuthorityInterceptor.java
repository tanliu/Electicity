/**
 * 
 */
package com.zhbit.interceptor;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.annotation.Limit;


/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityInterceptor 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月6日 上午8:00:32
 * 修改人：TanLiu 
 * 修改时间：2016年6月6日 上午8:00:32
 * 修改备注： 
 * @version 
 */
public class AuthorityInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String result=null;
		//获得requst
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		//拿到object对象
		Object object=invocation.getAction();
		//拿到当前要访问的方法的名称
		String methodName=invocation.getProxy().getMethod();
		//拿到Action中对应的方法
		Method method=object.getClass().getMethod(methodName, null);
		//如果有权限就放行没有权限就拦截
		if(hasAuthority(request, method)){
			result=invocation.invoke();
		}else{
			request.setAttribute("error", "你没有操作权限！");
			result="error";
		}
		
		return result;
	}
	
	private Boolean hasAuthority(HttpServletRequest request,Method method){
		Boolean flag=false;
		String urls=(String) request.getSession().getAttribute("urls");
		//再从method中拿到权限值
		if(!method.isAnnotationPresent(Limit.class)){
			return true;
		}
		Limit limit = method.getAnnotation(Limit.class);
		//角色信息和权限值查角色权限
		String url=limit.url();
		if(urls.contains(urls)){
			flag=true;
		}
		
/*		//request中拿到用户信息查角色
		Hashtable<String, String> userRoleht=(Hashtable<String, String>) request.getSession().getAttribute("role");
		//再从method中拿到权限值
		if(!method.isAnnotationPresent(Limit.class)){
			return false;
		}
		Limit limit = method.getAnnotation(Limit.class);
		//角色信息和权限值查角色权限
		String authorityId=limit.authorityId();
		//能过权限角色去查表中是否存数据
		WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		RoleAuthotityServices roleAuthotityServices=(RoleAuthotityServices) webApplicationContext.getBean(RoleAuthotityServices.SERVICES_NAME);
		flag=roleAuthotityServices.hasAuthority(userRoleht,authorityId);*/
		
		return flag;
	}

}
