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

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.entity.excel.TraindetailExcel;
import com.zhbit.entity.excel.TrainmasterExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.train.TraindetailServices;
import com.zhbit.services.train.TrainmasterServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;


/** 
 * 项目名称：ElecRecord
 * 类名称：TrainDetailAction
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:49:47
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:49:47
 * 修改备注： 
 * @version 
 */
@Controller("trainDetailAction")
@Scope(value="prototype")
public class TrainDetailAction extends BaseAndExcelAction{
	TraininfoMaster traininfoMaster=new TraininfoMaster();
	TraininfoDetail traininfoDetail=new TraininfoDetail();
	private static final long serialVersionUID = 1L;
	//定义查询的条件,创建get&set方法,接收页面发送过去的查询条件
		private String query_trainsResult;
		private String query_trainsTopic;
		private String query_stuName;
		
		@Resource(name=TraindetailServices.SERVICES_NAME)
		TraindetailServices traindetailServices;
		@Resource(name=TrainmasterServices.SERVICES_NAME)
		TrainmasterServices trainmasterServices;

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
			ExcelConfig config=new ExcelConfig(TraindetailExcel.class, "培训明细表", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> traininfoDetail = excelServicesMake.toDBEnity(lists,TraininfoDetail.class);
			//获取创建人
			//String creator=RequestUtils.getUserName(request);
            //保存表格里面的数据，在trainmasterServices重新定义saveFromExcel方法
			traindetailServices.saveFromExcel(traininfoDetail);

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
		//查找所有的培训信息trainmaster，方便获取培训主题trainTopic
		List<TraininfoMaster> traininfoMaster=trainmasterServices.findAllObject();
		request.setAttribute("traininfoMaster", traininfoMaster);
		//对传来的查询条件进行编码，防止文字查询条件出现乱码。比如姓名
		if(traininfoDetail!=null){
			if(!StringUtils.isEmpty(traininfoDetail.getStuName())||!StringUtils.isEmpty(traininfoDetail.getTrainsResult())
					||!StringUtils.isEmpty(traininfoDetail.getMaster_trainsTopic())){
			try {
				traininfoDetail.setStuName(DecodeUtils.decodeUTF(traininfoDetail.getStuName()));
				traininfoDetail.setTrainsResult(DecodeUtils.decodeUTF(traininfoDetail.getTrainsResult()));
				traininfoDetail.setMaster_trainsTopic(DecodeUtils.decodeUTF(traininfoDetail.getMaster_trainsTopic()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错 ");
		}
		}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", traininfoDetail);
		//设置页面显示信息条数
		setPageSize(3);
		//调用方法，根据查询条件显示数据
		pageUtils=traindetailServices.queryList(traininfoDetail, getPageNO(), getPageSize());	
		return "listUI";
	}

	@Override
	public String addUI() {
		//查找所有的培训信息trainmaster
		List<TraininfoMaster> traininfoMaster=trainmasterServices.findAllObject();
		request.setAttribute("traininfoMaster", traininfoMaster);
		return "addUI";
	}

	@Override
	public String add() {
		//根据traininfoMaster的id，找到对应的trainsTopic，在将trainsTopic插入到新表中
		traininfoMaster=trainmasterServices.findObjectById(traininfoDetail.getMaster_id());
		traininfoDetail.setMaster_trainsTopic(traininfoMaster.getTrainsTopic());
		traindetailServices.save(traininfoDetail);
		return "add";
	}

	@Override
	public String delete() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("traininfoDetail", traininfoDetail);
		//判断是否已经选中
		//System.out.println(getSelectedRow()[0]);返回一个要被删除数据的集合
		if(getSelectedRow()!=null){		
			traindetailServices.deleteObjectByIds(getSelectedRow());		
		}
		return "delete";
	}

	@Override
	public String editorUI() {
		//查找所有的培训信息trainmaster，方便获取培训主题trainTopic
		List<TraininfoMaster> traininfoMaster=trainmasterServices.findAllObject();
		request.setAttribute("traininfoMaster", traininfoMaster);
		//将listUI界面传过来的查询条件保存
		request.setAttribute("querycon", traininfoDetail);
		//直接调用baseDao接口里面的findObjectById方法根据id去查找数据
		traininfoDetail=traindetailServices.findObjectById(traininfoDetail.getId());
		//将查询得到的数据返回前台
		request.setAttribute("traininfoDetail", traininfoDetail);
		return "editorUI";
	}

	@Override
	public String editor() {
		//根据traininfoMaster的的主题字段，找出对应的id赋值到setMaster_id。
		String[] fields={"trainsTopic=?"};
		String[] params={traininfoDetail.getMaster_trainsTopic()};
		List<TraininfoMaster> traininfoMaster=trainmasterServices.findObjectByFields(fields, params);
		if(traininfoMaster!=null){
		traininfoDetail.setMaster_id(traininfoMaster.get(0).getId());}
		//直接调用baseDao接口里面的update方法更新修改后的数据
		traindetailServices.update(traininfoDetail);
		//返回listUI页面的时候 将查询条件也传回列表页面
		traininfoDetail.setTrainsResult(request.getParameter("query_trainsResult"));
		traininfoDetail.setStuName(request.getParameter("query_stuName"));
		traininfoDetail.setMaster_trainsTopic(request.getParameter("master_trainsTopic"));
		request.setAttribute("traininfoDetail",traininfoDetail);
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
		traininfoDetail=traindetailServices.findObjectById(traininfoDetail.getId());
		//将查询得到的数据返回前台
		request.setAttribute("traininfoDetail", traininfoDetail);
		return "detailUI";
	}
//----------------------get&set----------------------------
	public String getQuery_trainsResult() {
		return query_trainsResult;
	}

	public void setQuery_trainsResult(String query_trainsResult) {
		this.query_trainsResult = query_trainsResult;
	}

	public String getQuery_trainsTopic() {
		return query_trainsTopic;
	}

	public void setQuery_trainsTopic(String query_trainsTopic) {
		this.query_trainsTopic = query_trainsTopic;
	}
	public String getQuery_stuName() {
		return query_stuName;
	}

	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}

	public TraininfoDetail getTraininfoDetail() {
		return traininfoDetail;
	}

	public void setTraininfoDetail(TraininfoDetail traininfoDetail) {
		this.traininfoDetail = traininfoDetail;
	}

	

}
