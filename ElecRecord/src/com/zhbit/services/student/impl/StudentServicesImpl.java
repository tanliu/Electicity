/**
 * 
 */
package com.zhbit.services.student.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.student.StudentDao;
import com.zhbit.entity.Familyinfo;
import com.zhbit.entity.LearningExperience;
import com.zhbit.entity.Student;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.FamilyServices;
import com.zhbit.services.student.LearnExperienceServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.EncryptUtils;

/**
 * 项目名称：ElecRecord 类名称：StudentServicesImpl 类描述：学生基本信息Services层的接口实现类 创建人：谭柳
 * 创建时间：2016年6月7日 下午11:17:07 修改人：TanLiu 修改时间：2016年6月7日 下午11:17:07 修改备注：
 * 
 * @version
 */
@Service(value = StudentServices.SERVICES_NAME)
public class StudentServicesImpl extends BaseServicesImpl<Student> implements StudentServices {

	StudentDao studentDao;

	@Resource(name = StudentDao.DAO_NAME)
	public void setStudentDao(StudentDao studentDao) {
		super.setBaseDao(studentDao);
		this.studentDao = studentDao;
	}

	@Resource(name = FamilyServices.SERVICES_NAME)
	FamilyServices familyServices;

	@Resource(name = LearnExperienceServices.SERVICES_NAME)
	LearnExperienceServices experienceServices;

	@Override
	public void saveStudent(String creator, Student student, List<Familyinfo> family,
			List<LearningExperience> experiences) {

		// 设置默认密码123456
		student.setPassword(EncryptUtils.MD5Encrypt("123456"));
		// 设置创建人创建时间
		student.setCreator(creator);
		student.setCreateTime(new Timestamp(new Date().getTime()));
		// 保存学生
		this.save(student);

		// 处理学生家庭情况
		if (family != null && family.size() > 0) {
			for (Familyinfo familyinfo : family) {
				familyinfo.setStuId(student.getStuId());
				familyinfo.setStudentNo(student.getStudentNo());
				familyinfo.setStuName(student.getStuName());
				familyinfo.setCreateTime(new Timestamp(new Date().getTime()));
				familyinfo.setCreator(creator);
				familyServices.save(familyinfo);

			}
		}

		// 处理学生学历情况
		if (experiences != null && experiences.size() > 0) {
			for (LearningExperience experience : experiences) {
				experience.setStuId(student.getStuId());
				experience.setStudentNo(student.getStudentNo());
				experience.setStuName(student.getStuName());
				experience.setCreateTime(new Timestamp(new Date().getTime()));
				experience.setCreator(creator);
				experienceServices.save(experience);
			}
		}

	}

	@Override
	public void saveFromExcel(List<Object> students, String creator) {
		if (students != null && students.size() > 0) {
			// 对每一条数据进行校验和设置相应的值
			for (Object object : students) {
				Student student = (Student) object;
				// 判断是否存在这个学生
				Boolean flag = this.hasStudent(student.getStudentNo());
				if (!flag) { // 如果系统中没有这个学生的信息
					student.setCreateTime(new Timestamp(new Date().getTime()));
					student.setCreator(creator);
					student.setPassword(EncryptUtils.MD5Encrypt("123456"));
					this.save(student);
				}
			}
		}

	}

