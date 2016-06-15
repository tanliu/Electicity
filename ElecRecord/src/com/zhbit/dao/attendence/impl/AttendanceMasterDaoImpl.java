package com.zhbit.dao.attendence.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.attendence.AttendanceMasterDao;
import com.zhbit.entity.AttendanceMaster;

@Repository(value=AttendanceMasterDao.DAO_NAME)
public class AttendanceMasterDaoImpl extends BaseDaoImpl<AttendanceMaster> implements AttendanceMasterDao {
	
	
}
