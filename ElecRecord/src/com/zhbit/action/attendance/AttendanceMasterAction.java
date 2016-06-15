package com.zhbit.action.attendance;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.services.attendence.AttendanceMasterServices;
import com.zhbit.util.DecodeUtils;

@Controller("attendanceMasterAction")
@Scope(value="prototype")
public class AttendanceMasterAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	AttendanceMaster attendanceMatser;
	private String query_coursename;
	private String query_employName;
	private String query_address;
	
	@Resource(name=AttendanceMasterServices.SERVICES_NAME)
	AttendanceMasterServices attendanceMasterServices;
	
	
	/**
	 * 
	 */
	

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		//对传来的查询条件进行编码
				if(attendanceMatser!=null){
					try {
						attendanceMatser.setCoursename(DecodeUtils.decodeUTF(attendanceMatser.getCoursename()));
						attendanceMatser.setEmployName(DecodeUtils.decodeUTF(attendanceMatser.getEmployName()));
						attendanceMatser.setAddress(DecodeUtils.decodeUTF(attendanceMatser.getAddress()));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						System.out.println("编码时出错");
				}
				}
			
		//将传过来的参数进行回显
		request.setAttribute("queryCon",attendanceMatser);	
		pageUtils=attendanceMasterServices.queryList(attendanceMatser, getPageNO(), getPageSize());
		
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		
		//保存查询条件
		request.setAttribute("queryCon", attendanceMatser);
		
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		
		//去除可能存在的空格后再进行存储
		attendanceMasterServices.trimAttendanceMaster(attendanceMatser);
		
		if(attendanceMatser!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			attendanceMatser.setCreateTime(createtime);
			
			attendanceMasterServices.save(attendanceMatser);
		}
		
		//保存成功后将attendanceMatser中的属性设定为查询条件
		attendanceMatser.setCoursename(getQuery_coursename());
		attendanceMatser.setEmployName(getQuery_employName());
		attendanceMatser.setAddress(getQuery_address());
		
		request.setAttribute("attendanceMatser",attendanceMatser);
		
		return "add";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return "editorUI";
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

	
	//------------------getter&setter----------------------
	
	public AttendanceMaster getAttendanceMatser() {
		return attendanceMatser;
	}

	public void setAttendanceMatser(AttendanceMaster attendanceMatser) {
		this.attendanceMatser = attendanceMatser;
	}

	public String getQuery_coursename() {
		return query_coursename;
	}

	public void setQuery_coursename(String query_coursename) {
		this.query_coursename = query_coursename;
	}

	public String getQuery_employName() {
		return query_employName;
	}

	public void setQuery_employName(String query_employName) {
		this.query_employName = query_employName;
	}

	public String getQuery_address() {
		return query_address;
	}

	public void setQuery_address(String query_address) {
		this.query_address = query_address;
	}

	
}
