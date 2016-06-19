package com.zhbit.action.attendance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.AttendExcelImpl;
import com.zhbit.services.attendence.AttendanceDetailServices;
import com.zhbit.services.attendence.AttendanceMasterServices;
import com.zhbit.util.DecodeUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： AttendanceDetailAction
 * 类描述：用于考勤信息模块的Action类
 * 创建人：罗建鑫
 * 创建时间：2016年6月18日 下午10:58:37
 * 修改人：罗建鑫
 * 修改时间：2016年6月18日 下午10:58:37
 * 修改备注： 
 * @version 
 */ 
public class AttendanceDetailAction extends BaseAndExcelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AttendanceDetail attendanceDetail;
	AttendanceMaster attendanceMaster;
	private String query_studentno;
	private String query_stuname;
	private Timestamp query_attendanceTime;
	private String query_classname;
	
	@Resource(name=AttendanceDetailServices.SERVICES_NAME)
	AttendanceDetailServices attendanceDetailServices;
	@Resource(name=AttendanceMasterServices.SERVICES_NAME)
	AttendanceMasterServices attendanceMasterServices;

	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		ExcelConfig config;
		try {
			config = new ExcelConfig(null, "Sheet1", 2, new FileInputStream(excel),excelFileName);		
			List<Object> objects=new AttendExcelImpl().parseExcel(config);
			
			List<AttendanceDetail> attendanceDetails=new ArrayList<AttendanceDetail>();
			
			//object中第一个元素是attendanceMaster信息，其后为attendanceDetail信息
			for(int i=0;i<objects.size();i++){
				
				if(i==0&&objects.get(i)!=null){
					//转换为attendanceMaster对象 
					AttendanceMaster attendanceMaster=(AttendanceMaster)objects.get(i);
					//设定创建时间为当前时间
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					attendanceMaster.setCreateTime(createtime);
					attendanceMaster=attendanceMasterServices.trimAttendanceMaster(attendanceMaster);
					//保存该记录至数据库中
					attendanceMasterServices.save(attendanceMaster);
				}else {
					if(objects.get(i)!=null){
						AttendanceDetail attendanceDetail=(AttendanceDetail)objects.get(i);
						//设定创建时间为当前时间
						Timestamp createtime = new Timestamp(System.currentTimeMillis());
						attendanceDetail.setCreateTime(createtime);
						//先设定Stu_id为9526
						attendanceDetail.setStuId("9526");
						attendanceDetail=attendanceDetailServices.trimAttendanceDetail(attendanceDetail);
						
						//将该数据保存至相对应的AttendanceDetail集合中
						attendanceDetails.add(attendanceDetail);
					}
				}
				
				
				attendanceDetailServices.saveAttendanceDeatils(attendanceDetails);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "excelSuccess";
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		//对传来的查询条件进行编码
		if(attendanceDetail!=null){
			try {
				attendanceDetail.setStudentno(DecodeUtils.decodeUTF(attendanceDetail.getStudentno()));
				attendanceDetail.setStuname(DecodeUtils.decodeUTF(attendanceDetail.getStuname()));
				attendanceDetail.setClassname(DecodeUtils.decodeUTF(attendanceDetail.getClassname()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
	
		//将传过来的参数进行回显
		request.setAttribute("queryCon",attendanceDetail);
		setPageSize(9);

		pageUtils=attendanceDetailServices.queryList(attendanceDetail, getPageNO(), getPageSize());
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", attendanceDetail);
		
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		//先去除存在的空格，再进行存储
		attendanceDetailServices.trimAttendanceDetail(attendanceDetail);
		if(attendanceDetail!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			attendanceDetail.setCreateTime(createtime);
			//先设定stu_id为9526
			attendanceDetail.setStuId("9526");
			
			attendanceDetailServices.save(attendanceDetail);
		}
		
		//保存成功后将attendanceMatser中的属性设定为查询条件
		attendanceDetail.setStudentno(getQuery_studentno());
		attendanceDetail.setStuname(getQuery_stuname());
		attendanceDetail.setAttendanceTime(getQuery_attendanceTime());
		attendanceDetail.setClassname(getQuery_classname());
				
		request.setAttribute("attendanceDetail",attendanceDetail);
		
		return "add";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		request.setAttribute("attendanceDetail",attendanceDetail);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
		attendanceDetailServices.deleteObjectByIds(getSelectedRow());		
		}
		
		return "delete";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", attendanceDetail);
		
		attendanceDetail=attendanceDetailServices.findObjectById(attendanceDetail.getId());
		request.setAttribute("attendanceDetail", attendanceDetail);
		
		//将选课课号对应的选课的信息推送到前台进行显示
		String[] fields={"selectedcourseno=?"};
		Object[] params={attendanceDetail.getSelectedcourseno()};
		attendanceMaster=(AttendanceMaster) attendanceMasterServices.findObjectByFields(fields, params).get(0);
		request.setAttribute("attendanceMaster", attendanceMaster);
		
		return "editorUI";
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		//去除空格外使用update方法更新考勤课程信息
		attendanceDetail=attendanceDetailServices.trimAttendanceDetail(attendanceDetail);
		attendanceDetailServices.update(attendanceDetail);
				
		//保存成功后将attendanceMatser中的属性设定为查询条件
		attendanceDetail.setStudentno(getQuery_studentno());
		attendanceDetail.setStuname(getQuery_stuname());
		attendanceDetail.setAttendanceTime(getQuery_attendanceTime());
		attendanceDetail.setClassname(getQuery_classname());
				
		request.setAttribute("attendanceDetail",attendanceDetail);
		return "editor";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String detailUI(){
		attendanceDetail=attendanceDetailServices.findObjectById(attendanceDetail.getId());
		request.setAttribute("attendanceDetail", attendanceDetail);
		
		//将选课课号对应的选课的信息推送到前台进行显示
		String[] fields={"selectedcourseno=?"};
		Object[] params={attendanceDetail.getSelectedcourseno()};
		attendanceMaster=(AttendanceMaster) attendanceMasterServices.findObjectByFields(fields, params).get(0);
		request.setAttribute("attendanceMaster", attendanceMaster);
		
		return "detailUI";
	}

	
	//-----------------------getter&setter---------------------------------
	public AttendanceDetail getAttendanceDetail() {
		return attendanceDetail;
	}

	public void setAttendanceDetail(AttendanceDetail attendanceDetail) {
		this.attendanceDetail = attendanceDetail;
	}

	public AttendanceMaster getAttendanceMaster() {
		return attendanceMaster;
	}

	public void setAttendanceMaster(AttendanceMaster attendanceMaster) {
		this.attendanceMaster = attendanceMaster;
	}

	public String getQuery_studentno() {
		return query_studentno;
	}

	public void setQuery_studentno(String query_studentno) {
		this.query_studentno = query_studentno;
	}

	public String getQuery_stuname() {
		return query_stuname;
	}

	public void setQuery_stuname(String query_stuname) {
		this.query_stuname = query_stuname;
	}

	public Timestamp getQuery_attendanceTime() {
		return query_attendanceTime;
	}

	public void setQuery_attendanceTime(Timestamp query_attendanceTime) {
		this.query_attendanceTime = query_attendanceTime;
	}

	public String getQuery_classname() {
		return query_classname;
	}

	public void setQuery_classname(String query_classname) {
		this.query_classname = query_classname;
	}
	
	
	
}
