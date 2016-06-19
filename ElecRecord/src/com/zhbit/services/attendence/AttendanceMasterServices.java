package com.zhbit.services.attendence;

import com.zhbit.entity.AttendanceMaster;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface AttendanceMasterServices extends BaseServices<AttendanceMaster> {
	public static final String SERVICES_NAME="com.zhbit.services.impl.AttendanceMasterServicesImpl";
	
	public AttendanceMaster trimAttendanceMaster(AttendanceMaster attendanceMaster);
	
	public PageUtils queryList(AttendanceMaster attendanceMaster, int pageNO, int pageSize);
}
