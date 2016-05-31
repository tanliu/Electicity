package com.zhbit.action.polstatus;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.util.QueryUtils;
import com.zhbit.entity.Politicalstatus;
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
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String addUI() {
			// TODO Auto-generated method stub
			return "addUI";
		}
		@Override
		public String add() {
			// TODO Auto-generated method stub
			//获取当前时间并插入数据库
			Timestamp time = new Timestamp(System.currentTimeMillis());
			politicalstatus.setCreateTime(time);
			polstatusServices.add(politicalstatus);//调用services层的add()方法
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
			return "editorUI";
		}
		@Override
		public String editor() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String deleteAll() {
			// TODO Auto-generated method stub
			return null;
		}
		public Politicalstatus getPoliticalstatus() {
			return politicalstatus;
		}
		public void setPoliticalstatus(Politicalstatus politicalstatus) {
			this.politicalstatus = politicalstatus;
		}

		//--------------------------getter&setter--------------------


}
