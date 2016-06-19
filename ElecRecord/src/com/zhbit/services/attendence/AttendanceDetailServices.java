package com.zhbit.services.attendence;

import java.util.List;

import com.zhbit.entity.AttendanceDetail;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface AttendanceDetailServices extends BaseServices<AttendanceDetail> {

	public static final String SERVICES_NAME="com.zhbit.services.impl.AttendanceDetailServicesImpl";
	
	public AttendanceDetail trimAttendanceDetail(AttendanceDetail attendanceDetail);
	
	public PageUtils queryList(AttendanceDetail attendanceDetail, int pageNO, int pageSize); 
	
	public void saveAttendanceDeatils(List<AttendanceDetail> attendanceDetails);
}
