/**
 * 
 */
package com.zhbit.action.course;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.Course;
import com.zhbit.entity.CourseGrade;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.Teacher;
import com.zhbit.entity.excel.CourseExcel;
import com.zhbit.entity.excel.TeachExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.course.CourseServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.services.teacher.TeacherServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：CourseAction 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:56:07
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:56:07
 * 修改备注： 
 * @version 
 */
@Controller(value="courseAction")
@Scope(value="prototype")
public class CourseAction extends BaseAndExcelAction {

	Course course;
	List<CourseGrade> grades;
	private String queryNO;
	private String qeuryName;
	private String courseNO;
	private String studyYear;
	private String courseName;
	
	
	@Resource(name=CourseServices.SERVICES_NAME)
	CourseServices courseServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systemDllServices;
	@Resource(name=TeacherServices.SERVICES_NAME)
	TeacherServices teacherServices;
	
	
	@Override
	public String importExcel() {
		try {
			ExcelConfig excelConfig=new ExcelConfig(CourseExcel.class, "Sheet1",1, new FileInputStream(excel),excelFileName);
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
			List<Object> courses = excelServicesMake.toDBEnity(objects,Course.class);
			
			String creator=RequestUtils.getUserName(request);
			courseServices.saveFromExcel(courses,creator);

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
		
	}

	@Override
	public String listUI() {
		setPageSize(10);
		if(queryNO!=null&&qeuryName!=null&&courseName!=null&&courseNO!=null&&studyYear!=null){
			try {
				qeuryName=DecodeUtils.decodeUTF(qeuryName);
				queryNO=DecodeUtils.decodeUTF(queryNO);
				courseNO=DecodeUtils.decodeUTF(courseNO);
				courseName=DecodeUtils.decodeUTF(courseName);
				studyYear=DecodeUtils.decodeUTF(studyYear);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] fields={"employNo=?","employName like ?","courseCode=?","courseName like ?","academicYear=?"};
		String[] params={queryNO,"%"+(qeuryName==null?"":qeuryName)+"%",courseNO,"%"+(courseName==null?"":courseName)+"%",studyYear};
		String proterty="createTime";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=courseServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		if(pageUtils.getItems()==null){
			System.out.println("-----------------------");
		}
		return "listUI";

	}

	@Override
	public String addUI() {

		//生成学年
		List<String> terms=DecodeUtils.getTerm(3,3);
		//取课程性质
		List<SystemDll> systemDlls=systemDllServices.findSystemDllByKeyword("课程性质");
		//把数据放入栈顶
		request.setAttribute("terms", terms);
		request.setAttribute("systemDlls", systemDlls);

		return "addUI";
	}

	public String hasTeacher(){
		Teacher teacher=null;
		if(course!=null&&!StringUtils.isBlank(course.getEmployNo())){
			teacher=teacherServices.getTeacherByNo(course.getEmployNo());
		}
		ActionContext.getContext().getValueStack().push(teacher);
		return "teacherjson";
	}
	
	@Override
	public String add() {
		if(course!=null){
			String creator=RequestUtils.getUserName(request);
			courseServices.saveCourse(creator,course);			
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
		if(course!=null&&!StringUtils.isBlank(course.getId())){
			course=courseServices.findObjectById(course.getId());
			//生成学年
			List<String> terms=DecodeUtils.getTerm(3,3);
			//取课程性质
			List<SystemDll> systemDlls=systemDllServices.findSystemDllByKeyword("课程性质");
			//把数据放入栈顶
			request.setAttribute("terms", terms);
			request.setAttribute("systemDlls", systemDlls);
			
		}
		return "editorUI";
	}
	
	public String selectUI(){
		return "selectUI";
	}

	@Override
	public String editor() {
		if(course!=null){
			courseServices.updateCourse(course);			
		}
		return "list";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	//----------------------getter&&setter-----------------------------

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getCourseNO() {
		return courseNO;
	}

	public void setCourseNO(String courseNO) {
		this.courseNO = courseNO;
	}

	public String getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(String studyYear) {
		this.studyYear = studyYear;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<CourseGrade> getGrades() {
		return grades;
	}

	public void setGrades(List<CourseGrade> grades) {
		this.grades = grades;
	}
	
	
	

}
