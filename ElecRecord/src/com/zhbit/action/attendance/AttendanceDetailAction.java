package com.zhbit.action.attendance;

import javax.annotation.Resource;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.services.attendence.AttendanceDetailServices;

public class AttendanceDetailAction extends BaseAndExcelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AttendanceDetail attendanceDetail;
	@Resource(name=AttendanceDetailServices.SERVICES_NAME)
	AttendanceDetailServices attendanceDetailServices;

	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	//-----------------------getter&setter---------------------------------
	public AttendanceDetail getAttendanceDetail() {
		return attendanceDetail;
	}

	public void setAttendanceDetail(AttendanceDetail attendanceDetail) {
		this.attendanceDetail = attendanceDetail;
	}
	
}
