/**
 * 
 */
package com.zhbit.action.system;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.Model;
import com.zhbit.services.system.ModelServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.QueryUtils;
import com.zhbit.util.RequestUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：ModelAction 
 * 类描述：模板Action层
 * 创建人：谭柳
 * 创建时间：2016年6月22日 上午11:57:32
 * 修改人：TanLiu 
 * 修改时间：2016年6月22日 上午11:57:32
 * 修改备注： 
 * @version 
 */
@Controller("modelAction")
@Scope(value="prototype")
public class ModelAction extends BaseAction {

	String querycon;
	//excel文件上传的属性
	private File excel;
	private  String excelFileName;
	private String excelContentType;
	
	Model model;
	@Resource(name=ModelServices.SERVICES_NAME)
	ModelServices modelServices;
	@Override
	public String listUI() {
		setPageSize(10);
		if(querycon!=null){
			try {
				querycon=DecodeUtils.decodeUTF(querycon);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}		
		String[] fields={"fileName=?"};
		String[] params={querycon};
		String proterty="fileName";
		String order=QueryUtils.ORDER_BY_DESC;
		pageUtils=modelServices.getPageUtils(fields, params, proterty, order, getPageNO(), getPageSize());
		return "listUI";
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String add() {
		model=new Model();
		//把文件保存起来
		if(excel!=null){
			//保存文件的路径
			String filePath=ServletActionContext.getServletContext().getRealPath("upload/model");
			//生成新的文件名
			String fileName=UUID.randomUUID().toString().replaceAll("-", "")+excelFileName.substring(excelFileName.lastIndexOf("."));
			//复制文件
			try {
				FileUtils.copyFile(excel, new File(filePath,fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置文件头像路径
			model.setFilePath("model/"+fileName);
			model.setFileName(excelFileName);
			model.setCreator(RequestUtils.getUserName(request));
			//把信息保存到数据库
			modelServices.save(model);
		}
		
		
		return "list";
	}

	@Override
	public String delete() {
		
		if(selectedRow!=null&&selectedRow.length>0){
			for (String id : selectedRow) {
				model=modelServices.findObjectById(id);
				String filePath=ServletActionContext.getServletContext().getRealPath("upload")+"\\"+model.getFilePath();
				File file=new File(filePath);
				Boolean flag=file.delete();
				if(flag){
					modelServices.deleteObjectByIds(id);
					
				}
				
			}
		}
		
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
	
	public String download(){
		pageUtils=modelServices.getPageUtils(null, null, null, null, getPageNO(), 100);
		return "download";
	}
	
	//-------------getter&&setter---------------------

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getExcelContentType() {
		return excelContentType;
	}

	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getQuerycon() {
		return querycon;
	}

	public void setQuerycon(String querycon) {
		this.querycon = querycon;
	}
	
	

}
