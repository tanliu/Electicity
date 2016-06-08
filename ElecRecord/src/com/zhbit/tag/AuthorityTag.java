/**
 * 
 */
package com.zhbit.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.ServletActionContext;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityTag 
 * 类描述： 权限的自定义标签
 * 创建人：谭柳
 * 创建时间：2016年6月6日 上午7:38:30
 * 修改人：TanLiu 
 * 修改时间：2016年6月6日 上午7:38:30
 * 修改备注： 
 * @version 
 */
public class AuthorityTag extends SimpleTagSupport{
	
	private String url;
	

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public void doTag() throws JspException, IOException {
		String urls=(String) ServletActionContext.getRequest().getSession().getAttribute("urls");
		if(urls.contains(url)){
			this.getJspBody().invoke(null);
		}
	}
}
