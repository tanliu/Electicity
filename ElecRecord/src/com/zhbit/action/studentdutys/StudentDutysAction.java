package com.zhbit.action.studentdutys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zhbit.entity.excel.PostinfoExcel;
import com.zhbit.entity.excel.StudentDutysExcel;
import com.zhbit.entity.excel.SubjectContestExcel;
import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Postinfo;
import com.zhbit.entity.StudentDutys;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.User;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.services.subjectcontest.SubjectContestServices;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.services.studentdutys.StudentDutysServices;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.StudentDutysTransfrom;
import com.zhbit.transform.SubjectContestTransfrom;
import com.zhbit.transform.TestTransform;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;
/**
 * 项目名称：ElecRecord
 * 类名称：SubjectContestAction 
 * 类描述： 学科竞赛信息管理Action层
 * 创建人：朱嘉鑫
 * 创建时间：2016年5月28日 下午21:49:05
 * 修改人：zjx 
 * 修改时间：2016年5月28日 下午21:49:05
 * 修改备注： 
 * @version 
 */
@Controller("StudentDutysAction")
@Scope(value="prototype")
public class StudentDutysAction extends BaseAndExcelAction {
	
	StudentDutys studentdutys;
	private String queryWay; //查询的方式
	
	@Resource(name=StudentDutysServices.SERVER_NAME)
	StudentDutysServices studentDutysServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	/* 
	* 方法重写
	* 方法名: listUI 
	* 方法描述: 显示学科竞赛基本信息
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_listUI.action")
	public String listUI() {
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"年级"};
		String[] params2={"学院"};
		String[] params3={"职务"};
		//查找年级
		List<SystemDll> grade=systeDllServices.findObjectByFields(fields, params1);
		//查找学院
		List<SystemDll> college=systeDllServices.findObjectByFields(fields, params2);			
		//查找职务
		List<SystemDll> duty=systeDllServices.findObjectByFields(fields, params3);				
		//将查询到的信息推送到前台显示
		request.setAttribute("Grade", grade);	
		request.setAttribute("College", college);
		request.setAttribute("Duty", duty);
		
		
		//对传来的查询条件进行编码
		if(studentdutys!=null){
			System.out.println("grade="+studentdutys.getGrade());
			System.out.println("College="+studentdutys.getCollege());
			System.out.println("Classname="+studentdutys.getClassName());
			System.out.println("Duty="+studentdutys.getDuty());
			try {
				studentdutys.setGrade(DecodeUtils.decodeUTF(studentdutys.getGrade()));
				studentdutys.setCollege(DecodeUtils.decodeUTF(studentdutys.getCollege()));
				studentdutys.setClassName(DecodeUtils.decodeUTF(studentdutys.getClassName()));
				studentdutys.setDuty(DecodeUtils.decodeUTF(studentdutys.getDuty()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
			}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", studentdutys);
		setPageSize(8);
		pageUtils=studentDutysServices.queryList(studentdutys, getPageNO(),getPageSize());	
		//pageUtils=studentDutysServices.queryList(studentDutys, getPageNO(), getPageSize());
		
		//pageUtils=studentDutysServices.getPageUtils(null, null, null, QueryUtils.ORDER_BY_ASC, getPageNO(), 5);
		return "listUI";
	}

	/* 
	* 方法重写
	* 方法名: addUI 
	* 方法描述:跳转到添加信息页面 
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_add.action")
	public String addUI() {
				//到数据字典查找类别
				String[] fields={"keyword=?"};
				String[] params1={"年级"};
				String[] params2={"学院"};
				String[] params3={"职务"};
				//查找年级
				List<SystemDll> grade=systeDllServices.findObjectByFields(fields, params1);
				//查找学院
				List<SystemDll> college=systeDllServices.findObjectByFields(fields, params2);			
				//查找职务
				List<SystemDll> duty=systeDllServices.findObjectByFields(fields, params3);				
				//将查询到的信息推送到前台显示
				request.setAttribute("Grade", grade);	
				request.setAttribute("College", college);
				request.setAttribute("Duty", duty);
				
		return "addUI";
	}

	/* 
	* 方法重写
	* 方法名: add 
	* 方法描述:保存添加信息
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_add.action")
	public String add() {
		//设置学号
		studentdutys.setStudentNo("123");
		studentDutysServices.save(studentdutys);
		return "add";
	}

	/* 
	* 方法重写
	* 方法名: delete 
	* 方法描述:删除信息
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_delete.action")
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			studentDutysServices.deleteObjectByIds(selectedRow);
		}
			
		return "delete";
	}

	/* 
	* 方法重写
	* 方法名: editorUI 
	* 方法描述: 跳转到编辑信息页面
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_editor.action")
	public String editorUI() {
		//将listUI界面传过来的查询条件保存
		System.out.println("editorUI_duty="+studentdutys.getDuty());
				request.setAttribute("querycon", studentdutys);
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"年级"};
		String[] params2={"学院"};
		String[] params3={"职务"};
		//查找年级
		List<SystemDll> grade=systeDllServices.findObjectByFields(fields, params1);
		//查找学院
		List<SystemDll> college=systeDllServices.findObjectByFields(fields, params2);			
		//查找职务
		List<SystemDll> duty=systeDllServices.findObjectByFields(fields, params3);				
		//将查询到的信息推送到前台显示
		request.setAttribute("Grade", grade);	
		request.setAttribute("College", college);
		request.setAttribute("Duty", duty);
		//查找要编辑的实体
		studentdutys = studentDutysServices.findObjectById(studentdutys.getId());
		request.setAttribute("studentdutys", studentdutys);
		return "editorUI";
	}

	/* 
	* 方法重写
	* 方法名: editor 
	* 方法描述: 保存编辑后的信息
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_editor.action")
	public String editor() {		
		
		//设置学号
		//studentdutys.setStudentNo("123");
		studentDutysServices.update(studentdutys);
	
		studentdutys.setGrade(request.getParameter("query_grade"));
		studentdutys.setCollege(request.getParameter("query_college"));
		studentdutys.setClassName(request.getParameter("query_className"));
		studentdutys.setDuty(request.getParameter("query_duty"));
		
		System.out.println("editor_duty="+studentdutys.getDuty());
		request.setAttribute("studentdutys",studentdutys);
		return "editor";
	}

	/* 
	* 方法重写
	* 方法名: deleteAll 
	* 方法描述: 删除选中的条目
	* @return       
	*/
	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	* 方法重写
	* 方法名: detailUI 
	* 方法描述: 显示详情
	* @return       
	*/
	
