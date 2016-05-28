/**
 * 
 */
package com.zhbit.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：BaseAciton 
 * 类描述： Action层的基类
 * 创建人：谭柳
 * 创建时间：2016年4月26日 上午11:16:58
 * 修改人：谭柳
 * 修改时间：2016年4月26日 上午11:16:58
 * 修改备注： 
 * @version 
 */
public abstract class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware  {


	private static final long serialVersionUID = 1L;
	protected String[] selectedRow;  //选择的行
	protected PageUtils pageUtils;   //查询工具
	protected int pageNO;              //当前页
	protected int pageSize;            //页的大小
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	
	public abstract String listUI();
	public abstract String addUI();
	public abstract String add();
	public abstract String delete();
	public abstract String editorUI();
	public abstract String editor();
    public abstract String deleteAll();
    //public abstract String detailUI();
	
	//--------------------------------getter&setter---------------------------
	
	//默认页的大小
	public static int DEFAULT_PAGE_SIZE=2;
	
	public PageUtils getPageUtils() {
		return pageUtils;
	}
	public void setPageUtils(PageUtils pageUtils) {
		this.pageUtils = pageUtils;
	}
	public String[] getSelectedRow() {
		return selectedRow;
	}
	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}


	public int getPageNO() {
		if(pageNO<1){
			pageNO=1;
		}
		return pageNO;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	public int getPageSize() {
		if(pageSize==0)pageSize=DEFAULT_PAGE_SIZE;
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request=request;
	}
	

	
}
