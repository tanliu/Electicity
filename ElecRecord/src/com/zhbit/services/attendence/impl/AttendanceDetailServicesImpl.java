package com.zhbit.services.attendence.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.attendence.AttendanceDetailDao;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.Tutor;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.attendence.AttendanceDetailServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Service(value=AttendanceDetailServices.SERVICES_NAME)
public class AttendanceDetailServicesImpl extends BaseServicesImpl<AttendanceDetail> implements AttendanceDetailServices {
	
	AttendanceDetailDao attendanceDetailDao;
	@Resource(name=AttendanceDetailDao.DAO_NAME)
	
	public void setAttendanceDetailDao(AttendanceDetailDao attendanceDetailDao) {
		super.setBaseDao(attendanceDetailDao);
		this.attendanceDetailDao = attendanceDetailDao;
	}

	@Override
	public AttendanceDetail trimAttendanceDetail(AttendanceDetail attendanceDetail) {
		// TODO Auto-generated method stub
		
		if(attendanceDetail!=null){
			if(!StringUtils.isEmpty(attendanceDetail.getSelectedcourseno())){
				attendanceDetail.setSelectedcourseno(attendanceDetail.getSelectedcourseno().trim());
			}
			if(!StringUtils.isEmpty(attendanceDetail.getStudentno())){
				attendanceDetail.setStudentno(attendanceDetail.getStudentno().trim());
			}
			if(!StringUtils.isEmpty(attendanceDetail.getStuname())){
				attendanceDetail.setStuname(attendanceDetail.getStuname().trim());
			}
			if(!StringUtils.isEmpty(attendanceDetail.getClassname())){
				attendanceDetail.setClassname(attendanceDetail.getClassname().trim());
			}
		}
		
		return attendanceDetail;
	}
	
	@Override
	public PageUtils getPageUtils(String[] fields, Object[] params, String proterty, String order, int pageNO,
			int pageSize) {
		
		// TODO Auto-generated method stub
		QueryUtils queryUtils=new QueryUtils(AttendanceDetail.class, "entity");
		//添加查询条件
		if(fields!=null&&fields.length>0&&params!=null&&params.length>0&&fields.length==params.length){
			for(int i=0;i<fields.length;i++){
				if(!StringUtils.isEmpty(fields[i])&&!StringUtils.isEmpty((params[i])+"")){
					queryUtils.addCondition("entity."+fields[i], params[i]);				
				}
			}
		}
		
		//添加排序
		if(!StringUtils.isEmpty(proterty)&&!StringUtils.isEmpty(order)){
			queryUtils.addOrderByProperty("entity."+proterty, order);
		}
		
		return attendanceDetailDao.getPageUtils(queryUtils, pageNO, pageSize);
		
	}

	@Override
	public PageUtils queryList(AttendanceDetail attendanceDetail, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String[] fields=null;
		Object[] params=null;
		String proterty="createTime";
		
		if(attendanceDetail!=null){//当attendanceDetail不为空时
			//先去除查询条件中可能存在的空格
			if(!StringUtils.isEmpty(attendanceDetail.getStudentno())){
				attendanceDetail.setStudentno(attendanceDetail.getStudentno().trim());
			}
			if(!StringUtils.isEmpty(attendanceDetail.getStuname())){
				attendanceDetail.setStuname(attendanceDetail.getStuname().trim());
			}
			if(!StringUtils.isEmpty(attendanceDetail.getClassname())){
				attendanceDetail.setClassname(attendanceDetail.getClassname().trim());
			}
			
			//这里要对考勤时间进行判空处理
			if(attendanceDetail.getAttendanceTime()!=null){
			fields=new String[]{"studentno=?","stuname like ?","classname like ?","attendanceTime=?"};
			params=new Object[]{attendanceDetail.getStudentno(),"%"+attendanceDetail.getStuname()+"%","%"+attendanceDetail.getClassname()+"%",attendanceDetail.getAttendanceTime()};
			}
			else{
				fields=new String[]{"studentno=?","stuname like ?","classname like ?"};
				params=new Object[]{attendanceDetail.getStudentno(),"%"+attendanceDetail.getStuname()+"%","%"+attendanceDetail.getClassname()+"%"};
			}
		}
		
		
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
		
	}

	@Override
	public void saveAttendanceDeatils(List<AttendanceDetail> attendanceDetails){
		attendanceDetailDao.saveAttendanceDetails(attendanceDetails);
	}
	
	@Override
	public List<AttendanceDetail> findObjectByFields(String[] fields,Object[] params) {
		QueryUtils queryUtils=new QueryUtils(AttendanceDetail.class, "entity");
		if(fields!=null&&fields.length>0&&params!=null&&params.length>0){
			for(int i=0;i<fields.length;i++){
			if(!StringUtils.isEmpty(fields[i])&&!StringUtils.isEmpty((params[i]+""))){
				queryUtils.addCondition("entity."+fields[i], params[i]);				
			}
			}
		}
		return attendanceDetailDao.findObjectByFields(queryUtils);
	}
}
