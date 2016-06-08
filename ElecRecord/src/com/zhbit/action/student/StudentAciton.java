/**
 * 
 */
package com.zhbit.action.student;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.Student;
import com.zhbit.entity.User;
import com.zhbit.services.student.StudentServices;

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
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;

	/* 方法描述:
	 * @see com.zhbit.action.BaseAndExcelAction#importExcel()
	 */
	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAndExcelAction#exportExcel()
	 */
	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#listUI()
	 */
	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#addUI()
	 */
	@Override
	public String addUI() {
		return "addUI";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#add()
	 */
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
		// TODO Auto-generated method stub
		return null;
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#editorUI()
	 */
	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#editor()
	 */
	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return null;
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
	
}
