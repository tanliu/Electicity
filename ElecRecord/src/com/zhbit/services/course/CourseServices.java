/**
 * 
 */
package com.zhbit.services.course;

import java.util.List;

import com.zhbit.entity.Course;
import com.zhbit.entity.CourseGrade;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：CourseServices 
 * 类描述： 开课信息的Services层接口
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:51:13
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:51:13
 * 修改备注： 
 * @version 
 */
public interface CourseServices extends BaseServices<Course> {
   public static final String SERVICES_NAME="com.zhbit.services.course.impl.CourseServicesImpl";

/**
 * 方法描述:保存开课课程信息
 * @param creator
 * @param course
 */
void saveCourse(String creator, Course course);

/**
 * 方法描述: 更新
 * @param course
 */
void updateCourse(Course course);

/**
 * 方法描述:保存excel中的信息
 * @param courses
 * @param creator
 */
void saveFromExcel(List<Object> courses, String creator);

/**
 * 方法描述:
 */
Course getCourseBySelectId(String selectId);

/**
 * 方法描述:保存选课学生的信息
 * @param course
 * @param grades
 * @param gradesIds
 * @param creator
 */
void saveSelectInfo(Course course, List<CourseGrade> grades, String[] gradesIds, String creator);

}

