/**
 * 
 */
package com.zhbit.action.system;

import java.util.List;

import javax.annotation.Resource;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.QueryUtils;

/**
 * 项目名称：ElecRecord 
 * 类名称：SystemDllAction 
 * 类描述： 数据字典的action层
 * 创建人：谭柳 创建时间：2016年4月28日 上午10:48:56
 * 修改人：谭柳 修改时间：
 * 2016年4月28日 上午10:48:56 
 * 修改备注：
 * 
 * @version
 */
public class SystemDllAction extends BaseAction {

	SystemDll systemDll;
	@Resource(name = SystemDllServices.SERVICE_NAME)
	SystemDllServices systemDllServices;
	
	String[] ddlNames;//名称
	

	@Override
	public String listUI() {
		List<SystemDll> systemDlls = systemDllServices.findKeyWordByDistinct();
		request.setAttribute("systemDlls", systemDlls);
		return "listUI";
	}

	@Override
	public String addUI() {
		return null;
	}

	@Override
	public String add() {
		if(systemDll!=null){
		systemDllServices.saveSystemDll(ddlNames,systemDll.getKeyword());//把数据保存到数据库
		}
		return "add";
	}

	@Override
	public String delete() {
		return null;
	}

	@Override
	public String editorUI() {
		List<SystemDll> systemDlls = null;
		//查询所有keyword
		if (systemDll != null&&!"--请选择--".equals(systemDll.getKeyword())) {
			QueryUtils queryUtils = new QueryUtils(SystemDll.class, "s");
			queryUtils.addCondition("s.keyword= ?", systemDll.getKeyword());
			systemDlls = systemDllServices.findObjectByFields(queryUtils);
		}
		request.setAttribute("systemDlls", systemDlls);
		return "editorUI";
	}

	@Override
	public String editor() {
		if(systemDll!=null){
		  systemDllServices.editorSystemDll(ddlNames,systemDll.getKeyword());//把数据保存到数据库
		}
		return "editor";
		
	}

	public String deleteAll() {
		return null;
	}

	// ------------------------------getter&setter--------------------------

	
	public SystemDll getSystemDll() {
		return systemDll;
	}

	public String[] getDdlNames() {
		return ddlNames;
	}

	public void setDdlNames(String[] ddlNames) {
		this.ddlNames = ddlNames;
	}

	public void setSystemDll(SystemDll systemDll) {
		this.systemDll = systemDll;
	}

}
