/**
 * 
 */
package com.zhbit.action.teacher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.Teacher;
import com.zhbit.entity.excel.TeachExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.services.teacher.TeacherServices;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TeacherAction 
 * 类描述：  教师基本信息Action层
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:48:25
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:48:25
 * 修改备注： 
 * @version 
 */
@Controller("teacherAction")
@Scope(value="prototype")
public class TeacherAction extends BaseAndExcelAction{
	
	Teacher teacher;

	String queryNO;//学号
	String qeuryName;//姓名
	
	@Resource(name=TeacherServices.SERVICES_NAME)
	TeacherServices teacherServies;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systemDllServices;
	
	@Override
	public String importExcel() {
		try {
			ExcelConfig excelConfig=new ExcelConfig(TeachExcel.class, "教师信息维护",2, new FileInputStream(excel),excelFileName);
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
			List<Object> teachers = excelServicesMake.toDBEnity(objects,Teacher.class);
			
			String creator=RequestUtils.getUserName(request);
			teacherServies.saveFromExcel(teachers,creator);

		} catch (FileNotFoundException e) {
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
		setPageSize(10);
		if(queryNO!=null&&qeuryName!=null){
			try {
				qeuryName=DecodeUtils.decodeUTF(qeuryName);
				queryNO=DecodeUtils.decodeUTF(queryNO);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String[] fields={"employNo=?","employName like ?"};
		String[] params={queryNO,"%"+(qeuryName==null?"":qeuryName)+"%"};
		String proterty="employName";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=teacherServies.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		if(pageUtils.getItems()==null){
			System.out.println("-----------------------");
		}
		return "listUI";
	}

	@Override
	public String addUI() {
		//给数据字典加数据
		List<SystemDll> majors=systemDllServices.findSystemDllByKeyword("专业");
		List<SystemDll> teacherTypes=systemDllServices.findSystemDllByKeyword("教职工类别");
		List<SystemDll> position=systemDllServices.findSystemDllByKeyword("职称");
		List<SystemDll> academys=systemDllServices.findSystemDllByKeyword("学院");
		request.setAttribute("majors", majors);
		request.setAttribute("teacherTypes", teacherTypes);
		request.setAttribute("position", position);
		request.setAttribute("academys", academys);
		return "addUI";
	}

	@Override
	public String add() {
		if(teacher!=null){
			String creator=RequestUtils.getUserName(request);
			teacher.setCreateTime(new Timestamp(new Date().getTime()));
			teacher.setCreator(creator);
			teacherServies.save(teacher);
		}
		return "list";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "list";
	}

	@Override
	public String editorUI() {
		if(teacher==null||StringUtils.isBlank(teacher.getId())){
			return "addUI";
		}
		teacher=teacherServies.findObjectById(teacher.getId());
		
		//给数据字典加数据
		List<SystemDll> majors=systemDllServices.findSystemDllByKeyword("专业");
		List<SystemDll> teacherTypes=systemDllServices.findSystemDllByKeyword("教职工类别");
		List<SystemDll> position=systemDllServices.findSystemDllByKeyword("职称");
		List<SystemDll> academys=systemDllServices.findSystemDllByKeyword("学院");
		request.setAttribute("majors", majors);
		request.setAttribute("teacherTypes", teacherTypes);
		request.setAttribute("position", position);
		request.setAttribute("academys", academys);
		return "editorUI";
	}

	
	/**
	 * 方法描述:数据唯一性校验
	 * @return
	 */
	public String hasTeacher(){
		//1表示存在、0表示不存在
		String result="0";
		if(teacher!=null&&!StringUtils.isBlank(teacher.getEmployNo())){
			if(teacherServies.hasTeacher(teacher.getEmployNo())){
				result="1";
			}
		}
		AjaxReturnUtils.returnResult(response, result);
		return null;
	}
	
	@Override
	public String editor() {
		if(teacher!=null){
			teacherServies.update(teacher);
		}
		return "list";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	//-----------------------gette&&setter----------------------

	public String getQueryNO() {
		return queryNO;
	}

	public void setQueryNO(String queryNO) {
		this.queryNO = queryNO;
	}

	public String getQeuryName() {
		return qeuryName;
	}

	public void setQeuryName(String qeuryName) {
		this.qeuryName = qeuryName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	

}