	public String detailUI() {
		if(studentdutys==null){
			System.out.println("空");
		}
		
		System.out.println("我的ID是："+studentdutys.getId());
		studentdutys = studentDutysServices.findObjectById(studentdutys.getId());
		//request.setAttribute("studentDutys", studentdutys);
		return "detailUI";
	}

	/* 
	* 方法重写
	* 方法名: importExcel 
	* 方法描述: 导入Excel
	* @return       
	*/
	@Override
	@Limit(url="/studentdutys/studentdutys_importExcel.action")
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			ExcelConfig config=new ExcelConfig(StudentDutysExcel.class, "sheet1", 1, new FileInputStream(excel),excelFileName);
			List<Object> lists=excelServicesMake.parseExcel(config);
			
			Map<String, String> viladationExcel = excelServicesMake.viladationExcel(lists);
			//对数据的校验
			if(viladationExcel.size()>0){
				for (Iterator<Entry<String, String>> iterator=viladationExcel.entrySet().iterator();iterator.hasNext();) {
					Entry<String, String> entry=iterator.next();
					this.addActionError(entry.getKey()+":"+entry.getValue());
				}
				//出错
				return "excelError";
			}
			
			//数据的转换
			List<Object> studentdutys = excelServicesMake.toDBEnity(lists,StudentDutys.class);
			
			String creator=RequestUtils.getUserName(request);
			studentDutysServices.saveFromExcel(studentdutys,creator);
			
		
//			BaseTransfrom studentDutysTransfrom=new StudentDutysTransfrom();
//			List<Object> list=studentDutysTransfrom.toDBEntity(lists);
//			for (int i=0;i<list.size();i++) {
//				StudentDutys sd=(StudentDutys)list.get(i);
//				studentDutysServices.save(sd);
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "excelSuccess";
		
	}

	/* 
	* 方法重写
	* 方法名: exportExcel 
	* 方法描述:导出Excel     
	*/
	@Override
	public void exportExcel() {
		List<StudentDutysExcel> Excellist=new ArrayList<StudentDutysExcel>();
		List<StudentDutys> stdlist;
		if(selectedRow!=null){
			stdlist=studentDutysServices.queryListDownload(selectedRow);
		}else{
			stdlist=studentDutysServices.queryAllList();
		}
		//查询选中的Subjectcontest
		
		System.out.println("sublist.size()="+stdlist.size());
		BaseTransfrom baseTransfrom=new StudentDutysTransfrom();
		List<Object> list=baseTransfrom.toExcelObj(stdlist);
		System.out.println("list.size()="+list.size());
		for(int i=0;i<list.size();i++){
			StudentDutysExcel excel=(StudentDutysExcel)list.get(i);
			System.out.println("名字="+excel.getStuName());
			Excellist.add(excel);
		}
		System.out.println("Excellist.size()="+Excellist.size());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/x-execl");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+new String("学生职务信息表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream=response.getOutputStream();
			ExcelConfig config=new ExcelConfig(StudentDutysExcel.class, "sheet1", outputStream);
			config.setEntitys(Excellist);
			excelServices.createExcel(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//-------------------------getter&&setter-----------------------

	
	public String getQueryWay() {
		return queryWay;
	}

	public void setQueryWay(String queryWay) {
		this.queryWay = queryWay;
	}


	public StudentDutys getStudentdutys() {
		return studentdutys;
	}

	public void setStudentdutys(StudentDutys studentdutys) {
		this.studentdutys = studentdutys;
	}



}