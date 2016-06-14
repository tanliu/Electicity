package com.zhbit.action.studentstatus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.org.apache.xerces.internal.util.Status;
import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.entity.StuStatus;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.Tutor;
import com.zhbit.entity.excel.StuStaEntity;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.studentstatus.StuStatusServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.transform.StuStatusTransform;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;
import org.apache.commons.lang3.StringUtils;;


/** 
 * 项目名称：ElecRecord
 * 类名称：StuStatusAction
 * 类描述： 用于学籍异动信息处理的Action类
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
@Controller("stuStatusAction")
@Scope(value="prototype")
public class StuStatusAction extends BaseAndExcelAction {

	/**
	 * 添加默认的UID
	 */
	private static final long serialVersionUID = 1L;
	StuStatus stuStatus;
	@Resource(name=StuStatusServices.SERVICE_NAME)
	StuStatusServices stuStatusServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	private String  query_academicYear;
	private String  query_studentNo;
	private String  query_stuName;
	

	@Override 
	public String importExcel() {
		// TODO Auto-generated method stub
		try {
			ExcelConfig config=new ExcelConfig(StuStaEntity.class, "12131学籍异动", 2, new FileInputStream(excel),excelFileName);
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
			List<Object> stustausEntitys = excelServicesMake.toDBEnity(objects,StuStatus.class);
			
			List<StuStatus> stustauss=new ArrayList<StuStatus>();
			
			//将集合中的对象保存至数据库
			for(Object object:stustausEntitys){
				StuStatus stuStatus=(StuStatus) object;
				
				//设定创建时间为当前时间，学生ID暂时设定为"9528"
				stuStatus.setStuId("9528");
				Timestamp createtime = new Timestamp(System.currentTimeMillis());
				stuStatus.setCreateTime(createtime);
				//去除可能存在的空格
				stuStatusServices.trimStustatus(stuStatus);
				
				//将此对象添加到stuStatuss集合中
				stustauss.add(stuStatus);
								
			}
			//批量保存学籍异动信息
			stuStatusServices.saveStatuss(stustauss);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("将Excel的数据转换成StuStaEntity时出错");
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
	public String listUI() {
		// TODO Auto-generated method stub
		//查询学年信息并推送到前台进行显示
		String[] fields={"keyword=?"};
		String[] params1={"学年"};
		List<SystemDll> years=systeDllServices.findObjectByFields(fields,params1);
		request.setAttribute("years", years);
		
		//对传来的查询条件进行编码
		if(stuStatus!=null){
			try {
				stuStatus.setStuName(DecodeUtils.decodeUTF(stuStatus.getStuName()));
				stuStatus.setAcademicYear(DecodeUtils.decodeUTF(stuStatus.getAcademicYear()));
				stuStatus.setStudentNo(DecodeUtils.decodeUTF(stuStatus.getStudentNo()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("编码时出错");
		}
		}
		//将传过来的参数进行回显
		request.setAttribute("queryCon",stuStatus);
		setPageSize(10);
		pageUtils=stuStatusServices.queryList(stuStatus, getPageNO(), getPageSize());
		
		return "listUI";
	}

	/**
		 * 方法描述:此方法用于跳转到添加学籍异动信息界面
		 * @param
		 * @param 
		 */
	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		//保存查询条件
			request.setAttribute("queryCon", stuStatus);
			
			//到数据字典查找类别
			String[] fields={"keyword=?"};
			String[] params1={"学院名称"};
			String[] params2={"学年"};
			String[] params3={"专业"};
			String[] params4={"异动类别"};
			//查找学院类别	
			List<SystemDll> colleges=systeDllServices.findObjectByFields(fields, params1);
			//查找学年
			List<SystemDll> years=systeDllServices.findObjectByFields(fields, params2);
			//查找专业
			List<SystemDll> majors=systeDllServices.findObjectByFields(fields, params3);
			//查找异动类别
			List<SystemDll> tansactionTypes=systeDllServices.findObjectByFields(fields, params4);
			
			//将查询到的信息推送到前台显示
			request.setAttribute("colleges", colleges);	
			request.setAttribute("years", years);
			request.setAttribute("majors", majors);
			request.setAttribute("tansactionTypes", tansactionTypes);
				
		return "addUI";
	}

	@Override
	public String add() {
		//设定创建时间为当前时间
		Timestamp createtime = new Timestamp(System.currentTimeMillis());
		stuStatus.setCreateTime(createtime);
		
		//利用save方法将新添加的学籍异动信息添加到数据库中
		stuStatus=stuStatusServices.trimStustatus(stuStatus);//去除空格后再进行数据的存储
		if(stuStatus!=null){//非空，进行存储
			stuStatusServices.save(stuStatus);
		}
		
		
		//保存成功后将Stustatus中的属性设定为查询条件
		stuStatus.setAcademicYear(getQuery_academicYear());
		stuStatus.setStudentNo(getQuery_studentNo());
		stuStatus.setStuName(getQuery_stuName());
				
		//这里不命名为queryCon，因为Struts中XML文件不支持无Get，Set方法的EL表达式
		request.setAttribute("stuStatus",stuStatus);
		
		return "add";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		
		request.setAttribute("stuStatus",stuStatus);
		
		//先判断用户是否已经选中
		if(getSelectedRow()!=null){		
		stuStatusServices.deleteObjectByIds(getSelectedRow());		
		}
		
		return "delete";
	}

	/**
		 * 方法描述:此方法用于跳转到学籍异动信息修改界面
		 * @param
		 * @param 
		 */
	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		//保存查询条件
		request.setAttribute("queryCon", stuStatus);
		
		//通过传过来的参数值获取对应的学籍信息
		stuStatus=stuStatusServices.findObjectById(stuStatus.getId());
		//对查询到的学籍状态等信息进行处理
		if(!StringUtils.isEmpty(stuStatus.getYdqschoolStatus())){
			stuStatus.setYdqschoolStatus(stuStatus.getYdqschoolStatus().equals("1")?"有":"无");
		}
		if(!StringUtils.isEmpty(stuStatus.getYdhschoolStatus())){
			stuStatus.setYdhschoolStatus(stuStatus.getYdhschoolStatus().equals("1")?"有":"无");
		}
		if(!StringUtils.isEmpty(stuStatus.getYdqinSchool())){
			stuStatus.setYdqinSchool(stuStatus.getYdqinSchool().equals("1")?"是":"否");
		}
		if(!StringUtils.isEmpty(stuStatus.getYdhinSchool())){
			stuStatus.setYdhinSchool(stuStatus.getYdhinSchool().equals("1")?"是":"否");
		}
		if(!StringUtils.isEmpty(stuStatus.getYdqisRegiste())){
			stuStatus.setYdqisRegiste(stuStatus.getYdqisRegiste().equals("1")?"是":"否");
		}
		if(!StringUtils.isEmpty(stuStatus.getYdhisRegiste())){
			stuStatus.setYdhisRegiste(stuStatus.getYdhisRegiste().equals("1")?"是":"否");
		}
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"学院名称"};
		String[] params2={"学年"};
		String[] params3={"专业"};
		String[] params4={"异动类别"};
		//查找学院类别	
		List<SystemDll> colleges=systeDllServices.findObjectByFields(fields, params1);
		//查找学年
		List<SystemDll> years=systeDllServices.findObjectByFields(fields, params2);
		//查找专业
		List<SystemDll> majors=systeDllServices.findObjectByFields(fields, params3);
		//查找异动类别
		List<SystemDll> tansactionTypes=systeDllServices.findObjectByFields(fields, params4);
		
		//将查询到的信息推送到前台显示
		request.setAttribute("colleges", colleges);	
		request.setAttribute("years", years);
		request.setAttribute("majors", majors);
		request.setAttribute("tansactionTypes", tansactionTypes);
		
		//将查询得到的学籍信息推送到前台显示
		request.setAttribute("stuStatus", stuStatus);
		
		return "editorUI";
	}

	
	@Override
	public String editor() {
		// TODO Auto-generated method stub
		
		//使用update方法更新学籍信息
		stuStatus=stuStatusServices.trimStustatus(stuStatus);//去除空格后再进行数据的存储
		stuStatusServices.update(stuStatus);
		
		//保存成功后将Stustatus中的属性设定为查询条件
		stuStatus.setAcademicYear(getQuery_academicYear());
		stuStatus.setStudentNo(getQuery_studentNo());
		stuStatus.setStuName(getQuery_stuName());
	
		//这里不命名为queryCon，因为Struts中XML文件不支持无Get，Set方法的EL表达式
		request.setAttribute("stuStatus",stuStatus);
		
		return "editor";
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String detailUI(){
		//通过传过来的参数值获取对应的学籍信息
		stuStatus=stuStatusServices.findObjectById(stuStatus.getId());
		
		//对查询到的学籍状态等信息进行处理
				if(!StringUtils.isEmpty(stuStatus.getYdqschoolStatus())){
					stuStatus.setYdqschoolStatus(stuStatus.getYdqschoolStatus().equals("1")?"有":"无");
				}
				if(!StringUtils.isEmpty(stuStatus.getYdhschoolStatus())){
					stuStatus.setYdhschoolStatus(stuStatus.getYdhschoolStatus().equals("1")?"有":"无");
				}
				if(!StringUtils.isEmpty(stuStatus.getYdqinSchool())){
					stuStatus.setYdqinSchool(stuStatus.getYdqinSchool().equals("1")?"是":"否");
				}
				if(!StringUtils.isEmpty(stuStatus.getYdhinSchool())){
					stuStatus.setYdhinSchool(stuStatus.getYdhinSchool().equals("1")?"是":"否");
				}
				if(!StringUtils.isEmpty(stuStatus.getYdqisRegiste())){
					stuStatus.setYdqisRegiste(stuStatus.getYdqisRegiste().equals("1")?"是":"否");
				}
				if(!StringUtils.isEmpty(stuStatus.getYdhisRegiste())){
					stuStatus.setYdhisRegiste(stuStatus.getYdhisRegiste().equals("1")?"是":"否");
				}
		
		//将查询得到的学籍信息推送到前台显示
		request.setAttribute("stuStatus", stuStatus);
				
		return "detailUI";
	}
	//------------------------------------getter&setter-----------------------------------
	
	public String getQuery_academicYear() {
		return query_academicYear;
	}

	public StuStatus getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(StuStatus stuStatus) {
		this.stuStatus = stuStatus;
	}

	public void setQuery_academicYear(String query_academicYear) {
		this.query_academicYear = query_academicYear;
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
