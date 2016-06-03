package com.zhbit.action.SubjectContest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.text.entity.excel.SubjectContestExcel;
import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.Organization;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.User;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.services.SubjectContest.SubjectContestServices;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.SubjectContestTransfrom;
import com.zhbit.transform.TestTransform;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.QueryUtils;
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
	/* 
	* 方法重写
	* 方法名: listUI 
	* 方法描述: 显示学科竞赛基本信息
	* @return       
	*/
	@Override
	public String listUI() {
		//对传来的查询条件进行编码
		if(subjectcontest!=null){
			try {
				subjectcontest.setStuName(DecodeUtils.decodeUTF(subjectcontest.getStuName()));
				subjectcontest.setStudentNo(DecodeUtils.decodeUTF(subjectcontest.getStudentNo()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", subjectcontest);
		pageUtils=subjectContestServices.queryList(subjectcontest, getPageNO(),5);	
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
	public String add() {
		//设置创建时间 
		subjectcontest.setCreateTime(new Timestamp(new Date().getTime()));
		subjectcontest.setCreator("朱嘉鑫");
		System.out.println("Name="+subjectcontest.getStuName());
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
	public String delete() {
		System.out.println("选中size="+selectedRow.length);
			System.out.println("选中ID="+selectedRow.toString());
		
		subjectContestServices.deleteObjectByIds(selectedRow);
		return "delete";
	}

	/* 
	* 方法重写
	* 方法名: editorUI 
	* 方法描述: 跳转到编辑信息页面
	* @return       
	*/
	@Override
	public String editorUI() {
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
	public String editor() {		
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		subjectcontest.setCreateTime(time);
		subjectcontest.setCreator("朱嘉鑫");
		subjectContestServices.update(subjectcontest);
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

	@Override
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			System.out.println("我在这里，看见了吗？？？？？？");
			
			ExcelConfig config=new ExcelConfig(SubjectContestExcel.class, "国家级", 3, new FileInputStream(excel),excelFileName);
			List<Object> lists=excelServices.parseExcel(config);
			System.out.println("我有"+lists.size()+"行");
			for(Object object:lists){
				SubjectContestExcel subjectContestExcel=(SubjectContestExcel)object;
				System.out.println("time===="+subjectContestExcel.getRewardDate());
			}
			BaseTransfrom subjectContestTransfrom=new SubjectContestTransfrom();
			List<Object> list=subjectContestTransfrom.toDBEntity(lists);
			for (int i=0;i<list.size();i++) {
				Subjectcontest st=(Subjectcontest)list.get(i);
				subjectContestServices.save(st);
			}
			
			//baseTransfrom.toExcelObj(lists);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "importExcel";
		
	}

	@Override
	public void exportExcel() {
		List<SubjectContestExcel> Excellist=new ArrayList<SubjectContestExcel>();
		System.out.println("选中size="+selectedRow.length);
		System.out.println("选中ID="+selectedRow.toString());
		//查询选中的Subjectcontest
		List<Subjectcontest> sublist=subjectContestServices.queryListDownload(selectedRow);
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
