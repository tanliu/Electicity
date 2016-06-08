/**
 * 
 */
package com.zhbit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 项目名称：ElecRecord
 * 类名称：CookieFilter 
 * 类描述： 对cookice处理的过滤器
 * 创建人：谭柳
 * 创建时间：2016年6月5日 上午10:00:53
 * 修改人：TanLiu 
 * 修改时间：2016年6月5日 上午10:00:53
 * 修改备注： 
 * @version 
 */
public class CookieFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		
		String path=request.getServletPath();
		
		//用户名
		String name = "";
		//密码
		String password = "";
		//复选框
		String checked = "";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for (Cookie cookie : cookies) {
				if("name".equals(cookie.getName())){
					name=cookie.getValue();
					checked = "checked";
				}
				if("password".equals(cookie.getName())){
					password=cookie.getValue();					
				}
			}
		}
		request.setAttribute("username", name);
		request.setAttribute("password", password);
		request.setAttribute("checked", checked);
		
		
		//放行
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
