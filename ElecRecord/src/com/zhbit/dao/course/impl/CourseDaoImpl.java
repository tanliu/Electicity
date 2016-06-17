/**
 * 
 */
package com.zhbit.dao.course.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.course.CourseDao;
import com.zhbit.entity.Course;

/** 
 * 项目名称：ElecRecord
 * 类名称：CourseDaoImpl 
 * 类描述： 开课信息模块的DAO层接口实现
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:48:58
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:48:58
 * 修改备注： 
 * @version 
 */
@Repository(value=CourseDao.DAO_NAME)
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {

}
