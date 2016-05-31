package com.zhbit.action.polstatus;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.User;
import com.zhbit.services.polstatus.PolstatusServices;

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
	
	private String queryWay; //查询的方式
	private String confirmpwd; //确认密码
	private String querycon;//查询的条件

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
			//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
			request.setAttribute("querycon", politicalstatus);
			//调用方法，将查询结果显示
			pageUtils=polstatusServices.queryList(politicalstatus, getPageNO(), getPageSize());	
			return "listUI";
			// TODO Auto-generated method stub
			//setPageSize(5);设置页面显示条数
			//直接调用baseDao接口里面的getPageUtils方法将数据库的所有数据显示在list列表中
		//	pageUtils=polstatusServices.getPageUtils(null, null, null, QueryUtils.ORDER_BY_ASC, getPageNO(), getPageSize());//getPageNO() getPageSize()	
			//return "listUI";
		}
		@Override
		public String addUI() {
			// TODO Auto-generated method stub
			return "addUI";
		}
		@Override
		public String add() {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
			politicalstatus=polstatusServices.findObjectById(politicalstatus.getId());
			request.setAttribute("politicalstatus", politicalstatus);
			return "editorUI";
		}
		@Override
		public String editor() {
			// TODO Auto-generated method stub
			//直接调用baseDao接口里面的update方法更新修改后的数据
			polstatusServices.update(politicalstatus);
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
}
