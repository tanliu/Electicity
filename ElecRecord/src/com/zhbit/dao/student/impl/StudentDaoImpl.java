/**
 * 
 */
package com.zhbit.dao.student.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.student.StudentDao;
import com.zhbit.entity.Student;

/** 
 * 项目名称：ElecRecord
 * 类名称：StudentDaoImpl 
 * 类描述： 学生基本信息的Dao层实现类
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午11:11:07
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午11:11:07
 * 修改备注： 
 * @version 
 */
@Repository(value=StudentDao.DAO_NAME)
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

}
