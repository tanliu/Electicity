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

import org.springframework.stereotype.Service;

import com.zhbit.dao.course.CourseDao;
import com.zhbit.entity.Course;
import com.zhbit.entity.Familyinfo;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.course.CourseServices;

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
	
}
