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

import com.zhbit.dao.course.CourseGradeDao;
import com.zhbit.entity.Course;
import com.zhbit.entity.CourseGrade;
import com.zhbit.entity.Student;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.course.CourseGradeServices;
import com.zhbit.services.course.CourseServices;
import com.zhbit.services.student.StudentServices;

@Service(value=CourseGradeServices.SERVICE_NAME)
public class CourseGradeServicesImpl extends BaseServicesImpl<CourseGrade> implements CourseGradeServices {

	CourseGradeDao courseGradeDao;
	@Resource(name=CourseGradeDao.DAO_NAME)
	public void setCourseGradeDao(CourseGradeDao courseGradeDao) {
		super.setBaseDao(courseGradeDao);
		this.courseGradeDao = courseGradeDao;
	}
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	@Resource(name=CourseServices.SERVICES_NAME)
	CourseServices courseService;
	
	@Override
	public void saveFromExcel(List<Object> courses, String creator) {
		
		if(courses!=null&&courses.size()>0){
			List<CourseGrade> courseGrades=new ArrayList<CourseGrade>();
			for (Object object : courses) {
				CourseGrade courseGrade=(CourseGrade) object;
				//查看此学生是否存在
				Student student=studentServices.getStudentByNo(courseGrade.getStudentNo());
				if(student==null){
					continue;
				}
				//查看是有此学生
				Course course=courseService.getCourseBySelectId(courseGrade.getSelectedCourseNo());
				if(course==null){
					continue;
				}
				//查看此学生是否选择了这个课程
				String[] fields={"studentNo=?","selectedCourseNo=?"};
				String[] params={courseGrade.getStudentNo(),courseGrade.getSelectedCourseNo()};
				List<CourseGrade> grades=this.findObjectByFields(fields, params);
				if(grades!=null&&grades.size()>0){
					continue;
				}
				//
				courseGrade.setEmployNo(course.getEmployNo());
				courseGrade.setEmployName(course.getEmployName());
				courseGrade.setSelectId(course.getId());
				courseGrade.setStuId(student.getStuId());
				courseGrade.setCreateTime(new Timestamp(new Date().getTime()));
				courseGrade.setCreator(creator);
				courseGrades.add(courseGrade);
			}
			courseGradeDao.saveAll(courseGrades);
		}
		
		
		//查询
	}

	@Override
	public List<CourseGrade> getSelectCourseBySelectNO(String selectedId) {
		String[] fields={"selectId=?"};
		String[] params={selectedId};		
		return this.findObjectByFields(fields, params);
	}

	@Override
	public void saveAll(List<CourseGrade> grades) {
		courseGradeDao.saveAll(grades);
		
	}

	@Override
	public void saveGradeFromExcel(List<Object> grades, String creator) {
		
		if(grades!=null&&grades.size()>0){
			List<CourseGrade> courses=findAllObject();
			//把所有数据封装到map中
			for (Object object : grades) {
				CourseGrade grade=(CourseGrade) object;
				String[] fields={"studentNo=?","selectedCourseNo=?"};
				String[] params={grade.getStudentNo(),grade.getSelectedCourseNo()};
				List<CourseGrade> courseGrades=findObjectByFields(fields, params);
				CourseGrade courseGrade=null;
				if(courseGrades!=null&&courseGrades.size()>0){
					courseGrade=courseGrades.get(0);
				}
				if(courseGrade==null){ //数据库中没有数据
					continue;
				}
				courseGrade.setConvertScore(grade.getConvertScore());
				courseGrade.setEndScore(grade.getConvertScore());
				courseGrade.setFinalScore(grade.getFinalScore());
				courseGrade.setGradePoint(grade.getGradePoint());
				courseGrade.setLabScore(grade.getLabScore());
				courseGrade.setResitMemo(grade.getResitMemo());
				courseGrade.setResitScore(grade.getRepairScore());
				courseGrade.setRetakeFlag(grade.getRetakeFlag());
				courseGrade.setRepairScore(grade.getResitScore());
				courseGrade.setUsualScore(grade.getUsualScore());
				courseGrade.setMiddleScore(grade.getMiddleScore());
				
			}
			
			
			
			
		}
		
	}

	@Override
	public void saveSelectCourse(CourseGrade courseGrade,String creator) {
		if(!StringUtils.isBlank(courseGrade.getSelectedCourseNo())&&!StringUtils.isBlank(courseGrade.getStudentNo())){
			Student student=studentServices.getStudentByNo(courseGrade.getStudentNo());
			Course course=courseService.getCourseBySelectId(courseGrade.getSelectedCourseNo());
			if(student==null||course==null){  //如果这两个信息为空时，就不保存
				return ;
			}
			//查看此学生是否选择了这个课程
			String[] fields={"studentNo=?","selectedCourseNo=?"};
			String[] params={courseGrade.getStudentNo(),courseGrade.getSelectedCourseNo()};
			List<CourseGrade> grades=this.findObjectByFields(fields, params);
			if(grades!=null&&grades.size()>0){
				return;
			}
			//
			courseGrade.setEmployNo(course.getEmployNo());
			courseGrade.setEmployName(course.getEmployName());
			courseGrade.setCourseType(course.getCourseType());
            
			courseGrade.setSelectId(course.getId());
			courseGrade.setStuId(student.getStuId());
			courseGrade.setMajor(student.getMajor());
			courseGrade.setOrgName(student.getOrgName());
			courseGrade.setOrgId(student.getOrgId());
			courseGrade.setCreateTime(new Timestamp(new Date().getTime()));
			courseGrade.setCreator(creator);
			save(courseGrade);
		}
		
	}
}
