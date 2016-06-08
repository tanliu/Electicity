/**
 * 
 */
package com.zhbit.services.student.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.student.StudentDao;
import com.zhbit.entity.Student;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.EncryptUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：StudentServicesImpl 
 * 类描述：学生基本信息Services层的接口实现类 
 * 创建人：谭柳
 * 创建时间：2016年6月7日 下午11:17:07
 * 修改人：TanLiu 
 * 修改时间：2016年6月7日 下午11:17:07
 * 修改备注： 
 * @version 
 */
@Service(value=StudentServices.SERVICES_NAME)
public class StudentServicesImpl extends BaseServicesImpl<Student> implements StudentServices {

	StudentDao studentDao;
	@Resource(name=StudentDao.DAO_NAME)
	public void setStudentDao(StudentDao studentDao) {
		super.setBaseDao(studentDao);
		this.studentDao = studentDao;
	}
	@Override
	public void saveStudent(String creator, Student student) {

		//设置默认密码123456
		student.setPassword(EncryptUtils.MD5Encrypt("123456"));
		//设置创建人创建时间
		student.setCreator(creator);
		student.setCreateTime(new Timestamp(new Date().getTime()));
		//保存学生
		this.save(student);
		
	}
}
