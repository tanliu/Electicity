package com.zhbit.services.course;

import java.util.List;

import com.zhbit.entity.CourseGrade;
import com.zhbit.services.BaseServices;

public interface CourseGradeServices extends BaseServices<CourseGrade> {

	public static final String SERVICE_NAME="com.zhbit.services.course.impl.CourseGradeServicesImpl";

	/**
	 * 方法描述:save SelectcourseInfo
	 * @param courses
	 * @param creator
	 */
	void saveFromExcel(List<Object> courses, String creator);

	/**
	 * 方法描述:通过选课Id找选课和学生
	 * @param selectedCourseNo
	 * @return
	 */
	List<CourseGrade> getSelectCourseBySelectNO(String selectedId);

	/**
	 * 方法描述:保存所有方法
	 * @param grades
	 */
	void saveAll(List<CourseGrade> grades);

	/**
	 * 方法描述:导入分数信息
	 * @param grades
	 * @param creator
	 */
	void saveGradeFromExcel(List<Object> grades, String creator);

	/**
	 * 方法描述:保存选课信息
	 * @param courseGrade
	 * @param creator 
	 */
	void saveSelectCourse(CourseGrade courseGrade, String creator);
}
