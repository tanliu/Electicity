/**
 * 
 */
package com.zhbit.services.student;

import java.util.List;

import com.zhbit.entity.Familyinfo;
import com.zhbit.entity.LearningExperience;
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

    void saveStudent(String createor,Student student, List<Familyinfo> family, List<LearningExperience> experiences);

	/**
	 * 方法描述:保存导入的数据
	 * @param students
	 * @param creator
	 */
	void saveFromExcel(List<Object> students, String creator);
	
	/**
	 * 方法描述:判断系统是存在学号为这个的学生
	 * @param studentNo
	 * @return
	 */
	Boolean hasStudent(String studentNo);
	
	/**
	 * 方法描述:通过学号获取学生信息
	 * @return
	 */
	public Student getStudentByNo(String stuNO);
	/**
	 * 方法描述:通过学生名字获取学生信息
	 * @return
	 */
	public Student getStudentByName(String stuName);

	/**
	 * 方法描述:更新学生信息
	 * @param student
	 * @param creator
	 * @param family
	 * @param experiences
	 * @param familyIds
	 * @param experiencesIds
	 */
	void updateStudent(Student student,String creator, List<Familyinfo> family, List<LearningExperience> experiences, String[] familyIds, String[] experiencesIds);

	/**
	 * 方法描述:保存数据从excel导入的家庭情况信息
	 * @param students
	 * @param creator
	 * @param fatherinfos
	 * @param motherinfos
	 */
	void saveFamilyFromExcel(List<Object> students, String creator, List<Object> fatherinfos, List<Object> motherinfos);
	
}
