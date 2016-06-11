/**
 * 
 */
package com.zhbit.action.student;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.catalina.connector.Request;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.Student;
import com.zhbit.entity.User;
import com.zhbit.entity.excel.StuExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.student.StudentServices;
import com.zhbit.transform.CommonTransform;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：StudentAciton 
 * 类描述： 学生模块的Action层方法
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午11:23:43
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午11:23:43
 * 修改备注： 
 * @version 
 */
@Controller("studentAction")
@Scope(value="prototype")
public class StudentAciton extends BaseAndExcelAction {
	
	Student student;
	
	String queryNO;//学号
	String qeuryName;//姓名
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	@Resource(name=CommonTransform.TRANSFORM_NAME)
	CommonTransform commonTransform;


	@Override
	public String importExcel() {
		try {
			ExcelConfig excelConfig=new ExcelConfig(StuExcel.class, "学生基本信息",1, new FileInputStream(excel),excelFileName);
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
			List<Object> students = excelServicesMake.toDBEnity(objects,Student.class);
			
			String creator=RequestUtils.getUserName(request);
			studentServices.saveFromExcel(students,creator);

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
		
		if(queryNO!=null&&qeuryName!=null){
			try {
				qeuryName=DecodeUtils.decodeUTF(qeuryName);
				queryNO=DecodeUtils.decodeUTF(queryNO);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String[] fields={"studentNo=?","stuName=?"};
		String[] params={queryNO,qeuryName};
		String proterty="studentNo";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=studentServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		return "listUI";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#addUI()
	 */
	@Override
	public String addUI() {
		return "addUI";
	}

	/**
	 * 方法描述:数据唯一性校验
	 * @return
	 */
	public String hasStudent(){
		//1表示存在、0表示不存在
		String result="0";
		if(student!=null&&!StringUtils.isBlank(student.getStudentNo())){
			if(studentServices.hasStudent(student.getStudentNo())){
				result="1";
			}
		}
		AjaxReturnUtils.returnResult(response, result);
		return null;
	}
	

	@Override
	public String add() {
		if(student!=null&&student.getStudentNo()!=null){
			User user=(User) request.getSession().getAttribute(User.SESSION_NAME);
			String creator=user.getEmployName();			
			studentServices.saveStudent(creator,student);	

		}
		return "list";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#delete()
	 */
	@Override
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			studentServices.deleteObjectByIds(selectedRow);
		}
		return "list";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#editorUI()
	 */
	@Override
	public String editorUI() {
		if(student!=null&&!StringUtils.isBlank(student.getStuId())){
			student=studentServices.findObjectById(student.getStuId());			
		}
		return "editorUI";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#editor()
	 */
	@Override
	public String editor() {
		if(student!=null){
			studentServices.update(student);
		}
		// TODO Auto-generated method stub
		return "list";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#deleteAll()
	 */
	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
//-----------------------------getter&&setter------------------------------

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


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
	
}
