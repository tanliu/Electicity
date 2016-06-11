/**
 * 
 */
package com.zhbit.services.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.system.SystemDllDao;
import com.zhbit.entity.SystemDll;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.SystemDllServices;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：SystemDllServicesImpl 
 * 类描述： 数据字典的Service层接口的实现类
 * 创建人：谭柳
 * 创建时间：2016年4月28日 上午10:26:51
 * 修改人：谭柳
 * 修改时间：2016年4月28日 上午10:26:51
 * 修改备注： 
 * @version 
 */
@Service(value=SystemDllServices.SERVICE_NAME)
public class SystemDllServicesImpl extends BaseServicesImpl<SystemDll> implements
		SystemDllServices {
	
	SystemDllDao systemDllDao;
	@Resource(name=SystemDllDao.DAO_NAME)
	public void setSystemDllDao(SystemDllDao systemDllDao) {
		this.systemDllDao = systemDllDao;
		super.setBaseDao(systemDllDao);
	}
	


	/**
	 * 方法描述:查找数据字典中的所有类型
	 * @return
	 */
	public List<SystemDll> findKeyWordByDistinct() {
		List<SystemDll> systemDlls=systemDllDao.findKeyWordByDistinct();
		return systemDlls;
	}



	/**
	 * 方法描述:保存数据字典的数据
	 * @param ddlNames //把有名字
	 */
	@Override
	public void saveSystemDll(String[] ddlNames,String keyword) {
		if(ddlNames!=null&& ddlNames.length>0){  
			int i=1;
			for (String ddlName : ddlNames) {
				SystemDll systemDll=new SystemDll();
				systemDll.setKeyword(keyword);
				systemDll.setDdlCode(i);
				systemDll.setDdlName(ddlName);
				save(systemDll);
			}
		}
		
	}



	/**
	 * 方法描述:保存数据字典
	 * @param ddlNames
	 * @param keyword
	 */
	@Override
	public void editorSystemDll(String[] ddlNames, String keyword) {
		
		QueryUtils queryUtils=new QueryUtils(SystemDll.class, "s");
		queryUtils.addCondition("s.keyword=?", keyword);
         //先删除记录
		List<SystemDll> systemDlls=findObjectByFields(queryUtils);
		deleteObjectByCollection(systemDlls);
		//再保存记录
		saveSystemDll(ddlNames, keyword);
	}



	@Override
	public List<SystemDll> findSystemDllByKeyword(String keyword) {
		String[] fields={"keyword=?"};
		String[] params={keyword};
		return this.findObjectByFields(fields, params);
	}

}
