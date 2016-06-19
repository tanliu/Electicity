package com.zhbit.action.course;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.CourseGrade;
import com.zhbit.services.course.CourseGradeServices;

@Controller("courseGradeAction")
@Scope(value="prototype")
public class CourseGradeAction extends BaseAndExcelAction {
	
	CourseGrade courseGrade;
	@Resource(name=CourseGradeServices.SERVICE_NAME)
	CourseGradeServices courseGradeServices;

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
		return "list";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
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
	//--------------------------getter&&setter----------------------

	public CourseGrade getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(CourseGrade courseGrade) {
		this.courseGrade = courseGrade;
	}
	

}
