/**
 * 
 */
package com.zhbit.action.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhbit.action.BaseAction;
import com.zhbit.entity.Organization;
import com.zhbit.services.system.OrganizeServices;
import com.zhbit.util.QueryUtils;


/** 
 * 项目名称：ElecRecord
 * 类名称：OrganizeAction 
 * 类描述： 部门模块的Action层
 * 创建人：谭柳
 * 创建时间：2016年5月6日 下午1:05:44
 * 修改人：谭柳
 * 修改时间：2016年5月6日 下午1:05:44
 * 修改备注： 
 * @version 
 */
@Controller("organizeAction")
@Scope(value="prototype")
public class OrganizeAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Organization organize;
	@Resource(name=OrganizeServices.SERVICE_NAME)
	OrganizeServices organizeServices;

	
	@Override
	public String listUI() {
		return null;
	}

	@Override
	public String addUI() {
		QueryUtils queryUtils=new QueryUtils(Organization.class, "o");
		List<Organization> organizations=organizeServices.findAllObject(queryUtils);
		request.setAttribute("organizations", organizations);
		return "addUI";
	}

	@Override
	public String add() {
		if(organize!=null){  //organize不为空
            //如果有父结点
			if(!"".equals(organize.getParentId())){
				//查找父结点的所有交结点
				QueryUtils queryUtils=new QueryUtils(Organization.class, "o");
				queryUtils.addCondition("o.orgId=?", organize.getParentId());
				List<Organization> organizations=organizeServices.findObjectByFields(queryUtils);
				if(organizations!=null){
					//把父结点和父结点的所有父结结点保存到当前结点的所有父结点
					organize.setParentIds(organizations.get(0).getParentIds()+","+organize.getParentId());					
				}else{
					System.out.println("不存在这父结点");
				}
			}else{
				organize.setParentIds(organize.getParentId());
			}
			//保存数据
			organizeServices.save(organize);
		}
		return null;
	}

	@Override
	public String delete() {
		return null;
	}

	@Override
	public String editorUI() {
		return null;
	}

	@Override
	public String editor() {
		return null;
	}

	@Override
	public String deleteAll() {
		return null;
	}


	//-------------------------------getter&&setter-------------------------
	public Organization getOrganize() {
		return organize;
	}

	public void setOrganize(Organization organize) {
		this.organize = organize;
	}
	

}
