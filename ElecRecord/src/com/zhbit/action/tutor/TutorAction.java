package com.zhbit.action.tutor;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.Tutor;
import com.zhbit.services.tutor.TutorServices;
import com.zhbit.util.DecodeUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： TutorAction
 * 类描述：此类用于对于辅导信息的相关请求的转发处理
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午6:43:50
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午6:43:50
 * 修改备注： 
 * @version 
 */ 

public class TutorAction extends BaseAndExcelAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Tutor tutor;
	@Resource(name=TutorServices.SERVICE_NAME)
	TutorServices tutorServices;

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
		//对传来的查询条件进行编码
				if(tutor!=null){
					try {
						tutor.setStuName(DecodeUtils.decodeUTF(tutor.getStuName()));
						tutor.setStudentNo(DecodeUtils.decodeUTF(tutor.getStudentNo()));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						System.out.println("编码时出错");
				}
				}
			
		//将传过来的参数进行回显
		request.setAttribute("queryCon",tutor);
		setPageSize(10);
		
		pageUtils=tutorServices.queryList(tutor, getPageNO(), getPageSize());
		
		return "listUI";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return "addUI";
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		
		//保存传过来的tutor
		//设定创建时间为当前时间
		Timestamp createtime = new Timestamp(System.currentTimeMillis());
		tutor.setCreateTime(createtime);
		
		tutorServices.save(tutor);
		
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
		return null;
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
//--------------------------------getter&setter---------------------------------------

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	
	
}
