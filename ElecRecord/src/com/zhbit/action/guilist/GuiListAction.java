package com.zhbit.action.guilist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.GuiList;
import com.zhbit.entity.excel.GuiListEntity;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.guilist.GuiListServices;
import com.zhbit.util.DecodeUtils;



/** 
 * 项目名称：ElecRecord
 * 类名称： GuiListAction
 * 类描述：用于处理导学名单的Action类
 * 创建人：罗建鑫
 * 创建时间：2016年6月11日 下午8:36:55
 * 修改人：罗建鑫
 * 修改时间：2016年6月11日 下午8:36:55
 * 修改备注： 
 * @version 
 */ 
@Controller("guiListAction")
@Scope(value="prototype")
public class GuiListAction extends BaseAndExcelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GuiList guiList;
	private String query_studentNo;
	private String query_stuName;
	private String query_teacherName;
	
	@Resource(name=GuiListServices.SERVICES_NAME)
	GuiListServices guiListServices;
	
	
	
	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		
		try {
			ExcelConfig excelConfig = new ExcelConfig(GuiListEntity.class, "Sheet1", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> guiListEntitys = excelServicesMake.toDBEnity(objects,GuiList.class);
			List<GuiList> guiLists=new ArrayList<GuiList>();
					
			/*for(Object object:guiListEntitys){
				GuiList guiList=(GuiList) object;
				System.out.println("姓名是："+guiList.getStuName());
			}*/
		//将集合中的对象保存至数据库
			for(Object object:guiListEntitys){
				
				GuiList guiList=(GuiList) object;
				if(!StringUtils.isEmpty(guiList.getStudentNo())){	
					//设定创建时间为当前时间
					guiList.setStuId("9528");
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					guiList.setCreateTime(createtime);
					//设定学年为2013-2014学年，学期为第一学期
					guiList.setAcademicYear("2013-2014");
					guiList.setTerm("1");
					
					//将此对象放入guiLists集合中
					guiLists.add(guiList);
				}
				
			}
			
			//批量存储导学名单信息
			guiListServices.saveGuiLists(guiLists);
			
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
	public String listUI() {
		// TODO Auto-generated method stub
		
		//对传来的查询条件进行编码
		if(guiList!=null){
			try {
				guiList.setStuName(DecodeUtils.decodeUTF(guiList.getStuName()));
				guiList.setStudentNo(DecodeUtils.decodeUTF(guiList.getStudentNo()));
				guiList.setTeacherName(DecodeUtils.decodeUTF(guiList.getTeacherName()));
			} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						System.out.println("编码时出错");
			}
			}
		
		//将传过来的参数进行回显
		request.setAttribute("queryCon",guiList);
		setPageSize(10);
				
		pageUtils=guiListServices.queryList(guiList, getPageNO(), getPageSize());
				
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
				
		request.setAttribute("queryCon",guiList );
		
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		//去除空格后再进行存储
		guiList=guiListServices.trimGuiList(guiList);
						
		if(guiList!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			guiList.setCreateTime(createtime);
			//设定学年为2013-2014学年，学期为第一学期
			guiList.setAcademicYear("2013-2014");
			guiList.setTerm("1");
			
			guiListServices.save(guiList);
		}
						
		//保存成功后将guiContent中的属性设定为查询条件
		guiList.setTeacherName(getQuery_teacherName());
		guiList.setStudentNo(getQuery_studentNo());
		guiList.setStuName(getQuery_stuName());
		
		return "add";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		request.setAttribute("guiList",guiList);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
			guiListServices.deleteObjectByIds(getSelectedRow());		
			}
		
		return "delete";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		request.setAttribute("queryCon",guiList );
		
		//通过传过来的参数值获取对应的学籍信息
		guiList=guiListServices.findObjectById(guiList.getId());
		
		//将查询得到的学籍信息推送到前台显示
		request.setAttribute("guiList", guiList);
		
		return "editorUI";
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		//使用update方法更新辅导信息
		guiList=guiListServices.trimGuiList(guiList);//去除空格后再进行数据的存储
		guiListServices.update(guiList);
		
		//保存成功后将guiContent中的属性设定为查询条件
		guiList.setTeacherName(getQuery_teacherName());
		guiList.setStudentNo(getQuery_studentNo());
		guiList.setStuName(getQuery_stuName());
				
		return "editor";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
//------------------getter&setter-----------------------------
	
	public GuiList getGuiList() {
		return guiList;
	}

	public void setGuiList(GuiList guiList) {
		this.guiList = guiList;
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

	public String getQuery_teacherName() {
		return query_teacherName;
	}

	public void setQuery_teacherName(String query_teacherName) {
		this.query_teacherName = query_teacherName;
	}

	
	
}
