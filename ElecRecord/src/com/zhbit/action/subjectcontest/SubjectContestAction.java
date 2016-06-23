package com.zhbit.action.subjectcontest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zhbit.entity.excel.StuExcel;
import com.zhbit.entity.excel.SubjectContestExcel;
import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Student;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.User;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.services.subjectcontest.SubjectContestServices;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.transform.BaseTransfrom;
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
@Controller("subjectContestAction")
@Scope(value="prototype")
public class SubjectContestAction extends BaseAndExcelAction {
	
	Subjectcontest subjectcontest;
	private String queryWay; //查询的方式
	private String stuNo;
	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	List<String> dellist;
	
	@Resource(name=SubjectContestServices.SERVER_NAME)
	SubjectContestServices subjectContestServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	/* 
	* 方法重写
	* 方法名: listUI 
	* 方法描述: 显示学科竞赛基本信息
	* @return       
	*/
	@Override
	@Limit(url="/subjectcontest/subjectcontest_listUI.action")
	public String listUI() {
		//对传来的查询条件进行编码
		if(subjectcontest!=null){
			try {
				//判断是否是学生，如果是学生的话，就把查询条件强加
				subjectcontest.setStuName(RequestUtils.checkStudentAuthority(request,subjectcontest.getStuName()));
				
				subjectcontest.setStuName(DecodeUtils.decodeUTF(subjectcontest.getStuName()));
				subjectcontest.setStudentNo(DecodeUtils.decodeUTF(subjectcontest.getStudentNo()));
				subjectcontest.setGrantUnits(DecodeUtils.decodeUTF(subjectcontest.getGrantUnits()));
				subjectcontest.setRewardName(DecodeUtils.decodeUTF(subjectcontest.getRewardName()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
			}
		}
		
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", subjectcontest);
		setPageSize(8);
		pageUtils=subjectContestServices.queryList(subjectcontest, getPageNO(),getPageSize());	
		//pageUtils=subjectContestServices.queryList(subjectcontest, getPageNO(), getPageSize());
		
		
	//	pageUtils=subjectContestServices.getPageUtils(null, null, null, QueryUtils.ORDER_BY_ASC, getPageNO(), 5);
		return "listUI";
	}

	/* 
	* 方法重写
	* 方法名: addUI 
	* 方法描述:跳转到添加信息页面 
	* @return       
	*/
	@Override
	@Limit(url="/subjectcontest/subjectcontest_add.action")
	public String addUI() {
		//到数据字典查找类别
			String[] fields={"keyword=?"};
			String[] params1={"奖励等级"};
			String[] params2={"奖励级别"};
		//查找奖励等级
			List<SystemDll> grade=systeDllServices.findObjectByFields(fields, params1);
		//查找奖励级别
			List<SystemDll> level=systeDllServices.findObjectByFields(fields, params2);					
		//将查询到的信息推送到前台显示
				request.setAttribute("rewardGrade", grade);	
				request.setAttribute("rewardLevel", level);
		return "addUI";
	}

	/* 
	* 方法重写
	* 方法名: add 
	* 方法描述:保存添加信息
	* @return       
	*/
	@Override
	@Limit(url="/subjectcontest/subjectcontest_add.action")
	public String add() {
		//设置创建时间 
		subjectcontest.setCreateTime(new Timestamp(new Date().getTime()));
		subjectcontest.setCreator(RequestUtils.getUserName(request));
		subjectContestServices.save(subjectcontest);
		return "add";
	}

	/* 
	* 方法重写
	* 方法名: delete 
	* 方法描述:删除信息
	* @return       
	*/
	@Override
	@Limit(url="/subjectcontest/subjectcontest_delete.action")
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			subjectContestServices.deleteObjectByIds(selectedRow);
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
	@Limit(url="/subjectcontest/subjectcontest_editor.action")
	public String editorUI() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("querycon", subjectcontest);
		
		// 到数据字典查找类别
		String[] fields = { "keyword=?" };
		String[] params1 = { "奖励等级" };
		String[] params2 = { "奖励级别" };
		// 查找奖励等级
		List<SystemDll> grade = systeDllServices.findObjectByFields(fields, params1);
		// 查找奖励级别
		List<SystemDll> level = systeDllServices.findObjectByFields(fields, params2);
		// 将查询到的信息推送到前台显示
		request.setAttribute("rewardGrade", grade);
		request.setAttribute("rewardLevel", level);
		// 通过传过来的参数值获取对应的学籍信息
		subjectcontest = subjectContestServices.findObjectById(subjectcontest.getId());
		request.setAttribute("subjectcontest", subjectcontest);
		return "editorUI";
	}

	/* 
	* 方法重写
	* 方法名: editor 
	* 方法描述: 保存编辑后的信息
	* @return       
	*/
	@Override
	@Limit(url="/subjectcontest/subjectcontest_editor.action")
	public String editor() {
		subjectContestServices.update(subjectcontest);
		
		subjectcontest.setStudentNo(request.getParameter("query_studentNo"));
		subjectcontest.setStuName(request.getParameter("query_stuName"));
		subjectcontest.setGrantUnits(request.getParameter("query_grantUnits"));
		subjectcontest.setRewardName(request.getParameter("query_rewardName"));
		
		request.setAttribute("subjectcontest",subjectcontest);
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
		subjectcontest = subjectContestServices.findObjectById(subjectcontest.getId());
		//request.setAttribute("subjectcontest", subjectcontest);
		return "detailUI";
	}

	//-------------------------getter&&setter-----------------------

	public Subjectcontest getSubjectcontest() {
		return subjectcontest;
	}

	public void setSubjectcontest(Subjectcontest subjectcontest) {
		this.subjectcontest = subjectcontest;
	}

	public String getQueryWay() {
		return queryWay;
	}

	public void setQueryWay(String queryWay) {
		this.queryWay = queryWay;
	}

	/**
	 * 方法描述:数据唯一性校验
	 * @return
	 */
	public String hasStudent(){
		//根据学号返回姓名
		if(subjectcontest!=null&&!StringUtils.isBlank(subjectcontest.getStudentNo())){
			if(subjectContestServices.hasStudent(subjectcontest.getStudentNo())){
				Student student = studentServices.getStudentByNo(subjectcontest.getStudentNo());
				if(student!=null){
					try {
						String string=student.getStuName();
						string=URLEncoder.encode(string, "UTF-8");
						request.setCharacterEncoding("utf-8");
						AjaxReturnUtils.returnResult(response,string);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					AjaxReturnUtils.returnResult(response,null);
				}
			}
		}
		//AjaxReturnUtils.returnResult(response, result);
		
		return null;
	}
	@Override
	@Limit(url="/subjectcontest/subjectcontest_importExcel.action")	
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			
			ExcelConfig config=new ExcelConfig(SubjectContestExcel.class, "sheet1", 1,new FileInputStream(excel),excelFileName);
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
			List<Object> students = excelServicesMake.toDBEnity(lists,Subjectcontest.class);
			
			String creator=RequestUtils.getUserName(request);
			subjectContestServices.saveFromExcel(students,creator);
			
//			BaseTransfrom subjectContestTransfrom=new SubjectContestTransfrom();
//			List<Object> list=subjectContestTransfrom.toDBEntity(lists);
//			for (int i=0;i<list.size();i++) {
//				Subjectcontest st=(Subjectcontest)list.get(i);
//				System.out.println("学号="+st.getStudentNo());
//				subjectContestServices.save(st);
//			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "excelSuccess";
		
	}

	@Override
	public void exportExcel() {
		List<SubjectContestExcel> Excellist=new ArrayList<SubjectContestExcel>();
		List<Subjectcontest> sublist;
		if(selectedRow!=null){
			sublist=subjectContestServices.queryListDownload(selectedRow);
		}else{
			sublist=subjectContestServices.queryAllList();
		}
		//查询选中的Subjectcontest
		
		System.out.println("sublist.size()="+sublist.size());
		BaseTransfrom baseTransfrom=new SubjectContestTransfrom();
		List<Object> list=baseTransfrom.toExcelObj(sublist);
		System.out.println("list.size()="+list.size());
		for(int i=0;i<list.size();i++){
			SubjectContestExcel excel=(SubjectContestExcel)list.get(i);
			System.out.println("名字="+excel.getStuName());
			Excellist.add(excel);
		}
		System.out.println("Excellist.size()="+Excellist.size());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/x-execl");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+new String("学科竞赛表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream=response.getOutputStream();
			ExcelConfig config=new ExcelConfig(SubjectContestExcel.class, "国家级", outputStream);
			config.setEntitys(Excellist);
			excelServices.createExcel(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<String> getDellist() {
		return dellist;
	}

	public void setDellist(List<String> dellist) {
		this.dellist = dellist;
	}
	
}