package com.zhbit.dao.attendence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.attendence.AttendanceDetailDao;
import com.zhbit.entity.AttendanceDetail;

@Repository(value=AttendanceDetailDao.DAO_NAME)
public class AttendanceDetailDaoImpl extends BaseDaoImpl<AttendanceDetail> implements AttendanceDetailDao {

	@Override
	public void saveAttendanceDetails(List<AttendanceDetail> attendanceDetails) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdateAll(attendanceDetails);
	}
    
}
