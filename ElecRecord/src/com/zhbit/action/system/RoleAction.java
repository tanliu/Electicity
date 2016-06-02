/**
 * 
 */
package com.zhbit.action.system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

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
public class RoleAction extends ActionSupport {
	
	public String listUI(){
		return "listUI";
	}

}
