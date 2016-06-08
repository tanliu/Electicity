/**
 * 
 */
package com.zhbit.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhbit.entity.User;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityFilter 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月6日 上午12:18:56
 * 修改人：TanLiu 
 * 修改时间：2016年6月6日 上午12:18:56
 * 修改备注： 
 * @version 
 */
public class AuthorityFilter implements Filter {

	List<String> list = new ArrayList<String>();
	List<String> hasSession = new ArrayList<String>();

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		list.add("/index.jsp");
		list.add("/system/login_loginUI.action");
		list.add("/system/login_login.action");
		list.add("/student/student_add.action");
		list.add("/image.jsp");
		//存在session但是还可以放行的
		hasSession.add("/system/login_menu.action");
		
	}



	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		//获取访问路径
		String path=request.getServletPath();
		//这些路径放行
		if(list.contains(path)){
			chain.doFilter(request, response);
			return ;
		}
		//查看Session存不存在
		User user=(User) request.getSession().getAttribute("user");
		
		if(user!=null){
/*			//存在session但是不受权限控制的
			if(hasSession.contains(path)){
				chain.doFilter(request, response);
				return ;
			}
			
			String urls=(String) request.getSession().getAttribute("urls");
			//访问主界面
			if(urls.contains(path)){
				//放行
				chain.doFilter(request, response);
				return;
			}*/
			chain.doFilter(request, response);
			return;
			
		}
		response.sendRedirect(request.getContextPath()+"/system/login_loginUI.action");
	}
	
	@Override
	public void destroy() {
		
	}

}
