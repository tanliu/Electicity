/**
 * 
 */
package com.zhbit.services.teacher;

import java.util.List;

import com.zhbit.entity.Student;
import com.zhbit.entity.Teacher;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：TeacherServices 
 * 类描述： 教师基本信息Service层接口
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:44:21
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:44:21
 * 修改备注： 
 * @version 
 */
public interface TeacherServices extends BaseServices<Teacher> {

	public final static String SERVICES_NAME="com.zhbit.services.teacher.TeacherServicesImpl";

	/**
	 * 方法描述:保存excel导入的教师信息
	 * @param teachers
	 * @param creator
	 */
	void saveFromExcel(List<Object> teachers, String creator);
	
	/**
	 * 方法描述:判断系统是存在学号为这个的学生
	 * @param studentNo
	 * @return
	 */
	Boolean hasTeacher(String employNo);
	
	/**
	 * 方法描述:通过学号获取学生信息
	 * @return
	 */
	public Teacher getTeacherByNo(String employNo);
	/**
	 * 方法描述:通过学生名字获取学生信息
	 * @return
	 */
	public Teacher getTeacherByName(String employName);

	/**
	 * 方法描述:保存用户的同时创建用户
	 * @param teacher
	 */
	void saveAndCreateRole(Teacher teacher);

	/**
	 * 方法描述:删除教师基本信息同时也注销用户
	 * @param selectedRow
	 */
	void deleteTeacher(String[] selectedRow);
}
