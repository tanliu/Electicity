package com.zhbit.action.train;

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
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.entity.excel.PolstatusExcel;
import com.zhbit.entity.excel.TrainmasterExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.train.TrainmasterServices;
import com.zhbit.transform.PolstatusTransform;
import com.zhbit.transform.TrainmasterTransform;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TrainMasterAction
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:49:52
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:49:52
 * 修改备注： 
 * @version 
 */
@Controller("trainMasterAction")
@Scope(value="prototype")
public class TrainMasterAction extends BaseAndExcelAction{
	TraininfoMaster traininfoMaster;
	private static final long serialVersionUID = 1L;
	@Resource(name=TrainmasterServices.SERVICES_NAME)
	TrainmasterServices trainmasterServices;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
	private String query_trainsTopic;
	private String query_manager;
	private Timestamp query_trainsDate;
	
	
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
			ExcelConfig config=new ExcelConfig(TrainmasterExcel.class, "培训信息", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> traininfoMaster = excelServicesMake.toDBEnity(lists,TraininfoMaster.class);
			//获取创建人
			String creator=RequestUtils.getUserName(request);
            //保存表格里面的数据，在trainmasterServices重新定义saveFromExcel方法
			trainmasterServices.saveFromExcel(traininfoMaster,creator);

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
	public String listUI() {
		
		//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
		if(traininfoMaster!=null){
			try {
				traininfoMaster.setManager(DecodeUtils.decodeUTF(traininfoMaster.getManager()));
				traininfoMaster.setTrainsTopic(DecodeUtils.decodeUTF(traininfoMaster.getTrainsTopic()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错 ");
		}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", traininfoMaster);
		
		//设置页面显示信息条数
		setPageSize(2);
		//调用方法，根据查询条件显示数据
		pageUtils=trainmasterServices.queryList(traininfoMaster, getPageNO(), getPageSize());	
		return "listUI";
		//setPageSize(5);设置页面显示信息条数 可以直接写getPageSize()，则默认为2条信息每页，也可以手动写数字，比如5，则为5条信息
		
	}

	@Override
	public String addUI() {
		request.setAttribute("querycon", traininfoMaster);
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		//获取当前时间作为createtime列的值并插入数据库
		Timestamp time = new Timestamp(System.currentTimeMillis());
		traininfoMaster.setCreateTime(time);
		trainmasterServices.save(traininfoMaster);
		return "add";
	}

	@Override
	public String delete() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("traininfoMaster", traininfoMaster);
		//判断是否已经选中
		//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
		if(getSelectedRow()!=null){		
			trainmasterServices.deleteObjectByIds(getSelectedRow());		
		}
		return "delete";
	}

	@Override
	public String editorUI() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("querycon", traininfoMaster);
		//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
		traininfoMaster=trainmasterServices.findObjectById(traininfoMaster.getId());
		//将查询得到的数据返回前台
		request.setAttribute("traininfoMaster", traininfoMaster);
		return "editorUI";
	}

	@Override
	public String editor() {
		//直接调用baseDao接口里面的update方法更新修改后的数据
		trainmasterServices.update(traininfoMaster);
		//返回listUI页面的时候 将查询条件也传回列表页面
		traininfoMaster.setManager(getQuery_manager());
		traininfoMaster.setTrainsTopic(getQuery_trainsTopic());
	    traininfoMaster.setTrainsDate(getQuery_trainsDate());
		request.setAttribute("traininfoMaster",traininfoMaster);
		return "editor";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public String detailUI(){
		//将listUI界面传过来的查询条件保存
		
		//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
		traininfoMaster=trainmasterServices.findObjectById(traininfoMaster.getId());
		//将查询得到的数据返回前台
		request.setAttribute("traininfoMaster", traininfoMaster);
		return "detailUI";
	}
	
	//-----------------get&set--------------------
	public String getQuery_trainsTopic() {
		return query_trainsTopic;
	}

	public void setQuery_trainsTopic(String query_trainsTopic) {
		this.query_trainsTopic = query_trainsTopic;
	}

	public String getQuery_manager() {
		return query_manager;
	}

	public void setQuery_manager(String query_manager) {
		this.query_manager = query_manager;
	}
	public Timestamp getQuery_trainsDate() {
		return query_trainsDate;
	}
	public void setQuery_trainsDate(Timestamp query_trainsDate) {
		this.query_trainsDate = query_trainsDate;
	}

	public TraininfoMaster getTraininfoMaster() {
		return traininfoMaster;
	}

	public void setTraininfoMaster(TraininfoMaster traininfoMaster) {
		this.traininfoMaster = traininfoMaster;
	}


}
