package com.zhbit.dao.course.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.course.CourseGradeDao;
import com.zhbit.entity.CourseGrade;

@Repository(value=CourseGradeDao.DAO_NAME)
public class CourseGradeDaoImpl extends BaseDaoImpl<CourseGrade> implements CourseGradeDao {

}
