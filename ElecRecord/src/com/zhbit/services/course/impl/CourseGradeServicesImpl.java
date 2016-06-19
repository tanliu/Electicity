package com.zhbit.services.course.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.course.CourseGradeDao;
import com.zhbit.entity.CourseGrade;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.course.CourseGradeServices;

@Service(value=CourseGradeServices.SERVICE_NAME)
public class CourseGradeServicesImpl extends BaseServicesImpl<CourseGrade> implements CourseGradeServices {

	CourseGradeDao courseGradeDao;
	@Resource(name=CourseGradeDao.DAO_NAME)
	public void setCourseGradeDao(CourseGradeDao courseGradeDao) {
		super.setBaseDao(courseGradeDao);
		this.courseGradeDao = courseGradeDao;
	}
}
