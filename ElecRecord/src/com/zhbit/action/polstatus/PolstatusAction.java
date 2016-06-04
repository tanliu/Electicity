package com.zhbit.action.polstatus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.User;
import com.zhbit.entity.excel.PolstatusExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.PolstatusTransform;
import com.zhbit.transform.TestTransform;

/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusAction
 * 类描述： 部门模块的Action层
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
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_stuName;
	private String query_studentNo;

		@Override
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
				List<Object> lists=excelServices.parseExcel(config);
				for (Object object : lists) {
					PolstatusExcel polstatusExcel=(PolstatusExcel) object;
					//System.out.println(polstatusExcel.getStudentNo());
				}
				
				//将polstatusExcel的集合转换成Politicalstatus的集合
				List<Object> Polstatus=new PolstatusTransform().toDBEntity(lists);
				//将集合中的对象保存至数据库
				for(Object object:Polstatus){
					Politicalstatus politicalstatus=(Politicalstatus) object;
					polstatusServices.add(politicalstatus);
					//polstatusServices.save(politicalstatus);
			}
				//BaseTransfrom baseTransfrom=new TestTransform();
				//baseTransfrom.toDBEntity(lists);
				//baseTransfrom.toExcelObj(lists);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return "importExcel";
		}
		@Override
		public void exportExcel() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String listUI() {
		
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
			//调用方法，根据查询条件显示数据
			pageUtils=polstatusServices.queryList(politicalstatus, getPageNO(), getPageSize());	
			return "listUI";
			//setPageSize(5);设置页面显示条数
		}
		@Override
		public String addUI() {
			// TODO Auto-generated method stub
			return "addUI";
		}
		@Override
		public String add() {
			//获取当前时间作为createtime列的值并插入数据库
			Timestamp time = new Timestamp(System.currentTimeMillis());
			politicalstatus.setCreateTime(time);
			polstatusServices.add(politicalstatus);//调用services层的add()方法保存数据
			return "add";
		}
		@Override
		public String delete() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String editorUI() {
			//将listUI界面传过来的查询条件保存
			request.setAttribute("querycon", politicalstatus);
			//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
			politicalstatus=polstatusServices.findObjectById(politicalstatus.getId());
			request.setAttribute("politicalstatus", politicalstatus);
			return "editorUI";
		}
		@Override
		public String editor() {
			//直接调用baseDao接口里面的update方法更新修改后的数据
			polstatusServices.update(politicalstatus);
			//返回listUI页面的时候 将查询条件也传回列表页面
			politicalstatus.setStudentNo(request.getParameter("query_studentNo"));
			politicalstatus.setStuName(request.getParameter("query_stuName"));
			request.setAttribute("politicalstatus",politicalstatus);
			return "editor";
		}
		@Override
		public String deleteAll() {
			// TODO Auto-generated method stub
			return null;
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
}
