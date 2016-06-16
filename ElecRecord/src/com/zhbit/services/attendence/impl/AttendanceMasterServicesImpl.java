package com.zhbit.services.attendence.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.attendence.AttendanceMasterDao;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.attendence.AttendanceMasterServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Service(value=AttendanceMasterServices.SERVICES_NAME)
public class AttendanceMasterServicesImpl extends BaseServicesImpl<AttendanceMaster>
		implements AttendanceMasterServices {
	
	
	AttendanceMasterDao attendanceMasterDao;
	
	@Resource(name=AttendanceMasterDao.DAO_NAME)
	public void setAttendanceMasterDao(AttendanceMasterDao attendanceMasterDao){
		super.setBaseDao(attendanceMasterDao);
		this.attendanceMasterDao = attendanceMasterDao;
	}

	@Override
	public AttendanceMaster trimAttendanceMaster(AttendanceMaster attendanceMaster) {
		// TODO Auto-generated method stub
		if(attendanceMaster!=null){
			if(!StringUtils.isEmpty(attendanceMaster.getSelectedcourseno())){
				attendanceMaster.setSelectedcourseno(attendanceMaster.getSelectedcourseno().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getCoursename())){
				attendanceMaster.setCoursename(attendanceMaster.getCoursename().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getEmployNo())){
				attendanceMaster.setEmployNo(attendanceMaster.getEmployNo().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getEmployName())){
				attendanceMaster.setEmployName(attendanceMaster.getEmployName().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getSchooltime())){
				attendanceMaster.setSchooltime(attendanceMaster.getSchooltime().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getAddress())){
				attendanceMaster.setAddress(attendanceMaster.getAddress().trim());
			}
			if(!StringUtils.isEmpty(attendanceMaster.getMemo())){
				attendanceMaster.setMemo(attendanceMaster.getMemo().trim());
			}
		}
		return attendanceMaster;
	}

	@Override
	public PageUtils queryList(AttendanceMaster attendanceMaster, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
				String[] fields=null;
				String[] params=null;
				String proterty="createTime";		
				if(attendanceMaster!=null){ //当考勤信息不为空时
					//先去除课程名称和教师姓名、上课地点中可能存在的空格
					if(!StringUtils.isEmpty(attendanceMaster.getCoursename())){
						attendanceMaster.setCoursename(attendanceMaster.getCoursename().trim());
					}
					if(!StringUtils.isEmpty(attendanceMaster.getEmployName())){
						attendanceMaster.setEmployName(attendanceMaster.getEmployName().trim());
					}
					if(!StringUtils.isEmpty(attendanceMaster.getAddress())){
						attendanceMaster.setAddress(attendanceMaster.getAddress().trim());
					}
						fields=new String[]{"coursename like ?","employName like ?","address like ?"};
						params=new String[]{"%"+attendanceMaster.getCoursename()+"%","%"+attendanceMaster.getEmployName()+"%","%"+attendanceMaster.getAddress()+"%"};
					
				}
				// TODO Auto-generated method stub
				return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

	
	
}
