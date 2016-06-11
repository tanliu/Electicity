/**
 * 
 */
package com.zhbit.services.system;

import java.util.List;

import com.zhbit.entity.SystemDll;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：SystemDllServices 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年4月28日 上午10:12:11
 * 修改人：谭柳
 * 修改时间：2016年4月28日 上午10:12:11
 * 修改备注： 
 * @version 
 */
public interface SystemDllServices extends BaseServices<SystemDll> {
	public static final String SERVICE_NAME="com.zhbit.services.system.impl.SystemDllServicesImpl";
	List<SystemDll> findKeyWordByDistinct();
	/**
	 * 方法描述:保存数据字典
	 * @param ddlNames
	 * @param keyword
	 */
	void saveSystemDll(String[] ddlNames,String keyword);
	/**
	 * 方法描述:更改数据字典
	 * @param ddlNames
	 * @param keyword
	 */
	void editorSystemDll(String[] ddlNames, String keyword);
	
	/**
	 * 方法描述:通过keyword查找到数据字典的数据
	 * @param keyword
	 * @return
	 */
	public List<SystemDll> findSystemDllByKeyword(String keyword);
}
