/**
 * 
 */
package com.zhbit.action.system;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.Organization;
import com.zhbit.services.system.OrganizeServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：OrganizeAction 
 * 类描述： 部门模块的Action层
 * 创建人：谭柳
 * 创建时间：2016年5月6日 下午1:05:44
 * 修改人：谭柳
 * 修改时间：2016年5月6日 下午1:05:44
 * 修改备注： 
 * @version 
 */
@Controller("organizeAction")
@Scope(value="prototype")
public class OrganizeAction extends BaseAction {
	
	Organization organize;
	@Resource(name=OrganizeServices.SERVICE_NAME)
	OrganizeServices organizeServices;

	@Override
	public String listUI() {
		return null;
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String add() {
		return null;
	}

	@Override
	public String delete() {
		return null;
	}

	@Override
	public String editorUI() {
		return null;
	}

	@Override
	public String editor() {
		return null;
	}

	@Override
	public String deleteAll() {
		return null;
	}


	//-------------------------------getter&&setter-------------------------
	public Organization getOrganize() {
		return organize;
	}

	public void setOrganize(Organization organize) {
		this.organize = organize;
	}
	

}
