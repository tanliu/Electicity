package com.zhbit.action.comscholarship;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.CommonScholarship;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.comscholarship.ComscholarshipServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.DecodeUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：ComscholarshipAction
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月12日 下午7:29:10
 * 修改人：罗吉林
 * 修改时间：2016年6月12日 下午7:29:10
 * 修改备注： 
 * @version 
 */
@Controller("comscholarshipAction")
@Scope(value="prototype")
public class ComscholarshipAction extends BaseAndExcelAction{
	CommonScholarship commonScholarship;
	private static final long serialVersionUID = 1L;
	@Resource(name=ComscholarshipServices.SERVICES_NAME)
	ComscholarshipServices comscholarshipServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_stuName;
	private String query_major;
	private String query_rewardName;
	
	@Override
	public String importExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listUI() {
		String[] fields={"keyword=?"};
		String[] params2={"专业"};
		//查找专业
		List<SystemDll> major=systeDllServices.findObjectByFields(fields, params2);
		request.setAttribute("major", major);
		//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
		if(commonScholarship!=null){
			try {
				commonScholarship.setStuName(DecodeUtils.decodeUTF(commonScholarship.getStuName()));
				commonScholarship.setRewardName(DecodeUtils.decodeUTF(commonScholarship.getRewardName()));
				commonScholarship.setMajor(DecodeUtils.decodeUTF(commonScholarship.getMajor()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错 ");
		}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", commonScholarship);
		//设置页面显示信息条数
		setPageSize(2);
		//调用方法，根据查询条件显示数据
		pageUtils=comscholarshipServices.queryList(commonScholarship, getPageNO(), getPageSize());	
		return "listUI";
		//setPageSize(5);设置页面显示信息条数 可以直接写getPageSize()，则默认为2条信息每页，也可以手动写数字，比如5，则为5条信息
	}

	@Override
	public String addUI() {
		//保存查询条件
		request.setAttribute("querycon", commonScholarship);
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
	public String add() {
		//设定创建时间为当前时间
		Timestamp createtime = new Timestamp(System.currentTimeMillis());
		commonScholarship.setCreateTime(createtime);
		comscholarshipServices.save(commonScholarship);
		return "add";
	}

	@Override
	public String delete() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("commonScholarship", commonScholarship);
		//判断是否已经选中
		//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
		if(getSelectedRow()!=null){		
			comscholarshipServices.deleteObjectByIds(getSelectedRow());		
		}
		return "delete";
	}

	@Override
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
				request.setAttribute("querycon", commonScholarship);
				//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
				commonScholarship=comscholarshipServices.findObjectById(commonScholarship.getId());
				//将查询得到的数据返回前台
				request.setAttribute("commonScholarship", commonScholarship);
				return "editorUI";
	}

	@Override
	public String editor() {
		//更新数据
		comscholarshipServices.update(commonScholarship);
		//返回listUI页面的时候 将查询条件也传回列表页面
		commonScholarship.setMajor(request.getParameter("query_major"));
		commonScholarship.setStuName(request.getParameter("query_stuName"));
		commonScholarship.setRewardName(request.getParameter("query_rewardName"));
		request.setAttribute("commonScholarship",commonScholarship);
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
		commonScholarship=comscholarshipServices.findObjectById(commonScholarship.getId());
		//将查询得到的数据返回前台
		request.setAttribute("commonScholarship", commonScholarship);
		return "detailUI";
	}
	
//-----------------------get&set------------------------
	public String getQuery_stuName() {
		return query_stuName;
	}

	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}

	public String getQuery_major() {
		return query_major;
	}

	public void setQuery_major(String query_major) {
		this.query_major = query_major;
	}

	public String getQuery_rewardName() {
		return query_rewardName;
	}

	public void setQuery_rewardName(String query_rewardName) {
		this.query_rewardName = query_rewardName;
	}

	public CommonScholarship getCommonScholarship() {
		return commonScholarship;
	}

	public void setCommonScholarship(CommonScholarship commonScholarship) {
		this.commonScholarship = commonScholarship;
	}

}
