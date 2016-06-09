package com.zhbit.action.guicontent;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.GuiContent;
import com.zhbit.services.guicontent.GuiContentServices;

/** 
 * 项目名称：ElecRecord
 * 类名称： GuiContentAction
 * 类描述：用于导学信息处理的action类
 * 创建人：罗建鑫
 * 创建时间：2016年6月10日 上午12:01:43
 * 修改人：罗建鑫
 * 修改时间：2016年6月10日 上午12:01:43
 * 修改备注： 
 * @version 
 */ 
@Controller("guiContentAction")
@Scope(value="prototype")
public class GuiContentAction extends BaseAndExcelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GuiContent guiContent;
	@Resource(name=GuiContentServices.SERVICES_NAME)
	GuiContentServices guiContentServices;
	
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

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		
		guiContentServices.save(guiContent);
		
		request.setAttribute("guiContent",guiContent );
		
		return "add";
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

	

	
	
//-------------------getter&setter--------------------------------------------
	

	public GuiContent getGuiContent() {
		return guiContent;
	}

	public void setGuiContent(GuiContent guiContent) {
		this.guiContent = guiContent;
	}
}