	public Boolean hasStudent(String studentNo) {
		String[] fields = { "studentNo=?" };
		String[] params = { studentNo };
		List<Student> students = findObjectByFields(fields, params);
		if (students == null || students.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Student getStudentByNo(String stuNO) {
		String[] fields = { "studentNo=?" };
		String[] params = { stuNO };
		List<Student> students = findObjectByFields(fields, params);
		if (students != null && students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@Override
	public Student getStudentByName(String stuName) {
		String[] fields = { "stuName=?" };
		String[] params = { stuName };
		List<Student> students = findObjectByFields(fields, params);
		if (students != null && students.size() > 0) {
			return students.get(0);
		}
		return null;
	}

	@Override
	public void updateStudent(Student student, String creator, List<Familyinfo> familys,
			List<LearningExperience> experiences, String[] familyIds, String[] experiencesIds) {
		// 更新学生信息
		this.update(student);
		//删除家庭信息
		if(familyIds!=null&&familyIds.length>0){
			familyServices.deleteObjectByIds(familyIds);
		}
		// 更新家庭信息
		if (familys != null && familys.size() > 0) {
			for (Familyinfo familyinfo : familys) {
				familyinfo.setStuId(student.getStuId());
				familyinfo.setStudentNo(student.getStudentNo());
				familyinfo.setStuName(student.getStuName());
				if (StringUtils.isBlank(familyinfo.getId())) {
					familyinfo.setCreateTime(new Timestamp(new Date().getTime()));
					familyinfo.setCreator(creator);
				}
			}
			familyServices.saveOrUpdate(familys);
		}
		// 更新学历信息
		//删除学生学历信息
		if(experiencesIds!=null&&experiencesIds.length>0){
			experienceServices.deleteObjectByIds(experiencesIds);
		}
		// 处理学生学历情况
		if (experiences != null && experiences.size() > 0) {
			for (LearningExperience experience : experiences) {
				experience.setStuId(student.getStuId());
				experience.setStudentNo(student.getStudentNo());
				experience.setStuName(student.getStuName());
				if (StringUtils.isBlank(experience.getId())) {
					experience.setCreateTime(new Timestamp(new Date().getTime()));
					experience.setCreator(creator);
				}
			}
			experienceServices.saveOrUpdate(experiences);
		}

	}

	@Override
	public void saveFamilyFromExcel(List<Object> students, String creator, List<Object> fatherinfos,
			List<Object> motherinfos) {
		StringBuffer nostudent=new StringBuffer("");
		Map<String, String> studentMap=new HashMap<String, String>();
		//更新学生的信息
		for (Object object : students) {
			Student student=(Student) object;
			//查找这个学生信息
			Student stu=this.getStudentByNo(student.getStudentNo());
			if(stu==null){
				nostudent.append(student.getStudentNo()).append("@");
				continue;
			}
			studentMap.put(stu.getStudentNo(), stu.getStuId());
			stu.setAddress(student.getAddress());
			stu.setPostCode(student.getPostCode());
			stu.setFamilyTelNo(student.getFamilyTelNo());	
			update(stu);
			
		}
		String nostudentString=nostudent.toString();
		
		//拿到信息对数据唯一性进行校验
		Map<String, String> onlymap=new HashMap<String, String>();
		List<Familyinfo> onlyfamilyinfos=familyServices.findAllObject();
		if(onlyfamilyinfos!=null&&onlyfamilyinfos.size()>0){
			for (Familyinfo familyinfo : onlyfamilyinfos) {
				onlymap.put(familyinfo.getStudentNo()+familyinfo.getName(), "存在");
			}
		}
		
		List<Familyinfo> familyinfos=new ArrayList<Familyinfo>();
		//保存父亲的信息
		for (Object object : fatherinfos) {
			Familyinfo familyinfo=(Familyinfo) object;
			if(nostudentString.contains(familyinfo.getStudentNo())){
				continue;
			}
			if("存在".equals(onlymap.get(familyinfo.getStudentNo()+familyinfo.getName()))){
				continue;
			}
			familyinfo.setStuId(studentMap.get(familyinfo.getStudentNo()));
			familyinfo.setRelation("父亲");
			familyinfo.setCreateTime(new Timestamp(new Date().getTime()));
			familyinfo.setCreator(creator);
			familyinfos.add(familyinfo);
			
		}
		//保存母亲信息
		for (Object object : motherinfos) {
			Familyinfo familyinfo=(Familyinfo) object;
			if(nostudentString.contains(familyinfo.getStudentNo())){
				continue;
			}
			if("存在".equals(onlymap.get(familyinfo.getStudentNo()+familyinfo.getName()))){
				continue;
			}
			familyinfo.setStuId(studentMap.get(familyinfo.getStudentNo()));
			familyinfo.setRelation("母亲");
			familyinfo.setCreateTime(new Timestamp(new Date().getTime()));
			familyinfo.setCreator(creator);
			familyinfos.add(familyinfo);
			
		}
		familyServices.saveOrUpdate(familyinfos);
	}

}
