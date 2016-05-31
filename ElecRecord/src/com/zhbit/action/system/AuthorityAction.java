/**
 * 
 */
package com.zhbit.action.system;

import java.util.List;

import javax.annotation.Resource;
import javax.swing.plaf.TreeUI;

import org.apache.tomcat.jni.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.action.BaseAction;
import com.zhbit.entity.Authority;
import com.zhbit.services.system.AuthorityServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityAction 
 * 类描述： 权限管理Action层
 * 创建人：谭柳
 * 创建时间：2016年5月29日 下午10:56:44
 * 修改人：TanLiu 
 * 修改时间：2016年5月29日 下午10:56:44
 * 修改备注： 
 * @version 
 */
@Controller(value="authorityAction")
@Scope(value="prototype")
public class AuthorityAction extends BaseAction {

	Authority authority;
	@Resource(name=AuthorityServices.SERVICE_NAME)
	AuthorityServices authorityServices;
	
	@Override
	public String listUI() {
		return "listUI";
	}

	public String tree(){
		return "tree";
	}
	
	public String treeData(){
		//查找数据
		List<Authority> authorities=authorityServices.findAllObject();
		//推到栈顶
		ActionContext.getContext().getValueStack().push(authorities);
		return "treeData";
	}
	
	@Override
	public String addUI() {
		if(authority==null){
			authority=new Authority();
			authority.setParentId("0");
		}
		authority.setMenuNo("kdjflajfaj");
		return "addUI";
	}

	@Override
	public String add() {
		authorityServices.saveAuthoity(authority);
		return "addUI";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return "editorUI";
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
//---------------------------------getter&&setter---------------------

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	
}
