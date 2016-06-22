/**
 * 
 */
package com.zhbit.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhbit.entity.LoginLog;
import com.zhbit.entity.Student;
import com.zhbit.entity.User;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.system.LoginLogService;
import com.zhbit.services.system.UserServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogInterceptor 
 * 类描述： 登录日志信息的拦截
 * 创建人：谭柳
 * 创建时间：2016年6月6日 下午5:02:30
 * 修改人：TanLiu 
 * 修改时间：2016年6月6日 下午5:02:30
 * 修改备注： 
 * @version 
 */
public class LoginLogInterceptor extends MethodFilterInterceptor{

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		Boolean isUser=false;
		//获得requst
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		String username=request.getParameter("username");
		WebApplicationContext webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserServices userServices=(UserServices) webApplicationContext.getBean(UserServices.SERVER_NAME);
		StudentServices studentServices=(StudentServices) webApplicationContext.getBean(StudentServices.SERVICES_NAME);
		LoginLogService loginLogService=(LoginLogService) webApplicationContext.getBean(LoginLogService.SERVICES_NAME);
		
		LoginLog log=new LoginLog();
		if(!StringUtils.isBlank(username)){
			//去查数据库
			String[] fields={"employNo=?"};
			String[] params={username};
			List<User> users=userServices.findObjectByFields(fields, params);
			Student student=studentServices.getStudentByNo(username);
			if(users!=null&&users.size()>0){
				isUser=true;
				if(users.get(0)!=null){
					//初始化数据
					initLog(log,users.get(0),request);
				}
			}else if(student!=null){
				isUser=true;

				initLog(log,student,request);

			}
			
			
		}
		String result=invocation.invoke();
		if(result.equals("success")){
			log.setIfSuccess(LoginLog.LOGIN_STATE_SUCCESS);
		}else{
			if(!StringUtils.isBlank(username)){				
				log.setIfSuccess(LoginLog.LOGIN_STATE_FAIL);			
			}
		}
		if(isUser){	
			loginLogService.save(log);
		}
		return result;
	}

	private void initLog(LoginLog log, User user, HttpServletRequest request) {
		log.setEmployNo(user.getEmployNo());
		log.setLoginTime(new Timestamp(new Date().getTime()));
		//获取ip地址
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){ 
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr(); 
	    }
		log.setLoginIp(ip);
		
	}
	private void initLog(LoginLog log, Student student, HttpServletRequest request) {
		log.setEmployNo(student.getStudentNo());
		log.setLoginTime(new Timestamp(new Date().getTime()));
		//获取ip地址
		String ip = request.getHeader("x-forwarded-for"); 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){ 
			ip = request.getHeader("WL-Proxy-Client-IP");
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr(); 
		}
		log.setLoginIp(ip);
		
	}



}
