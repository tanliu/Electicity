package com.zhbit.action.guicontent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.GuiContent;
import com.zhbit.entity.Tutor;
import com.zhbit.entity.excel.GuiContentEntity;
import com.zhbit.entity.excel.TutorEntity;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.guicontent.GuiContentServices;
import com.zhbit.transform.GuiContentTransform;
import com.zhbit.transform.TutorTransform;
import com.zhbit.util.DecodeUtils;

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
	private Timestamp query_guidDate;
	private String query_studentNo;
	private String query_stuName;
	@Resource(name=GuiContentServices.SERVICES_NAME)
	GuiContentServices guiContentServices;
	
	@Override
	public String importExcel() {
		ExcelConfig config;
		try {
			config = new ExcelConfig(GuiContentEntity.class, "Sheet1", 1, new FileInputStream(excel),excelFileName);
			
			List<Object> lists=excelServices.parseExcel(config);
			
			//将StuStaEntity的集合转换成StuStatus的集合
			List<Object> guiContents=new GuiContentTransform().toDBEntity(lists);
			
			
			for(Object object:guiContents){
				GuiContent guiContent=(GuiContent) object;
				System.out.println("姓名是："+guiContent.getStuName());
			}
		//将集合中的对象保存至数据库
			for(Object object:guiContents){
				GuiContent guiContent=(GuiContent) object;
				guiContentServices.save(guiContent);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "importExcel";
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		//对传来的查询条件进行编码
		if(guiContent!=null){
			try {
				guiContent.setStuName(DecodeUtils.decodeUTF(guiContent.getStuName()));
				guiContent.setStudentNo(DecodeUtils.decodeUTF(guiContent.getStudentNo()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
	
		//将传过来的参数进行回显
		request.setAttribute("queryCon",guiContent);
	    setPageSize(10);
		
		pageUtils=guiContentServices.queryList(guiContent, getPageNO(), getPageSize());
		
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", guiContent);
		
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		
		//去除空格后再进行存储
		guiContent=guiContentServices.trimGuiContent(guiContent);
		
		if(guiContent!=null){
			guiContentServices.save(guiContent);
		}
		
		//保存成功后将guiContent中的属性设定为查询条件
		guiContent.setGuidDate(getQuery_guidDate());
		guiContent.setStudentNo(getQuery_studentNo());
		guiContent.setStuName(getQuery_stuName());
				
		request.setAttribute("guiContent",guiContent );
		
		return "add";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		request.setAttribute("guiContentguiContent",guiContent);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
			guiContentServices.deleteObjectByIds(getSelectedRow());		
			}
		
		return "delete";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", guiContent);
						
		//通过传过来的参数值获取对应的学籍信息
		guiContent=guiContentServices.findObjectById(guiContent.getId());
				
		//将查询得到的学籍信息推送到前台显示
		request.setAttribute("guiContent", guiContent);
		
		return "editorUI";
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		//使用update方法更新辅导信息
		guiContent=guiContentServices.trimGuiContent(guiContent);//去除空格后再进行数据的存储
		guiContentServices.update(guiContent);
		
		//保存成功后将guiContent中的属性设定为查询条件
		guiContent.setGuidDate(getQuery_guidDate());
		guiContent.setStudentNo(getQuery_studentNo());
		guiContent.setStuName(getQuery_stuName());
						
		request.setAttribute("guiContent",guiContent );
				
		return "editor";
	}

	
	public String detailUI(){
		
		guiContent=guiContentServices.findObjectById(guiContent.getId());
		
		request.setAttribute("guiContent", guiContent);
		
		return "detailUI";
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

	public Timestamp getQuery_guidDate() {
		return query_guidDate;
	}

	public void setQuery_guidDate(Timestamp query_guidDate) {
		this.query_guidDate = query_guidDate;
	}

	public String getQuery_studentNo() {
		return query_studentNo;
	}

	public void setQuery_studentNo(String query_studentNo) {
		this.query_studentNo = query_studentNo;
	}

	public String getQuery_stuName() {
		return query_stuName;
	}

	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}
	
	
}
