/**
 * 
 */
package com.zhbit.action.system;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Check;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.action.BaseAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Authority;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.services.system.AuthorityServices;
import com.zhbit.services.system.RoleServices;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleAction 
 * 类描述： 角色模块的action
 * 创建人：谭柳
 * 创建时间：2016年6月2日 上午12:29:50
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 上午12:29:50
 * 修改备注： 
 * @version 
 */
@Controller(value="roleAction")
@Scope(value="prototype")
public class RoleAction extends BaseAction {
	
	private String querycon;//查询的条件	
	String[] authoritys;
	
	Role role;
	@Resource(name=AuthorityServices.SERVICE_NAME)
	AuthorityServices authorityServices;
	@Resource(name=RoleServices.SEVICES_NAME)
	RoleServices roleServices;
	@Limit(url="/system/role_listUI.action")
	public String listUI(){
	
		pageUtils=roleServices.getPageUtils(querycon,getPageNO(),getPageSize());
		return "listUI";
	}
	
	public String treeData(){		
		//查找数据		
		List<Authority> authorities=authorityServices.getTreeData();
		//推到栈顶
		ActionContext.getContext().getValueStack().push(authorities);
		return "jsontree";
	}
	
	@Override
	public String addUI() {
		return "addUI";
	}
	@Limit(url="/system/role_listUI.action")
	public String add(){
		if(role!=null){
			role.setCreateTime(new Timestamp(new Date().getTime()));
			roleServices.saveRole(role,authoritys);			
		}
		AjaxReturnUtils.returnResult(response, "1");
		return null;
	}
	@Override
	@Limit(url="/system/role_listUI.action")
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			roleServices.deleteRole(selectedRow);
		}
		return "list";
	}

	@Override
	public String editorUI() {
		//查找到角色信息
		role=roleServices.findObjectById(role.getRoleId());
		return "editorUI";
	}
	public String check(){
		List<RoleAuthority> roleAuthoritis=roleServices.getRoleAuthority(role.getRoleId());
		ActionContext.getContext().getValueStack().push(roleAuthoritis);
		return "checkjson";
		
	}

	@Override
	@Limit(url="/system/role_listUI.action")
	public String editor() {
	  roleServices.editorRole(role,authoritys);
      //修改结束后
      Map<String, String> info = new HashMap<String, String>();  
      info.put("querycon", querycon==null? "":querycon);
      info.put("pageNo", getPageNO()+"");		
	  ActionContext.getContext().getValueStack().push(info);
	  return "listjson";
	}

	@Override
	public String deleteAll() {
		return null;
	}
	//------------------------------------getter&&setter--------------------------
	


	public String[] getAuthoritys() {
		return authoritys;
	}

	public String getQuerycon() {
		return querycon;
	}

	public void setQuerycon(String querycon) {
		this.querycon = querycon;
	}

	public void setAuthoritys(String[] authoritys) {
		this.authoritys = authoritys;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
