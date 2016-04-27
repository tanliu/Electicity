/**
 * 
 */
package com.zhbit.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

/** 
 * 项目名称：ElecRecord
 * 类名称：ExcelServicesImpl 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年4月26日 下午12:43:49
 * 修改人：谭柳
 * 修改时间：2016年4月26日 下午12:43:49
 * 修改备注： 
 * @version 
 */
@Service("excelServices")
public class ExcelServicesImpl implements ExcelServices {

	@Override
	public List<Object> parseExcel(File excFile) {
		return null;
	}

	@Override
	public FileOutputStream parseExcel(List<Object> items) {
		return null;
	}

}
