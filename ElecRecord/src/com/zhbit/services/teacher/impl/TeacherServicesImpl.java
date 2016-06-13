/**
 * 
 */
package com.zhbit.services.teacher.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.teacher.TeacherDao;
import com.zhbit.entity.Student;
import com.zhbit.entity.Teacher;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.teacher.TeacherServices;
import com.zhbit.util.EncryptUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TeacherServicesImpl 
 * 类描述：  教师基本信息Service层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月12日 上午12:45:48
 * 修改人：TanLiu 
 * 修改时间：2016年6月12日 上午12:45:48
 * 修改备注： 
 * @version 
 */
@Service(value=TeacherServices.SERVICES_NAME)
public class TeacherServicesImpl extends BaseServicesImpl<Teacher> implements TeacherServices {

	TeacherDao teacherDao;
	@Resource(name=TeacherDao.DAO_NAME)
	public void setTeacherDao(TeacherDao teacherDao) {
		setBaseDao(teacherDao);
		this.teacherDao = teacherDao;
	}
	@Override
	public void saveFromExcel(List<Object> teachers, String creator) {
		if(teachers!=null&&teachers.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : teachers) {
				Teacher teacher=(Teacher) object;
				//判断是否存在这个学生
				Boolean flag=this.hasTeacher(teacher.getEmployNo());
				if(!flag){ //如果系统中没有这个学生的信息
					teacher.setCreateTime(new Timestamp(new Date().getTime()));
					teacher.setCreator(creator);
					this.save(teacher);					
				}
			}
		}
	}
	@Override
	public Boolean hasTeacher(String employNo) {
		String[] fields={"employNo=?"};
		String[] params={employNo};
		List<Teacher> teachers = findObjectByFields(fields, params);
		if(teachers==null||teachers.size()==0){
			return false;
		}
		return true;
	}
	@Override
	public Teacher getTeacherByNo(String employNo) {
		String[] fields={"employNo=?"};
		String[] params={employNo};
		List<Teacher> teachers = findObjectByFields(fields, params);
		if(teachers!=null&&teachers.size()>0){
			return teachers.get(0);
		}
		return null;
	}
	@Override
	public Teacher getTeacherByName(String employName) {
		String[] fields={"employName=?"};
		String[] params={employName};
		List<Teacher> teachers = findObjectByFields(fields, params);
		if(teachers!=null&&teachers.size()>0){
			return teachers.get(0);
		}
		return null;
	}
}
