/**
 * 
 */
package com.zhbit.action.system;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zhbit.action.BaseAction;
import com.zhbit.entity.Organization;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.User;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.QueryUtils;
/** 
 * 项目名称：ElecRecord
 * 类名称：UserAction 
 * 类描述： 用户管理Action层
 * 创建人：谭柳
 * 创建时间：2016年5月24日 上午10:49:05
 * 修改人：TanLiu 
 * 修改时间：2016年5月24日 上午10:49:05
 * 修改备注： 
 * @version 
 */
@Controller("userAction")
@Scope(value="prototype")
public class UserAction extends BaseAction {
	
	User user;
	private String queryWay; //查询的方式
	
	@Resource(name=UserServices.SERVER_NAME)
	UserServices userServices;
	@Resource(name=OrganizeServices.SERVICE_NAME)
	OrganizeServices organizeServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;

	@Override
	public String listUI(){		
		pageUtils=userServices.queryList(user, getPageNO(), getPageSize());		
		return "listUI";
	}

	@Override
	public String addUI() {
		//查找所有的部门
		List<Organization> organizations=organizeServices.findAllObject();
		//到数据字典查找用户类型
		String[] fields={"keyword=?"};
		String[] params={"用户类型"};
		List<SystemDll> systemDlls=systeDllServices.findObjectByFields(fields, params);
		request.setAttribute("organizations", organizations);
		request.setAttribute("systemDlls", systemDlls);		
		return "addUI";
	}

	@Override
	public String add() {
		//设置用户创建时间
		user.setCreateTime(new Timestamp(new Date().getTime()));
		//对用户数据进行加密处理
		user.setPassword(EncryptUtils.MD5Encrypt(user.getPassword()));
		userServices.save(user);		
		return null;
	}

	@Override
	public String delete() {		
		userServices.deleteObjectByIds(selectedRow);
		return "delete";
	}

	@Override
	public String editorUI() {
		user=userServices.findObjectById(user.getUserId());
		//查找所有的部门
		List<Organization> organizations=organizeServices.findAllObject();
		//到数据字典查找用户类型
		String[] fields={"keyword=?"};
		String[] params={"用户类型"};
		List<SystemDll> systemDlls=systeDllServices.findObjectByFields(fields, params);
		request.setAttribute("organizations", organizations);
		request.setAttribute("systemDlls", systemDlls);
		user=userServices.findObjectById(user.getUserId());
		return "editorUI";
	}

	@Override
	public String editor() {
		//通过ID查找到对应
		User tempUser=userServices.findObjectById(user.getUserId());
		//设置更改后的信息
		user.setEmployNo(tempUser.getEmployNo());//防止用户恶意更改用户编号
		user.setCreateTime(tempUser.getCreateTime());
		user.setPassword(tempUser.getPassword());		
		userServices.update(user);		
		return "editor";
	}

	@Override
	public String deleteAll() {
		return "deleteAll";
	}
	public String detailUI() {
		user=userServices.findObjectById(user.getUserId());
		return "detailUI";
	}
	//-------------------------getter&&setter-----------------------

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQueryWay() {
		return queryWay;
	}

	public void setQueryWay(String queryWay) {
		this.queryWay = queryWay;
	}


	
	

}
