/**
 * 
 */
package com.zhbit.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zhbit.excel.ExcelConfig;
import com.zhbit.excel.ExcelUtil;

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
	public List<Object> parseExcel(ExcelConfig config) {
		List<Object> lists=null;
		try {
			lists=ExcelUtil.SimpleImportExcel(config);
		} catch (Exception e) {
			System.out.println("---------------excel解释时出错-----------------------");
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public void createExcel(ExcelConfig config) {
		try {
			ExcelUtil.testSimpleVoExport(config);
		} catch (Exception e) {
			System.out.println("-------------------生成excel文档时出错----------------");
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, String> viladationExcel(List list) {
		// TODO Auto-generated method stub
		return null;
	}



}
