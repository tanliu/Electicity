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
import org.apache.commons.collections.TransformerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Familyinfo;
import com.zhbit.entity.LearningExperience;
import com.zhbit.entity.Student;
import com.zhbit.entity.User;
import com.zhbit.entity.excel.FamilyExcel;
import com.zhbit.entity.excel.StuExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.student.FamilyServices;
import com.zhbit.services.student.LearnExperienceServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.transform.CommonTransform;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.EntityUtils;
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
	List<Familyinfo> family;
	List<LearningExperience> experiences;
	String[] familyIds;
	String[] experiencesIds;
	
	String queryNO;//学号
	String qeuryName;//姓名
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	@Resource(name=FamilyServices.SERVICES_NAME)
	FamilyServices familyServices;
	@Resource(name=LearnExperienceServices.SERVICES_NAME)
	LearnExperienceServices experienceServices;


	@Limit(url="/student/student_importExcel.action")
	public String importFamilyExcel() {
		try {
			ExcelConfig excelConfig=new ExcelConfig(FamilyExcel.class, "学生家庭表",1, new FileInputStream(excel),excelFileName);
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
			List<Object> fatherinfos=excelServicesMake.toDBEnity(objects,Familyinfo.class);
			List<Object> motherinfos=EntityUtils.getMotherInfos(objects);
			String creator=RequestUtils.getUserName(request);
			studentServices.saveFamilyFromExcel(students,creator,fatherinfos,motherinfos);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "excelSuccess";
	}
	@Override
	@Limit(url="/student/student_importExcel.action")
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
			e.printStackTrace();
		}
		return "excelSuccess";
	}


	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}


	@Override
	@Limit(url="/student/student_listUI.action")
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
		
		String[] fields={"studentNo=?","stuName like ?"};
		String[] params={queryNO,(StringUtils.isBlank(qeuryName)?"":"%"+qeuryName+"%")};
		String proterty="studentNo";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=studentServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		return "listUI";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#addUI()
	 */
	@Override
	@Limit(url="/student/student_add.action")
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
	@Limit(url="/student/student_add.action")
	public String add() {
		if(student!=null&&student.getStudentNo()!=null){
			User user=(User) request.getSession().getAttribute(User.SESSION_NAME);
			String creator=user.getEmployName();			
			studentServices.saveStudent(creator,student,family,experiences);	

		}
		return "list";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#delete()
	 */
	@Override
	@Limit(url="/student/student_delete.action")
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
	@Limit(url="/student/student_editor.action")
	public String editorUI() {
		if(student!=null&&!StringUtils.isBlank(student.getStuId())){
			student=studentServices.findObjectById(student.getStuId());	
			if(student!=null){
				//查找到家庭信息
				family=familyServices.findFamilyByStuId(student.getStuId());
				//查找到学习情况
				experiences=experienceServices.findExperiencByStuId(student.getStuId());
				
			}
		}
		return "editorUI";
	}

	/* 方法描述:
	 * @see com.zhbit.action.BaseAction#editor()
	 */
	@Override
	@Limit(url="/student/student_editor.action")
	public String editor() {
		if(student!=null){
			String creator=RequestUtils.getUserName(request);
			studentServices.updateStudent(student,creator,family,experiences,familyIds,experiencesIds);
		}
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
	
	
	public String detailUI(){
		if(student!=null){
			student=studentServices.findObjectById(student.getStuId());
			//查找到家庭信息
			family=familyServices.findFamilyByStuId(student.getStuId());
			//查找到学习情况
			experiences=experienceServices.findExperiencByStuId(student.getStuId());
		}
		return "detailUI";
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


	public List<Familyinfo> getFamily() {
		return family;
	}


	public void setFamily(List<Familyinfo> family) {
		this.family = family;
	}


	public List<LearningExperience> getExperiences() {
		return experiences;
	}


	public void setExperiences(List<LearningExperience> experiences) {
		this.experiences = experiences;
	}


	public String[] getFamilyIds() {
		return familyIds;
	}


	public void setFamilyIds(String[] familyIds) {
		this.familyIds = familyIds;
	}


	public String[] getExperiencesIds() {
		return experiencesIds;
	}


	public void setExperiencesIds(String[] experiencesIds) {
		this.experiencesIds = experiencesIds;
	}

   

	
}
