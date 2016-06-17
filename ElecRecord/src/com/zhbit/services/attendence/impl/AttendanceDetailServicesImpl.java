package com.zhbit.services.attendence.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.attendence.AttendanceDetailDao;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.services.BaseServices;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.attendence.AttendanceDetailServices;

@Service(value=AttendanceDetailServices.SERVICES_NAME)
public class AttendanceDetailServicesImpl extends BaseServicesImpl<AttendanceDetail> implements AttendanceDetailServices {
	@Resource(name=AttendanceDetailDao.DAO_NAME)
	AttendanceDetailDao attendanceDetailDao;
	
	public void setAttendanceDetailDao(AttendanceDetailDao attendanceDetailDao) {
		super.setBaseDao(attendanceDetailDao);
		this.attendanceDetailDao = attendanceDetailDao;
	}
}
