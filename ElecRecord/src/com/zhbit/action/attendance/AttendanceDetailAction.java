package com.zhbit.action.attendance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.entity.Student;
import com.zhbit.entity.Tutor;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.AttendExcelImpl;
import com.zhbit.services.attendence.AttendanceDetailServices;
import com.zhbit.services.attendence.AttendanceMasterServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

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
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;

	@Override
	@Limit(url="/attendancedetail/attendancedetail_importExcel.action")
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
					String[] fields={"selectedcourseno=?"};
					String[] params={attendanceMaster.getSelectedcourseno()};
					if(attendanceMasterServices.findObjectByFields(fields, params)==null){//当记录不存在时，才进行保存操作
					//设定创建时间为当前时间
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					attendanceMaster.setCreateTime(createtime);
					attendanceMaster=attendanceMasterServices.trimAttendanceMaster(attendanceMaster);
					//保存该记录至数据库中
					attendanceMasterServices.save(attendanceMaster);
					}
				}else {
					
					if(objects.get(i)!=null){
						AttendanceDetail attendanceDetail=(AttendanceDetail)objects.get(i);
						
					    String[] fields={"selectedcourseno=?","studentno=?","attendanceTime=?"};
						Object[] params={attendanceDetail.getSelectedcourseno(),attendanceDetail.getStudentno(),attendanceDetail.getAttendanceTime()};
						
						if(attendanceDetailServices.findObjectByFields(fields, params)==null&&attendanceDetail.getAttendanceStatus()!=null){//当学号、选课课号、考勤时间对应查询出来的记录为空且考勤状态不为空时，才进行加入集合的操作
						//设定创建时间为当前时间
						Timestamp createtime = new Timestamp(System.currentTimeMillis());
						attendanceDetail.setCreateTime(createtime);
						//通过学生学号找到学生并得到其对应的stu_id
						Student student=studentServices.getStudentByNo(attendanceDetail.getStudentno());
						
						if(student!=null){//若得到的Student不为空，进行stu_id的设定
							attendanceDetail.setStuId(student.getStuId());
						}
						
						attendanceDetail=attendanceDetailServices.trimAttendanceDetail(attendanceDetail);
						
						//将该数据保存至相对应的AttendanceDetail集合中
						attendanceDetails.add(attendanceDetail);
						}
						
					}
					
				}
				
			}
			
			if(attendanceDetails.size()>=1){//记录数大于1时，才进行保存操作
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
	@Limit(url="/attendancedetail/attendancedetail_listUI.action")
	public String listUI() {
		// TODO Auto-generated method stub
		
		//对传来的查询条件进行编码
		if(attendanceDetail!=null){
			//判断是否是学生，如果是，则将其输入的学号强转为他本人的学号
			attendanceDetail.setStudentno(RequestUtils.checkStudentAuthority(request, attendanceDetail.getStudentno()));
			
			try {
				attendanceDetail.setStudentno(DecodeUtils.decodeUTF(attendanceDetail.getStudentno()));
				attendanceDetail.setStuname(DecodeUtils.decodeUTF(attendanceDetail.getStuname()));
				attendanceDetail.setClassname(DecodeUtils.decodeUTF(attendanceDetail.getClassname()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
	
		Student student=(Student) request.getSession().getAttribute("student");
		if(student!=null){
			attendanceDetail=new AttendanceDetail();
			attendanceDetail.setStudentno(student.getStudentNo());
			attendanceDetail.setStuname(student.getStuName());		
			attendanceDetail.setClassname(student.getClassName());
		}
		
		//将传过来的参数进行回显
		request.setAttribute("queryCon",attendanceDetail);
		setPageSize(9);

		pageUtils=attendanceDetailServices.queryList(attendanceDetail, getPageNO(), getPageSize());
		return "listUI";
	}

	@Override
	@Limit(url="/attendancedetail/attendancedetail_add.action")
	public String addUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", attendanceDetail);
		
		return "addUI";
	}

	@Override
	@Limit(url="/attendancedetail/attendancedetail_add.action")
	public String add() {
		// TODO Auto-generated method stub
		//先去除存在的空格，再进行存储
		attendanceDetailServices.trimAttendanceDetail(attendanceDetail);
		if(attendanceDetail!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			attendanceDetail.setCreateTime(createtime);
			//通过学号查找相应的对象从而得到其对应的Stu_id
			
			Student student=studentServices.getStudentByNo(attendanceDetail.getStudentno());
			
			if(student!=null){
				attendanceDetail.setStuId(student.getStuId());
			}
			
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
	@Limit(url="/attendancedetail/attendancedetail_delete.action")
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
	@Limit(url="/attendancedetail/attendancedetail_editor.action")
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
	@Limit(url="/attendancedetail/attendancedetail_editor.action")
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
