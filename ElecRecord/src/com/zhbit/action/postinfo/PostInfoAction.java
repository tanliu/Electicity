package com.zhbit.action.postinfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.text.entity.excel.TestEntity;
import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Limit;
import com.zhbit.entity.Organization;
import com.zhbit.entity.Postinfo;
import com.zhbit.entity.Student;
import com.zhbit.entity.StudentDutys;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.SystemDll;
import com.zhbit.entity.User;
import com.zhbit.entity.excel.PostinfoExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.postinfo.PostInfoServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.PostInfoTransfrom;
import com.zhbit.transform.TestTransform;
import com.zhbit.util.AjaxReturnUtils;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

/**
 * 项目名称：ElecRecord 
 * 类名称： PostInfoAction 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月11日 下午3:54:49 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月11日 下午3:54:49 
 * 修改备注： 
 * @version 
 */
@Controller("PostInfoAction")
@Scope(value="prototype")
public class PostInfoAction extends BaseAndExcelAction {
	
	Postinfo postinfo;
	private String queryWay; //查询的方式

	
	@Resource(name=PostInfoServices.SERVER_NAME)
	PostInfoServices postInfoServices;
	@Resource(name=SystemDllServices.SERVICE_NAME)
	SystemDllServices systeDllServices;
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	/* 
	* 方法重写
	* 方法名: listUI 
	* 方法描述: 显示学科竞赛基本信息
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_listUI.action")
	public String listUI() {
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"专业"};
		//查找专业名称
		List<SystemDll> major=systeDllServices.findObjectByFields(fields, params1);
		//将查询到的信息推送到前台显示
			request.setAttribute("major", major);	
		//对传来的查询条件进行编码
		if(postinfo!=null){
			try {
				
				postinfo.setEmsno(DecodeUtils.decodeUTF(postinfo.getEmsno()));
				postinfo.setMailNo(DecodeUtils.decodeUTF(postinfo.getMailNo()));
				postinfo.setStuName(DecodeUtils.decodeUTF(postinfo.getStuName()));
				postinfo.setMajor(DecodeUtils.decodeUTF(postinfo.getMajor()));				
			} catch (UnsupportedEncodingException e) {
				System.out.println("编码时出错");
			}
		}
		//将页面表单传过来的查询条件封装到实体类里面，querycon为查询条件。
		request.setAttribute("querycon", postinfo);
		setPageSize(8);
		pageUtils=postInfoServices.queryList(postinfo, getPageNO(), getPageSize());	
		
		
		
		return "listUI";
	}

	/* 
	* 方法重写
	* 方法名: addUI 
	* 方法描述:跳转到添加信息页面 
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_add.action")
	public String addUI() {
		//到数据字典查找类别
			String[] fields={"keyword=?"};
			String[] params1={"专业"};
			String[] params2={"派遣性质"};
		//查找专业名称
			List<SystemDll> major=systeDllServices.findObjectByFields(fields, params1);
		//查找派遣性质
			List<SystemDll> dispatchType=systeDllServices.findObjectByFields(fields, params2);					
		//将查询到的信息推送到前台显示
				request.setAttribute("major", major);	
				request.setAttribute("dispatchType", dispatchType);
		return "addUI";
	}

	/* 
	* 方法重写
	* 方法名: add 
	* 方法描述:保存添加信息
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_add.action")
	public String add() {
		postinfo.setStuId("001");
		//设置创建时间 
		postinfo.setCreateTime(new Timestamp(new Date().getTime()));
		postinfo.setCreator("朱嘉鑫");
		
		postInfoServices.save(postinfo);
		return "add";
	}

	/* 
	* 方法重写
	* 方法名: delete 
	* 方法描述:删除信息
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_delete.action")
	public String delete() {
		if(selectedRow!=null&&selectedRow.length>0){
			postInfoServices.deleteObjectByIds(selectedRow);
		}
		return "delete";
	}

	/* 
	* 方法重写
	* 方法名: editorUI 
	* 方法描述: 跳转到编辑信息页面
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_editor.action")
	public String editorUI() {
		//将listUI界面传过来的查询条件保存
		request.setAttribute("querycon", postinfo);
		
		//到数据字典查找类别
		String[] fields={"keyword=?"};
		String[] params1={"专业"};
		String[] params2={"派遣性质"};
		//查找专业名称
		List<SystemDll> major=systeDllServices.findObjectByFields(fields, params1);
		//查找派遣性质
		List<SystemDll> dispatchType=systeDllServices.findObjectByFields(fields, params2);					
		//将查询到的信息推送到前台显示
			request.setAttribute("major", major);	
			request.setAttribute("dispatchType", dispatchType);
		
		// 通过传过来的参数值获取对应的学籍信息
		postinfo = postInfoServices.findObjectById(postinfo.getId());
		request.setAttribute("postinfo", postinfo);
		return "editorUI";
	}

	/* 
	* 方法重写
	* 方法名: editor 
	* 方法描述: 保存编辑后的信息
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_editor.action")
	public String editor() {
		postInfoServices.update(postinfo);
		
		postinfo.setEmsno(request.getParameter("query_emsno"));
		postinfo.setMailNo(request.getParameter("query_mailNo"));
		postinfo.setMajor(request.getParameter("query_major"));
		postinfo.setStuName(request.getParameter("query_stuName"));

		request.setAttribute("postinfo",postinfo);
		return "editor";
	}

	/* 
	* 方法重写
	* 方法名: deleteAll 
	* 方法描述: 删除选中的条目
	* @return       
	*/
	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	* 方法重写
	* 方法名: detailUI 
	* 方法描述: 显示详情
	* @return       
	*/
	
