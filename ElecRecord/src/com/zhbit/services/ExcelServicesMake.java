/**
 * 
 */
package com.zhbit.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import com.zhbit.excel.ExcelConfig;

/** 
 * 项目名称：ElecRecord
 * 类名称：ExcelServices 
 * 类描述： 对excel处理接口，如生成excel文档或者是解释excel文档
 * 创建人：谭柳
 * 创建时间：2016年4月26日 下午12:26:48
 * 修改人：谭柳
 * 修改时间：2016年4月26日 下午12:26:48
 * 修改备注： 
 * @version 
 */
public interface ExcelServicesMake {

	/**
	 * 方法描述:解释excel文档
	 * @param config
	 * @return
	 * @throws Exception 
	 */
	public List<Object> parseExcel(ExcelConfig config) throws Exception;
	/**
	 * 方法描述:生成excel文档
	 * @param config
	 */
	public void createExcel(ExcelConfig config);
	
	public Map<String, String> viladationExcel(List list);
	
	public List<Object> toDBEnity(List lists, Class clazz);
}
