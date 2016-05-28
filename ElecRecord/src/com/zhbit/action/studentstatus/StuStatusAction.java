package com.zhbit.action.studentstatus;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.StuStatus;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.studentstatus.StuStatusServices;
import com.zhbit.services.system.SystemDllServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：StuStatusAction
 * 类描述： 用于学籍异动信息处理的Action类
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
@Controller("stuStatusAction")
@Scope(value="prototype")
public class StuStatusAction extends BaseAndExcelAction {

	StuStatus stuStatus;
	@Resource(name=StuStatusServices.SERVICE_NAME)
	StuStatusServices stuStatusServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		return "listUI";
	}

	/**
		 * 方法描述:此方法用于跳转到添加学籍异动信息界面
		 * @param
		 * @param 
		 */
	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		//到数据字典查找类别
			String[] fields={"keyword"};
			String[] params1={"学院名称"};
			String[] params2={"学年"};
			String[] params3={"专业"};
		//查找学院类别	
			List<SystemDll> colleges=systeDllServices.findObjectByFields(fields, params1);
		//查找学年
			List<SystemDll> years=systeDllServices.findObjectByFields(fields, params2);
		//查找专业
			List<SystemDll> majors=systeDllServices.findObjectByFields(fields, params3);
			
		//将查询到的信息推送到前台显示
			request.setAttribute("colleges", colleges);	
			request.setAttribute("years", years);
			request.setAttribute("majors", majors);
				
		return "addUI";
	}

	@Override
	public String add() {
		//利用save方法将新添加的学籍异动信息添加到数据库中
		
		stuStatusServices.save(stuStatus);
		
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
		 * 方法描述:此方法用于跳转到学籍异动信息修改界面
		 * @param
		 * @param 
		 */
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

	//------------------------------------getter&setter-----------------------------------
	public StuStatus getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(StuStatus stuStatus) {
		this.stuStatus = stuStatus;
	}
	

	
}
