package com.zhbit.action.guicontent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.GuiContent;
import com.zhbit.entity.Student;
import com.zhbit.entity.excel.GuiContentEntity;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.guicontent.GuiContentServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

import freemarker.template.utility.StringUtil;

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
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	
	@Override
	@Limit(url="/guicontent/guicontent_importExcel.action")
	public String importExcel() {
		
		try {
			ExcelConfig excelConfig = new ExcelConfig(GuiContentEntity.class, "Sheet1", 1, new FileInputStream(excel),excelFileName);
			
			List<Object> objects=excelServicesMake.parseExcel(excelConfig);
			Map<String, String> viladationExcel = excelServicesMake.viladationExcel(objects);
			
			//对数据的校验
			if(viladationExcel.size()>0){
				for (Iterator<Entry<String, String>> iterator=viladationExcel.entrySet().iterator();iterator.hasNext();) {
					Entry<String, String> entry=iterator.next();
					this.addActionError(entry.getKey()+":"+entry.getValue());
				}
				//出错
				return "excelError";
			}
			//数据的转换
			List<Object> guiContentEntitys = excelServicesMake.toDBEnity(objects,GuiContent.class);
			List<GuiContent> guiContents=new ArrayList<GuiContent>();		
			
		//将集合中的对象保存至数据库
			for(Object object:guiContentEntitys){
				GuiContent guiContent=(GuiContent) object;
				//去除可能存在的空格
				guiContentServices.trimGuiContent(guiContent);
				
				if(!StringUtils.isEmpty(guiContent.getStudentNo())){
					
					String[] fields;
					Object[] params;				
					
					fields=new String[]{"studentNo=?","guidDate=?","guidAddress=?"};
					params=new Object[]{guiContent.getStudentNo(),guiContent.getGuidDate(),guiContent.getGuidAddress()};
					
					if(guiContentServices.findObjectByFields(fields, params)==null){//当学号、时间、地点查询到的对象为空时，才进行保存至数据库的操作
						
					//通过对应的学生学号得到对应的stu_id
					Student student=studentServices.getStudentByNo(guiContent.getStudentNo());
					if(student!=null){
						guiContent.setStuId(student.getStuId());
					}
					
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					guiContent.setCreateTime(createtime);
					
					//将此对象放入guiContents集合中
					guiContents.add(guiContent);
					
				}
					
			}
				
			}
			//}
			
			if(guiContents.size()>=1){
			//批量插入导学内容信息
			guiContentServices.saveGuiContents(guiContents);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "excelSuccess";
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}

	@Override
	@Limit(url="/guicontent/guicontent_listUI.action")
	public String listUI() {
		// TODO Auto-generated method stub
		
		
		//对传来的查询条件进行编码
		if(guiContent!=null){
			//判断是否是学生，如果是，则将其输入的学号强转为他本人的学号
			guiContent.setStudentNo(RequestUtils.checkStudentAuthority(request, guiContent.getStudentNo()));
			try {
				guiContent.setStuName(DecodeUtils.decodeUTF(guiContent.getStuName()));
				guiContent.setStudentNo(DecodeUtils.decodeUTF(guiContent.getStudentNo()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
	
		Student student=(Student) request.getSession().getAttribute("student");
		if(student!=null){
			guiContent=new GuiContent();
			guiContent.setStudentNo(student.getStudentNo());
			guiContent.setStuName(student.getStuName());		
			
		}
		
		//将传过来的参数进行回显
		request.setAttribute("queryCon",guiContent);
	    setPageSize(10);
		
		pageUtils=guiContentServices.queryList(guiContent, getPageNO(), getPageSize());
		
		return "listUI";
	}

	@Override
	@Limit(url="/guicontent/guicontent_add.action")
	public String addUI() {
		
		//保存查询条件
		request.setAttribute("queryCon", guiContent);
		
		return "addUI";
	}

	@Override
	@Limit(url="/guicontent/guicontent_add.action")
	public String add() {
		// TODO Auto-generated method stub
		
		
		
		//去除空格后再进行存储
		guiContent=guiContentServices.trimGuiContent(guiContent);
		
		if(guiContent!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			guiContent.setCreateTime(createtime);
			
			//通过对应的学生学号得到对应的stu_id
			Student student=studentServices.getStudentByNo(guiContent.getStudentNo());
			if(student!=null){
				guiContent.setStuId(student.getStuId());
			}
			
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
	@Limit(url="/guicontent/guicontent_delete.action")
	public String delete() {
		// TODO Auto-generated method stub
		request.setAttribute("guiContent",guiContent);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
			guiContentServices.deleteObjectByIds(getSelectedRow());		
			}
		
		return "delete";
	}

	@Override
	@Limit(url="/guicontent/guicontent_editor.action")
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
	@Limit(url="/guicontent/guicontent_editor.action")
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
