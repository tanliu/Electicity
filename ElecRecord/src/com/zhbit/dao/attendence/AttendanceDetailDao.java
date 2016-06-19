package com.zhbit.dao.attendence;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.AttendanceDetail;

public interface AttendanceDetailDao extends BaseDao<AttendanceDetail> {

	public static final String DAO_NAME="com.zhbit.dao.impl.AttendanceDetailDaoImpl";
	public void saveAttendanceDetails(List<AttendanceDetail> attendanceDetails);
}
