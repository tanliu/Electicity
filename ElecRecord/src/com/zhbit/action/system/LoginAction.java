/**
 * 
 */
package com.zhbit.action.system;

import java.awt.Menu;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.Authority;
import com.zhbit.entity.LoginLog;
import com.zhbit.entity.User;
import com.zhbit.entity.UserRole;
import com.zhbit.services.system.AuthorityServices;
import com.zhbit.services.system.LoginLogService;
import com.zhbit.services.system.RoleServices;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.LoginUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginAction 
 * 类描述： 系统登录的Action层
 * 创建人：谭柳
 * 创建时间：2016年6月4日 下午4:38:55
 * 修改人：TanLiu 
 * 修改时间：2016年6月4日 下午4:38:55
 * 修改备注： 
 * @version 
 */
@Controller(value="loginAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport {
	List<LoginLog> logs;
	private String username;
	private String password;
	
	@Resource(name=UserServices.SERVER_NAME)
	UserServices userServices;
	@Resource(name=RoleServices.SEVICES_NAME)
	RoleServices roleServices;
	@Resource(name=LoginLogService.SERVICES_NAME)
	LoginLogService loginLogService;
	@Resource(name=AuthorityServices.SERVICE_NAME)
	AuthorityServices authorityServices;


	
	public String login(){
		
		String cookiepassword="";

		if(!StringUtils.isBlank(username)&&!StringUtils.isBlank(password)){	
			//验证码
			boolean flag=LoginUtils.checkNumber(ServletActionContext.getRequest());
			if(!flag){
			    this.addFieldError("error", "验证码不正确");
				return "failLogin";
			}
			password=password.trim();
			username=username.trim();
			cookiepassword=password;
			//------------------------判断有没有这个用户-------------------------
			String[] fields={"employNo=?"};
			String[] params={username};
			List<User> users=userServices.findObjectByFields(fields, params);
			if(users!=null&&users.get(0)!=null){
			   password=EncryptUtils.MD5Encrypt(password);
			   User user=users.get(0);

			   if(password.equals(user.getPassword())&&username.equals(user.getEmployNo())){
				   //判断当前用户的状态
				   if(user.getStatus()==0){
					    this.addFieldError("error", "当前用户已经被注销");
						return "failLogin";
				   }
				   //------------------------存在这个用户时判断这个用户有没有分配了角色-------------------------------------------
				   Hashtable<String, String> userRoleht = new Hashtable<String, String>();
				   Set<UserRole> userRoles=user.getUserRoles();
				   if(userRoles!=null&&userRoles.size()>0){
					   for (UserRole userRole : userRoles) {
						userRoleht.put(userRole.getRole().getRoleId(),userRole.getRole().getRoleName());
					   }
					   //------------------------存在这个用户角色后时判断这个用户有没有分配权限-------------------------------------------
					   //权限autorities的格式是:aa@bb@cc
					   String authorities=roleServices.findPopedomByRoleIDs(userRoleht);
					   if(StringUtils.isBlank(authorities)){
						   
						   this.addFieldError("error", "还没有分配权限，请联系系统管理员！");
						   return "failLogin";  
					   }
					   ServletActionContext.getRequest().getSession().setAttribute("authority", authorities);
					   String urls=authorityServices.findUrls(authorities);
					   ServletActionContext.getRequest().getSession().setAttribute("urls", urls);
				   }else{					   
						   this.addFieldError("error", "还没有分配角色，请联系系统管理员！");
						   return "failLogin";
					   
				   }
				   ServletActionContext.getRequest().getSession().setAttribute("user", users.get(0));				   
				   ServletActionContext.getRequest().getSession().setAttribute("role", userRoleht);				   
			   }else{
				   this.addFieldError("error", "输入密码不正确！");
				   return "failLogin";				   
			   }
			}else{
				this.addFieldError("error", "用户名或者密码不正确！");
				return "failLogin";				
			}
			
		}else{
			this.addFieldError("error", "用户名或者密码不可以为空！");
			return "failLogin";			
			
		}
		LoginUtils.remeberMe(username, cookiepassword, ServletActionContext.getRequest(), ServletActionContext.getResponse());
		return "success";
	}
	public String loginUI(){
		return "loginUI";
	}
	
	public String home(){
		return "home";
	}
	public String personInfo(){
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		logs=loginLogService.findLoginLogByUserNO(user.getEmployNo());
		ActionContext.getContext().getValueStack().push(logs);
		//ServletActionContext.getRequest().setAttribute("logs", logs);
		return "personInfo";
	}
	
	public String logout(){
	    
		ServletActionContext.getRequest().getSession().invalidate();
		return "loginUI";
	}
	
	/**
	 * 方法描述:查找到权限的菜单树
	 * @return
	 */
	public String menu(){
		String authorities=(String) ServletActionContext.getRequest().getSession().getAttribute("authority");
		List<Authority> menus=authorityServices.findMenu(authorities);
		ActionContext.getContext().getValueStack().push(menus);
		return "menujson";
	}
	
	//--------------------------------------------getter&&setter---------------------------
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<LoginLog> getLogs() {
		return logs;
	}
	public void setLogs(List<LoginLog> logs) {
		this.logs = logs;
	}
	
}
