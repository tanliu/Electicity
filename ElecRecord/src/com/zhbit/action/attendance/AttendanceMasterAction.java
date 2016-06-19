package com.zhbit.action.attendance;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.attendence.AttendanceMasterServices;
import com.zhbit.services.system.SystemDllServices;
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
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	
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
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"学院名称"};
		String[] params2={"学年"};
		
		//查找学院类别	
		List<SystemDll> colleges=systeDllServices.findObjectByFields(fields, params1);
		//查找学年
		List<SystemDll> years=systeDllServices.findObjectByFields(fields, params2);
		
		//将查询到的信息推送到前台显示
		request.setAttribute("colleges", colleges);	
		request.setAttribute("years", years);
		
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
		request.setAttribute("attendanceMatser",attendanceMatser);
		
		//先判断用户是否已经选中
				if(getSelectedRow()!=null){		
				attendanceMasterServices.deleteObjectByIds(getSelectedRow());		
				}
		return "delete";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", attendanceMatser);
		
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"学院名称"};
		String[] params2={"学年"};
		
		//查找学院类别	
		List<SystemDll> colleges=systeDllServices.findObjectByFields(fields, params1);
		//查找学年
		List<SystemDll> years=systeDllServices.findObjectByFields(fields, params2);
		
		//将查询到的信息推送到前台显示
		request.setAttribute("colleges", colleges);	
		request.setAttribute("years", years);
		
		attendanceMatser=attendanceMasterServices.findObjectById(attendanceMatser.getId());
		
		request.setAttribute("attendanceMatser", attendanceMatser);
		
		return "editorUI";
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		//去除空格外使用update方法更新考勤课程信息
		attendanceMatser=attendanceMasterServices.trimAttendanceMaster(attendanceMatser);
		attendanceMasterServices.update(attendanceMatser);
		
		//保存成功后将attendanceMatser中的属性设定为查询条件
		attendanceMatser.setCoursename(getQuery_coursename());
		attendanceMatser.setEmployName(getQuery_employName());
		attendanceMatser.setAddress(getQuery_address());
				
		request.setAttribute("attendanceMatser",attendanceMatser);
		
		return "editor";
	}

	
	public String detailUI(){
		
		attendanceMatser=attendanceMasterServices.findObjectById(attendanceMatser.getId());
		
		request.setAttribute("attendanceMatser",attendanceMatser);
		
		return "detailUI";
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
