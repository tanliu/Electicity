/**
 * 
 */
package com.zhbit.action.system;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.LoginLog;
import com.zhbit.services.system.LoginLogService;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogAction 
 * 类描述： 登录日志信息管理
 * 创建人：谭柳
 * 创建时间：2016年6月20日 下午10:52:38
 * 修改人：TanLiu 
 * 修改时间：2016年6月20日 下午10:52:38
 * 修改备注： 
 * @version 
 */
@Controller("loginLogAction")
@Scope(value="prototype")
public class LoginLogAction extends BaseAction {
	
	LoginLog log;
	String querycon;
	@Resource(name=LoginLogService.SERVICES_NAME)
	LoginLogService loginLogServices;

	@Override
	public String listUI() {
        setPageSize(10);
		String[] fields={"employNo=?"};
		String[] params={querycon==null?"":querycon};
		String proterty="loginTime";
		String order=QueryUtils.ORDER_BY_DESC;
		
		pageUtils=loginLogServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginLog getLog() {
		return log;
	}

	public void setLog(LoginLog log) {
		this.log = log;
	}

	public String getQuerycon() {
		return querycon;
	}

	public void setQuerycon(String querycon) {
		this.querycon = querycon;
	}
	
	
	

}
