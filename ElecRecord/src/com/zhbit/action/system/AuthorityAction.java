/**
 * 
 */
package com.zhbit.action.system;

import java.util.List;

import javax.annotation.Resource;
import javax.swing.plaf.TreeUI;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.action.BaseAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Authority;
import com.zhbit.services.system.AuthorityServices;
import com.zhbit.util.AjaxReturnUtils;

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
	@Limit(url="/system/authority_listUI.action")
	public String listUI() {
		return "listUI";
	}

	public String tree(){
		return "tree";
	}
	
	public String treeData(){
		
		//查找数据
		
		List<Authority> authorities=authorityServices.getTreeData();
		//推到栈顶
		ActionContext.getContext().getValueStack().push(authorities);
		return "treeData";
	}
	
	@Override
	@Limit(url="/system/authority_listUI.action")
	public String addUI() {
		if(authority==null||StringUtils.isEmpty(authority.getParentId())||authority.getParentId().equals("0")){
			authority=new Authority();
			authority.setParentId("0");
			authority.setAuthorityName("学生电子档案管理系统");
			authority.setAuthorityId("0");
		}else{
			Authority temp=authorityServices.findObjectById(authority.getParentId());
			authority.setAuthorityName(temp.getAuthorityName());
			authority.setAuthorityId(temp.getAuthorityId());
		}
		return "addUI";
	}

	@Override
	@Limit(url="/system/authority_listUI.action")
	public String add() {
		authorityServices.saveAuthoity(authority);
		
		ActionContext.getContext().getValueStack().push(authority);
		return "add";
	}

	@Override
	@Limit(url="/system/authority_listUI.action")
	public String delete() {
		//删除选择
		if(authority!=null&&!StringUtils.isEmpty(authority.getAuthorityId())){
			authorityServices.deleteNode(authority.getAuthorityId());
			
		}
		return "delete";
	}

	@Override
	@Limit(url="/system/authority_listUI.action")
	public String editorUI() {
		if(authority!=null&&!StringUtils.isEmpty(authority.getAuthorityId())){
			authority=authorityServices.findObjectById(authority.getAuthorityId());
		}
		if(authority==null){
			authority=new Authority();
			authority.setAuthorityId("0");
		}
		return "editorUI";
	}

	@Override
	@Limit(url="/system/authority_listUI.action")
	public String editor() {
		authorityServices.update(authority);
		ActionContext.getContext().getValueStack().push(authority);
		return "add";
	}

	@Override
	@Limit(url="/system/authority_listUI.action")
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
