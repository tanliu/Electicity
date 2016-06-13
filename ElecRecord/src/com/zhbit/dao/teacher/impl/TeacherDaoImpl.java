/**
 * 
 */
package com.zhbit.dao.teacher.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.teacher.TeacherDao;
import com.zhbit.entity.Teacher;

/** 
 * 项目名称：ElecRecord
 * 类名称：TeacherDaoImpl 
 * 类描述： 老师基本信息Daon层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:41:23
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:41:23
 * 修改备注： 
 * @version 
 */
@Repository(TeacherDao.DAO_NAME)
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {

}
