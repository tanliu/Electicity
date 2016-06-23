package com.zhbit.action.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.zhbit.entity.GuiContent;
import com.zhbit.entity.StuStatus;
import com.zhbit.entity.Student;
import com.zhbit.entity.Tutor;
import com.zhbit.entity.excel.StuStaEntity;
import com.zhbit.entity.excel.TutorEntity;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.tutor.TutorServices;
import com.zhbit.transform.StuStatusTransform;
import com.zhbit.transform.TutorTransform;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.RequestUtils;

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
	private Timestamp query_guidDate;
	private String query_studentNo;
	private String query_stuName;
	@Resource(name=TutorServices.SERVICE_NAME)
	TutorServices tutorServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;

	@Override
	@Limit(url="/tutor/tutor_importExcel.action")
	public String importExcel() {
		// TODO Auto-generated method stub
		ExcelConfig config;
		try {
			config = new ExcelConfig(TutorEntity.class, "Sheet1", 1, new FileInputStream(excel),excelFileName);
			
			List<Object> objects=excelServicesMake.parseExcel(config);
			
			Map<String, String> viladationExcel = excelServicesMake.viladationExcel(objects);
			
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
			List<Object> tutorEntitys = excelServicesMake.toDBEnity(objects,Tutor.class);
			
			List<Tutor> tutors=new ArrayList<Tutor>();
		
		//将集合中的对象保存至数据库
			for(Object object:tutorEntitys){
				Tutor tutor=(Tutor) object;
				
				String[] fields;
				Object[] params;				
				
				fields=new String[]{"studentNo=?","guidDate=?","guidAddress=?"};
				params=new Object[]{tutor.getStudentNo(),tutor.getGuidDate(),tutor .getGuidAddress()};
				
				if(!StringUtils.isEmpty(tutor.getStudentNo())){
				if(tutorServices.findObjectByFields(fields, params)==null){//当学号、辅导时间、辅导地点相同的记录不存在时，才添加到集合中
					//通过对应的学生学号得到对应的stu_id
					Student student=studentServices.getStudentByNo(tutor.getStudentNo());
					if(student!=null){
						tutor.setStuId(student.getStuId());
					}
				
				Timestamp createtime = new Timestamp(System.currentTimeMillis());
				tutor.setCreateTime(createtime);
				
				//去除可能存在的空格
				tutorServices.trimTutor(tutor);				
				//将此对象放入guiContents集合中
				tutors.add(tutor);
				
			}
			
			}
			
			}
			if(tutors.size()>=1){
				//批量插入辅导信息
				tutorServices.saveTutors(tutors);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "excelSuccess";
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}

	@Override
	@Limit(url="/tutor/tutor_listUI.action")
	public String listUI() {
		// TODO Auto-generated method stub
		
		//对传来的查询条件进行编码
				if(tutor!=null){
					//判断是否是学生，如果是，则将其输入的学号强转为他本人的学号
					tutor.setStudentNo(RequestUtils.checkStudentAuthority(request, tutor.getStudentNo()));							
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
	@Limit(url="/tutor/tutor_add.action")
	public String addUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", tutor);
		
		return "addUI";
	}

	@Override
	@Limit(url="/tutor/tutor_add.action")
	public String add() {
		// TODO Auto-generated method stub
		
		
		//去除空格后再进行存储
		tutor=tutorServices.trimTutor(tutor);
		if(tutor!=null){
			//设定创建时间为当前时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			tutor.setCreateTime(createtime);
			//通过对应的学生学号得到对应的stu_id
			Student student=studentServices.getStudentByNo(tutor.getStudentNo());
			if(student!=null){
				tutor.setStuId(student.getStuId());
			}
			tutorServices.save(tutor);
		}
		
		
		//保存成功后将tutor中的属性设定为查询条件
		tutor.setGuidDate(getQuery_guidDate());
		tutor.setStudentNo(getQuery_studentNo());
		tutor.setStuName(getQuery_stuName());
		
		//这里不命名为queryCon，因为Struts中XML文件不支持无Get，Set方法的EL表达式
		request.setAttribute("tutor",tutor);
		
		return "add";
	}

	@Override
	@Limit(url="/tutor/tutor_delete.action")
	public String delete() {
		// TODO Auto-generated method stub
		
		request.setAttribute("tutor",tutor);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
			tutorServices.deleteObjectByIds(getSelectedRow());		
			}
				
		return "delete";
	}

	@Override
	@Limit(url="/tutor/tutor_editor.action")
	public String editorUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", tutor);
				
		//通过传过来的参数值获取对应的学籍信息
		tutor=tutorServices.findObjectById(tutor.getId());
		
		//将查询得到的学籍信息推送到前台显示
		request.setAttribute("tutor", tutor);
		
		return "editorUI";
	}

	@Override
	@Limit(url="/tutor/tutor_editor.action")
	public String editor() {
		// TODO Auto-generated method stub
		//使用update方法更新辅导信息
		tutor=tutorServices.trimTutor(tutor);//去除空格后再进行数据的存储
		tutorServices.update(tutor);
		
		//保存成功后将tutor中的属性设定为查询条件
		tutor.setGuidDate(getQuery_guidDate());
		tutor.setStudentNo(getQuery_studentNo());
		tutor.setStuName(getQuery_stuName());
				
		//这里不命名为queryCon，因为Struts中XML文件不支持无Get，Set方法的EL表达式
		request.setAttribute("tutor",tutor);
		
		return "editor";
	}

	public String detailUI(){
		
		tutor=tutorServices.findObjectById(tutor.getId());
		
		request.setAttribute("tutor", tutor);
		
		return "detailUI";
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

	public Timestamp getQuery_guidDate() {
		return query_guidDate;
	}

	public void setQuery_guidDate(Timestamp query_guidDate) {
		this.query_guidDate = query_guidDate;
	}

	public String getQuery_studentNo() {
		return query_studentNo;
	}

	public void setQuery_studentNo(String query_studentNo) {
		this.query_studentNo = query_studentNo;
	}

	public String getQuery_stuName() {
		return query_stuName;
	}

	public void setQuery_stuName(String query_stuName) {
		this.query_stuName = query_stuName;
	}

	
	
}
