/**
 * 
 */
package com.zhbit.dao.course;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Course;

/** 
 * 项目名称：ElecRecord
 * 类名称：CourseDao 
 * 类描述： 开课模块DAO层
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:46:40
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:46:40
 * 修改备注： 
 * @version 
 */
public interface CourseDao extends BaseDao<Course> {
	public final static String DAO_NAME="com.zhbit.dao.course.CourseDaoImpl";

}
