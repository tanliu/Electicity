/**
 * 
 */
package com.zhbit.services.student;

import com.zhbit.entity.Student;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：StudentServices 
 * 类描述： 学生模块Services层接口
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午11:15:34
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午11:15:34
 * 修改备注： 
 * @version 
 */
public interface StudentServices extends BaseServices<Student> {
   public static final String SERVICES_NAME="com.zhbit.services.student.StudentServicesImpl";

    void saveStudent(String createor,Student student);
}