	public String detailUI() {
		postinfo = postInfoServices.findObjectById(postinfo.getId());
		return "detailUI";
	}

	/* 
	* 方法重写
	* 方法名: importExcel 
	* 方法描述: 
	* @return       
	*/
	@Override
	@Limit(url="/postinfo/postinfo_importExcel.action")
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			ExcelConfig config=new ExcelConfig(PostinfoExcel.class, "sheet1", 1, new FileInputStream(excel),excelFileName);
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
			List<Object> postinfo = excelServicesMake.toDBEnity(lists,Postinfo.class);
			
			String creator=RequestUtils.getUserName(request);
			postInfoServices.saveFromExcel(postinfo,creator);
			
//			
//			BaseTransfrom postInfoTransform=new PostInfoTransfrom();
//			List<Object> list=postInfoTransform.toDBEntity(lists);
//			for (int i=0;i<list.size();i++) {
//				Postinfo pi=(Postinfo)list.get(i);
//				postInfoServices.save(pi);
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "excelSuccess";
		
	}

	@Override
	public void exportExcel() {
		List<PostinfoExcel> Excellist=new ArrayList<PostinfoExcel>();
		List<Postinfo> pilist;
		if(selectedRow!=null){
			pilist=postInfoServices.queryListDownload(selectedRow);
		}else{
			pilist=postInfoServices.queryAllList();
		}
		//查询选中的Postinfo
		
		BaseTransfrom baseTransfrom=new PostInfoTransfrom();
		List<Object> list=baseTransfrom.toExcelObj(pilist);
		
		for(int i=0;i<list.size();i++){
			PostinfoExcel excel=(PostinfoExcel)list.get(i);
			Excellist.add(excel);
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/x-execl");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+new String("学生档案邮寄信息表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream=response.getOutputStream();
			ExcelConfig config=new ExcelConfig(PostinfoExcel.class, "sheet1", outputStream);
			config.setEntitys(Excellist);
			excelServices.createExcel(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 方法描述:数据唯一性校验
	 * @return
	 */
	public String hasStudent(){
	
		if(postinfo!=null&&!StringUtils.isBlank(postinfo.getStudentNo())){
			Student student=studentServices .getStudentByNo(postinfo.getStudentNo());
				if(student!=null){
					try {
						String string=student.getStuName();
						System.out.println("name="+string);
						string=URLEncoder.encode(string, "UTF-8");
						request.setCharacterEncoding("utf-8");
						AjaxReturnUtils.returnResult(response,string);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
		
		return null;
	}
	//-------------------------getter&&setter-----------------------

	
	public String getQueryWay() {
		return queryWay;
	}

	public Postinfo getPostinfo() {
		return postinfo;
	}

	public void setPostinfo(Postinfo postinfo) {
		this.postinfo = postinfo;
	}

	public void setQueryWay(String queryWay) {
		this.queryWay = queryWay;
	}
	
}