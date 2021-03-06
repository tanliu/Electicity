package com.zhbit.action.loanscholarship;

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

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.entity.LoanScholarship;
import com.zhbit.entity.Student;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.excel.GrantscholarshipExcel;
import com.zhbit.entity.excel.LoanscholarshipExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.loanscholarship.LoanscholarshipServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoanscholarshipAction
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月15日 下午4:42:44
 * 修改人：罗吉林
 * 修改时间：2016年6月15日 下午4:42:44
 * 修改备注： 
 * @version 
 */
@Controller("loanscholarshipAction")
@Scope(value="prototype")
public class LoanscholarshipAction extends BaseAndExcelAction{
	LoanScholarship loanscholarship;
	private static final long serialVersionUID = 1L;
	@Resource(name=LoanscholarshipServices.SERVICES_NAME)
	LoanscholarshipServices loanscholarshipServices;
	//注入的Services
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_stuName;
	private String query_censoredFlag;
	private String query_studentNo;
	@Override
	@Limit(url="/loanscholarship/loanscholarship_importExcel.action")
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			ExcelConfig config=new ExcelConfig(LoanscholarshipExcel.class, "国家助学贷款", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> loanscholarship = excelServicesMake.toDBEnity(lists,LoanScholarship.class);
			//获取创建人
			String creator=RequestUtils.getUserName(request);
            //保存表格里面的数据，在couscholarshipServices重新定义saveFromExcel方法
			loanscholarshipServices.saveFromExcel(loanscholarship,creator);

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
	@Limit(url="/loanscholarship/loanscholarship_listUI.action")
	public String listUI() {
		Student student=(Student) request.getSession().getAttribute("student");
		if(loanscholarship==null&&student!=null){
			loanscholarship=new LoanScholarship();
			loanscholarship.setStuName(RequestUtils.checkStudentName(request, loanscholarship.getStuName()==null?"":loanscholarship.getStuName()));
		}
		//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
		if(loanscholarship!=null){
			//判断是否是学生，如果是，则将其输入的学号强转为他本人的学号
			loanscholarship.setStuName(RequestUtils.checkStudentName(request, loanscholarship.getStuName()));
			try {
				if(!StringUtils.isBlank(loanscholarship.getStuName())){
				loanscholarship.setStuName(DecodeUtils.decodeUTF(loanscholarship.getStuName()));
				}
				if(!StringUtils.isBlank(loanscholarship.getStudentNo())){
				loanscholarship.setStudentNo(DecodeUtils.decodeUTF(loanscholarship.getStudentNo()));
				}
				if(!StringUtils.isBlank(loanscholarship.getCensoredFlag())){
				loanscholarship.setCensoredFlag(DecodeUtils.decodeUTF(loanscholarship.getCensoredFlag()));
				}
				} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错 ");
		}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", loanscholarship);
		//设置页面显示信息条数
		setPageSize(6);
		//调用方法，根据查询条件显示数据
		pageUtils=loanscholarshipServices.queryList(loanscholarship, getPageNO(), getPageSize());	
		return "listUI";
	}

	@Override
	@Limit(url="/loanscholarship/loanscholarship_add.action")
	public String addUI() {
		//保存查询条件
		request.setAttribute("querycon", loanscholarship);
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
	@Limit(url="/loanscholarship/loanscholarship_add.action")
	public String add() {
		//获取学生的学号,将学号赋给CommonScholarship实体。
				Student student=studentServices.getStudentByNo(loanscholarship.getStudentNo());
				loanscholarship.setStuId(student.getStuId());
				//获取创建人
				String creator=RequestUtils.getUserName(request);
				loanscholarship.setCreator(creator);
		//设定创建时间为当前时间
		Timestamp createtime = new Timestamp(System.currentTimeMillis());
		loanscholarship.setCreateTime(createtime);
		loanscholarshipServices.save(loanscholarship);
		return "add";
	}

	@Override
	@Limit(url="/loanscholarship/loanscholarship_delete.action")
	public String delete() {
		//将listUI界面传过来的查询条件保存
				request.setAttribute("loanscholarship", loanscholarship);
				//判断是否已经选中
				//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
				if(getSelectedRow()!=null){		
					loanscholarshipServices.deleteObjectByIds(getSelectedRow());		
				}
				return "delete";
	}

	@Override
	@Limit(url="/loanscholarship/loanscholarship_editor.action")
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
		request.setAttribute("querycon", loanscholarship);
		//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
		loanscholarship=loanscholarshipServices.findObjectById(loanscholarship.getId());
		//将查询得到的数据返回前台
		request.setAttribute("loanscholarship", loanscholarship);
		return "editorUI";
	}

	@Override
	@Limit(url="/loanscholarship/loanscholarship_editor.action")
	public String editor() {
		//更新数据
		loanscholarshipServices.update(loanscholarship);
				//返回listUI页面的时候 将查询条件也传回列表页面
		loanscholarship.setStudentNo(request.getParameter("query_studentNo"));
		loanscholarship.setStuName(request.getParameter("query_stuName"));
		loanscholarship.setCensoredFlag(request.getParameter("query_censoredFlag"));
		request.setAttribute("loanscholarship",loanscholarship);
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
		loanscholarship=loanscholarshipServices.findObjectById(loanscholarship.getId());
		//将查询得到的数据返回前台
		request.setAttribute("loanscholarship", loanscholarship);
		return "detailUI";
	}
//---------------------get&set-------------------------------------

	

	public String getQuery_stuName() {
		return query_stuName;
	}

	
	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}

	public String getQuery_censoredFlag() {
		return query_censoredFlag;
	}

	public void setQuery_censoredFlag(String query_censoredFlag) {
		this.query_censoredFlag = query_censoredFlag;
	}

	public String getQuery_studentNo() {
		return query_studentNo;
	}

	public void setQuery_studentNo(String query_studentNo) {
		this.query_studentNo = query_studentNo;
	}

	public LoanScholarship getLoanscholarship() {
		return loanscholarship;
	}

	public void setLoanscholarship(LoanScholarship loanscholarship) {
		this.loanscholarship = loanscholarship;
	}
	

	
}
