/**
 * 
 */
package com.zhbit.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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
public interface ExcelServices {

	public List<Object> parseExcel(File excFile);
	public FileOutputStream parseExcel(List<Object> items);
}
