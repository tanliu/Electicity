/**
 * 
 */
package com.zhbit.dao.teacher;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Teacher;

/** 
 * 项目名称：ElecRecord
 * 类名称：TeacherDao 
 * 类描述： 教师信息的Dao层接口
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:40:13
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:40:13
 * 修改备注： 
 * @version 
 */
public interface TeacherDao extends BaseDao<Teacher> {
	
	public final static String DAO_NAME="com.zhbit.dao.teacher.TeacherDaoImpl";

}
