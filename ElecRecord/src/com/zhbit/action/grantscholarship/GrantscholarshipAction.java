package com.zhbit.action.grantscholarship;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.excel.CouscholarshipExcel;
import com.zhbit.entity.excel.GrantscholarshipExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.couscholarship.CouscholarshipServices;
import com.zhbit.services.grantscholarship.GrantscholarshipServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：GrantscholarshipAction
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月14日 下午9:18:59
 * 修改人：罗吉林
 * 修改时间：2016年6月14日 下午9:18:59
 * 修改备注： 
 * @version 
 */
@Controller("grantscholarshipAction")
@Scope(value="prototype")
public class GrantscholarshipAction extends BaseAndExcelAction{
	GrantScholarship grantScholarship;
	private static final long serialVersionUID = 1L;
	@Resource(name=GrantscholarshipServices.SERVICES_NAME)
	GrantscholarshipServices grantscholarshipServices;
	//注入的Services
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_stuName;
	private String query_orgName;
	private String query_studentNo;
	@Override
	@Limit(url="/grantscholarship/grantscholarship_importExcel.action")
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			ExcelConfig config=new ExcelConfig(GrantscholarshipExcel.class, "国家助学金", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> grantScholarship = excelServicesMake.toDBEnity(lists,GrantScholarship.class);
			//获取创建人
			String creator=RequestUtils.getUserName(request);
            //保存表格里面的数据，在couscholarshipServices重新定义saveFromExcel方法
			grantscholarshipServices.saveFromExcel(grantScholarship,creator);

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
	@Limit(url="/grantscholarship/grantscholarship_listUI.action")
	public String listUI() {
		//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
				if(grantScholarship!=null){
					try {
						grantScholarship.setStuName(DecodeUtils.decodeUTF(grantScholarship.getStuName()));
						grantScholarship.setStudentNo(DecodeUtils.decodeUTF(grantScholarship.getStudentNo()));
						grantScholarship.setOrgName(DecodeUtils.decodeUTF(grantScholarship.getOrgName()));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						System.out.println("编码时出错 ");
				}
				}
				//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
				request.setAttribute("querycon", grantScholarship);
				//设置页面显示信息条数
				setPageSize(2);
				//调用方法，根据查询条件显示数据
				pageUtils=grantscholarshipServices.queryList(grantScholarship, getPageNO(), getPageSize());	
				return "listUI";
	}

	@Override
	@Limit(url="/grantscholarship/grantscholarship_add.action")
	public String addUI() {
		//保存查询条件
				request.setAttribute("querycon", grantScholarship);
				//到数据字典查找类别
				String[] fields={"keyword=?"};
				String[] params1={"学年"};
				String[] params2={"专业"};
				//查找学年
				List<SystemDll> academicYear=systeDllServices.findObjectByFields(fields, params1);
				//查找专业
				List<SystemDll> major=systeDllServices.findObjectByFields(fields, params2);
				//将查询到的信息保存
				request.setAttribute("academicYear", academicYear);
				request.setAttribute("major", major);
				return "addUI";
	}

	@Override
	@Limit(url="/grantscholarship/grantscholarship_add.action")
	public String add() {
		//设定创建时间为当前时间
				Timestamp createtime = new Timestamp(System.currentTimeMillis());
				grantScholarship.setCreateTime(createtime);
				grantscholarshipServices.save(grantScholarship);
				return "add";
	}

	@Override
	@Limit(url="/grantscholarship/grantscholarship_delete.action")
	public String delete() {
		//将listUI界面传过来的查询条件保存
				request.setAttribute("grantScholarship", grantScholarship);
				//判断是否已经选中
				//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
				if(getSelectedRow()!=null){		
					grantscholarshipServices.deleteObjectByIds(getSelectedRow());		
				}
				return "delete";
	}

	@Override
	@Limit(url="/grantscholarship/grantscholarship_editor.action")
	public String editorUI() {
		//到数据字典查找类别
				String[] fields={"keyword=?"};
				String[] params1={"学年"};
				String[] params2={"专业"};
				//查找学年
				List<SystemDll> academicYear=systeDllServices.findObjectByFields(fields, params1);
				//查找专业
				List<SystemDll> major=systeDllServices.findObjectByFields(fields, params2);
				//将查询到的信息保存
				request.setAttribute("academicYear", academicYear);
				request.setAttribute("major", major);
				//将listUI界面传过来的查询条件保存
				request.setAttribute("querycon", grantScholarship);
				//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
				grantScholarship=grantscholarshipServices.findObjectById(grantScholarship.getId());
				//将查询得到的数据返回前台
				request.setAttribute("grantScholarship", grantScholarship);
				return "editorUI";
	}

	@Override
	@Limit(url="/grantscholarship/grantscholarship_editor.action")
	public String editor() {
		//更新数据
		grantscholarshipServices.update(grantScholarship);
				//返回listUI页面的时候 将查询条件也传回列表页面
		grantScholarship.setOrgName(request.getParameter("query_orgName"));
		grantScholarship.setStuName(request.getParameter("query_stuName"));
		grantScholarship.setStudentNo(request.getParameter("query_studentNo"));
		request.setAttribute("grantScholarship",grantScholarship);
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
		grantScholarship=grantscholarshipServices.findObjectById(grantScholarship.getId());
		//将查询得到的数据返回前台
		request.setAttribute("grantScholarship", grantScholarship);
		return "detailUI";
	}
	//------------------------get&set----------------------------
	public GrantScholarship getGrantScholarship() {
		return grantScholarship;
	}

	public void setGrantScholarship(GrantScholarship grantScholarship) {
		this.grantScholarship = grantScholarship;
	}
	public String getQuery_stuName() {
		return query_stuName;
	}

	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}

	public String getQuery_orgName() {
		return query_orgName;
	}

	public void setQuery_orgName(String query_orgName) {
		this.query_orgName = query_orgName;
	}

	public String getQuery_studentNo() {
		return query_studentNo;
	}

	public void setQuery_studentNo(String query_studentNo) {
		this.query_studentNo = query_studentNo;
	}

}
