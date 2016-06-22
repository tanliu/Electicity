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
import com.zhbit.entity.Student;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.excel.CourseExcel;
import com.zhbit.entity.excel.CourseGradeExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.course.CourseGradeServices;
import com.zhbit.services.course.CourseServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

@Controller("courseGradeAction")
@Scope(value="prototype")
public class CourseGradeAction extends BaseAndExcelAction {
	
	
	private String queryNO;
	private String qeuryName;
	private String courseNO;
	private String studyYear;
	private String courseName;
	
	CourseGrade courseGrade;
	@Resource(name=CourseGradeServices.SERVICE_NAME)
	CourseGradeServices courseGradeServices;
	@Resource(name=CourseServices.SERVICES_NAME)
	CourseServices courseServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systemDllServices;

	@Override
	public String importExcel() {
		try {
			ExcelConfig excelConfig=new ExcelConfig(CourseGradeExcel.class, "Sheet1",2, new FileInputStream(excel),excelFileName);
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
			List<Object> courses = excelServicesMake.toDBEnity(objects,CourseGrade.class);
			
			String creator=RequestUtils.getUserName(request);
			courseGradeServices.saveFromExcel(courses,creator);

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
		qeuryName=RequestUtils.checkStudentAuthority(request,qeuryName);
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
		//String[] fields={"employNo=?","employName like ?","selectedCourseNo=?","courseName like ?","selectedCourseNo like ?"};
		//String[] params={queryNO,"%"+(qeuryName==null?"":qeuryName)+"%","%"+(courseNO==null?"":"-"+courseNO+"-")+"%","%"+(courseName==null?"":courseName)+"%","%"+(studyYear==null?"":"-"+studyYear+"-")+"%"};
		String[] fields={"employNo=?","studentNo=?","selectedCourseNo like ?","courseName like ?","selectedCourseNo like ?"};
		String[] params={queryNO,qeuryName,"%"+(StringUtils.isBlank(courseNO)?"":"-"+courseNO+"-")+"%","%"+(StringUtils.isBlank(courseName)?"":courseName)+"%","%"+(StringUtils.isBlank(studyYear)?"":studyYear)+"%"};
		String proterty="createTime";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=courseGradeServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		return "listUI";
	}

	/**
	 * 方法描述:校验是否存在教师
	 * @return
	 */
	public String hasCourseNo(){
		Course course=null;
		if(courseGrade!=null&&!StringUtils.isBlank(courseGrade.getSelectedCourseNo())){
			course=courseServices.getCourseBySelectId(courseGrade.getSelectedCourseNo());
		}
		ActionContext.getContext().getValueStack().push(course);			
		return "coursejson";
	}
	
	public String hasStudent(){
		Student student=null;
		if(courseGrade!=null&&!StringUtils.isBlank(courseGrade.getStudentNo())){
			student=studentServices.getStudentByNo(courseGrade.getStudentNo());
		}
		ActionContext.getContext().getValueStack().push(student);			
		
		return "studentjson";
	}
	
	@Override
	public String addUI() {
/*		List<SystemDll> majors=systemDllServices.findSystemDllByKeyword("专业");
		List<SystemDll> academys=systemDllServices.findSystemDllByKeyword("学院");
		request.setAttribute("majors", majors);
		request.setAttribute("academys", academys);*/
		return "addUI";
	}

	
	
	
	@Override
	public String add() {
		if(courseGrade!=null){
			String creator=RequestUtils.getUserName(request);
			courseGradeServices.saveSelectCourse(courseGrade,creator);
		}
		return "list";
	}

	@Override
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			courseGradeServices.deleteObjectByIds(selectedRow);
		}
		return "list";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return "editorUI";
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return "list";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String detailUI(){
		if(courseGrade!=null&&!StringUtils.isBlank(courseGrade.getId())){
			courseGrade=courseGradeServices.findObjectById(courseGrade.getId());			
		}
		return "detailUI";
	}
	
	//--------------------------getter&&setter----------------------

	public CourseGrade getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(CourseGrade courseGrade) {
		this.courseGrade = courseGrade;
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
	
	

}
