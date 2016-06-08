/**
 * 
 */
package com.zhbit.dao.student;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Student;

/** 
 * 项目名称：ElecRecord
 * 类名称：StudentDao 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午5:41:48
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午5:41:48
 * 修改备注： 
 * @version 
 */

public interface StudentDao extends BaseDao<Student> {

	public static final String DAO_NAME="com.zhbit.dao.student.StudentDaoImpl";
}
