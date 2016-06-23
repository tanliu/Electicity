package com.zhbit.action.polstatus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.Student;
import com.zhbit.entity.User;
import com.zhbit.entity.excel.PolstatusExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.PolstatusTransform;
import com.zhbit.transform.TestTransform;

/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusAction
 * 类描述： 党团关系模块的Action层
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:04:48
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:04:48
 * 修改备注： 
 * @version 
 */
@Controller("polstatusAction")
@Scope(value="prototype")
public class PolstatusAction extends BaseAndExcelAction{
	Politicalstatus politicalstatus;
	private static final long serialVersionUID = 1L;
	@Resource(name=PolstatusServices.SERVICES_NAME)
	PolstatusServices polstatusServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_stuName;
	private String query_studentNo;
	private Timestamp query_joinDate;
	
		@Override
		@Limit(url="/polstatus/polstatus_importExcel.action")
		public String importExcel() {
			// TODO Auto-generated method stub
			try {
				/**
				 * arg01:excel实体
				 * arg02:表名
				 * arg03:表头的位置
				 * arg04:上传文件的输入流
				 * arg05:文件名
				 */
				ExcelConfig config=new ExcelConfig(PolstatusExcel.class, "党团关系", 1, new FileInputStream(excel),excelFileName);
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
				List<Object> politicalstatus = excelServicesMake.toDBEnity(lists,Politicalstatus.class);
				//获取创建人
				String creator=RequestUtils.getUserName(request);
	            //保存表格里面的数据，在polstatusServices重新定义saveFromExcel方法
				
				polstatusServices.saveFromExcel(politicalstatus,creator);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return "excelSuccess";
		}
		@Override
		public void exportExcel() {
			// TODO Auto-generated method stub
			
		}
		@Override
		@Limit(url="/polstatus/polstatus_listUI.action")
		public String listUI() {
			//判断是否是学生，如果是学生的话，就把查询条件强加
			query_studentNo=RequestUtils.checkStudentAuthority(request,query_studentNo);
			//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
			if(politicalstatus!=null){
				try {
					politicalstatus.setStuName(DecodeUtils.decodeUTF(politicalstatus.getStuName()));
					politicalstatus.setStudentNo(DecodeUtils.decodeUTF(politicalstatus.getStudentNo()));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					System.out.println("编码时出错 ");
			}
			}
			//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
			request.setAttribute("querycon", politicalstatus);
			//设置页面显示信息条数
			setPageSize(2);
			//调用方法，根据查询条件显示数据
			pageUtils=polstatusServices.queryList(politicalstatus, getPageNO(), getPageSize());	
			return "listUI";
			//setPageSize(5);设置页面显示信息条数 可以直接写getPageSize()，则默认为2条信息每页，也可以手动写数字，比如5，则为5条信息
		}
		@Override
		@Limit(url="/polstatus/polstatus_add.action")
		public String addUI() {
			// TODO Auto-generated method stub
			//保存查询条件
			request.setAttribute("querycon", politicalstatus);
			return "addUI";
		}
		@Override
		@Limit(url="/polstatus/polstatus_add.action")
		public String add() {
			//获取学生的学号,将学号赋给CommonScholarship实体。
			Student student=studentServices.getStudentByNo(politicalstatus.getStudentNo());
			politicalstatus.setStuId(student.getStuId());
			//获取创建人
			String creator=RequestUtils.getUserName(request);
			politicalstatus.setCreator(creator);
			//获取当前时间作为createtime列的值并插入数据库
			Timestamp time = new Timestamp(System.currentTimeMillis());
			politicalstatus.setCreateTime(time);
			polstatusServices.add(politicalstatus);//调用services层的add()方法保存数据
			return "add";
		}
		@Override
		@Limit(url="/polstatus/polstatus_delete.action")
		public String delete() {
			// TODO Auto-generated method stub
			//将listUI界面传过来的查询条件保存
			request.setAttribute("politicalstatus", politicalstatus);
			//判断是否已经选中
			//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
			if(getSelectedRow()!=null){		
				polstatusServices.deleteObjectByIds(getSelectedRow());		
			}
			return "delete";
		}
		@Override
		@Limit(url="/polstatus/polstatus_editor.action")
		public String editorUI() {
			//将listUI界面传过来的查询条件保存
			request.setAttribute("querycon", politicalstatus);
			//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
			politicalstatus=polstatusServices.findObjectById(politicalstatus.getId());
			//将查询得到的数据返回前台
			request.setAttribute("politicalstatus", politicalstatus);
			return "editorUI";
		}
		@Override
		@Limit(url="/polstatus/polstatus_editor.action")
		public String editor() {
			//直接调用baseDao接口里面的update方法更新修改后的数据
			polstatusServices.update(politicalstatus);
			//返回listUI页面的时候 将查询条件也传回列表页面
			//politicalstatus.setStudentNo(request.getParameter("query_studentNo"));
			//politicalstatus.setStuName(request.getParameter("query_stuName"));
			politicalstatus.setStudentNo(getQuery_studentNo());
			politicalstatus.setStuName(getQuery_stuName());
			politicalstatus.setJoinDate(getQuery_joinDate());
			request.setAttribute("politicalstatus",politicalstatus);
			return "editor";
		}
		@Override
		public String deleteAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public String detailUI(){
			//将listUI界面传过来的查询条件保存
			//request.setAttribute("querycon", politicalstatus);
			//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
			politicalstatus=polstatusServices.findObjectById(politicalstatus.getId());
			//将查询得到的数据返回前台
			request.setAttribute("politicalstatus", politicalstatus);
			return "detailUI";
		}
		
		//--------------------------实体类getter&setter--------------------
		public Politicalstatus getPoliticalstatus() {
			return politicalstatus;
		}
		public void setPoliticalstatus(Politicalstatus politicalstatus) {
			this.politicalstatus = politicalstatus;
		}
		public String getQuery_stuName() {
			return query_stuName;
		}
		public void setQuery_stuName(String query_stuName) {
			this.query_stuName = query_stuName;
		}
		public String getQuery_studentNo() {
			return query_studentNo;
		}
		public void setQuery_studentNo(String query_studentNo) {
			this.query_studentNo = query_studentNo;
		}
		public Timestamp getQuery_joinDate() {
			return query_joinDate;
		}
		public void setQuery_joinDate(Timestamp query_joinDate) {
			this.query_joinDate = query_joinDate;
		}
}
