/**
 * 
 */
package com.zhbit.services.course.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.course.CourseDao;
import com.zhbit.entity.Course;
import com.zhbit.entity.CourseGrade;
import com.zhbit.entity.Familyinfo;
import com.zhbit.entity.Student;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.course.CourseGradeServices;
import com.zhbit.services.course.CourseServices;
import com.zhbit.services.student.StudentServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：CourseServicesImpl 
 * 类描述： 开课信息接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月14日 下午11:52:26
 * 修改人：TanLiu 
 * 修改时间：2016年6月14日 下午11:52:26
 * 修改备注： 
 * @version 
 */
@Service(value=CourseServices.SERVICES_NAME)
public class CourseServicesImpl extends BaseServicesImpl<Course> implements CourseServices {

	CourseDao courseDao;
	@Resource(name=CourseDao.DAO_NAME)
	public void setCourseDao(CourseDao courseDao) {
		super.setBaseDao(courseDao);
		this.courseDao = courseDao;
	}
	@Resource(name=CourseGradeServices.SERVICE_NAME)
	CourseGradeServices gradeServices;
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	
	@Override
	public void saveCourse(String creator, Course course) {
		//创建选课号学年（2007-2008）-学期（1）-课程编号（02110000）-任课老师工号（02029）
		StringBuffer selectNo=new StringBuffer("");
		selectNo.append("(").append(course.getAcademicYear())
		.append("-").append(course.getTerm()).append(")");
		selectNo.append("-").append(course.getCourseCode())
		.append("-").append(course.getEmployNo());
		System.out.println(selectNo);
		//查找表是否存在这个表
		String[] fields={"selectedCourseNo like ? "};
		String[] params={"%"+selectNo.toString()+"%"};
		List<Course> coursesNum=findObjectByFields(fields, params);
		if(coursesNum!=null&&coursesNum.size()>0){
			selectNo.append("-").append((coursesNum.size()+1));
		}else{
			selectNo.append("-").append(1);
		}
		course.setSelectedCourseNo(selectNo.toString());
		//设置学分可根据总学时除以16进行换算得到该值
		course.setCredit(((double)course.getTotalHours())/16);
		course.setCreateTime(new Timestamp(new Date().getTime()));
		course.setCreator(creator);
		courseDao.save(course);
		
	}
	@Override
	public void updateCourse(Course course) {
		//创建选课号学年（2007-2008）-学期（1）-课程编号（02110000）-任课老师工号（02029）
		StringBuffer selectNo=new StringBuffer("");
		selectNo.append("(").append(course.getAcademicYear())
		.append("-").append(course.getTerm()).append(")");
		selectNo.append("-").append(course.getCourseCode())
		.append("-").append(course.getEmployNo());
		System.out.println(selectNo);
		//查找表是否存在这个表
		String[] fields={"selectedCourseNo like ? "};
		String[] params={"%"+selectNo.toString()+"%"};
		List<Course> coursesNum=findObjectByFields(fields, params);
		if(coursesNum!=null&&coursesNum.size()>0){
			selectNo.append("-").append((coursesNum.size()+1));
		}else{
			selectNo.append("-").append(1);
		}
		course.setSelectedCourseNo(selectNo.toString());
		//设置学分可根据总学时除以16进行换算得到该值
		course.setCredit(((double)course.getTotalHours())/16);
		courseDao.update(course);
		
	}
	@Override
	public void saveFromExcel(List<Object> courses, String creator) {
		//从学号excel信息
		if(courses!=null&&courses.size()>0){
			//拿到信息对数据唯一性进行校验
			Map<String, String> onlymap=new HashMap<String, String>();
			List<Course> onlyCouserinfos=this.findAllObject();
			if(onlyCouserinfos!=null&&onlyCouserinfos.size()>0){
				for (Course course : onlyCouserinfos) {
					onlymap.put(course.getSelectedCourseNo(), "存在");
				}
			}
			//对数据进行处理
			List<Course> dBCourses=new ArrayList<Course>();
			for (Object object : courses) {
				Course course=(Course) object;
				if("存在".equals(onlymap.get(course.getSelectedCourseNo()))){
					continue;
				}
				String[] infos=course.getSelectedCourseNo().replace("(", "").replace(")", "").split("-");
				course.setAcademicYear(infos[0]+"-"+infos[1]);
				course.setTerm(infos[2]);
				course.setCourseCode(infos[3]);
				course.setEmployNo(infos[4]);
				
				course.setCredit(((double)course.getTotalHours())/16);
				course.setCreateTime(new Timestamp(new Date().getTime()));
				course.setCreator(creator);
				dBCourses.add(course);
				
			}
			courseDao.saveAll(dBCourses);
		}
		
	}
	@Override
	public Course getCourseBySelectId(String selectId) {
		if(StringUtils.isBlank(selectId)){
			return null;
		}
		String[] fields={"selectedCourseNo=?"};
		String[] params={selectId};
		List<Course> courses=findObjectByFields(fields, params);
		if(courses!=null&&courses.size()>0){
			return courses.get(0);
		}
		return null;
	}
	@Override
	public void saveSelectInfo(Course course, List<CourseGrade> grades, String[] gradesIds, String creator) {
		//先查找是否存在这个课程
		course=findObjectById(course.getId());
		if(course==null){
			return;
		}		
		//删除课程
		if(gradesIds!=null){
			gradeServices.deleteObjectByIds(gradesIds);			
		}
		if(grades!=null)
		//保存更新的选课课程
		for (CourseGrade grade : grades) {
			//保存课程信息
			grade.setSelectedCourseNo(course.getSelectedCourseNo());
			grade.setSelectId(course.getId());
			grade.setEmployNo(course.getEmployNo());
			grade.setEmployName(course.getEmployName());
			grade.setCourseName(course.getCourseName());
			grade.setCourseType(course.getCourseType());
			if(StringUtils.isBlank(grade.getId())){
				//保存学生信息
				Student student=studentServices.getStudentByNo(grade.getStudentNo());
				if(student!=null){
					grade.setStuId(student.getStuId());					
				}
				grade.setCreateTime(new Timestamp(new Date().getTime()));
				grade.setCreator(creator);
				
			}
		}
		gradeServices.saveAll(grades);
		
	}
	
}
