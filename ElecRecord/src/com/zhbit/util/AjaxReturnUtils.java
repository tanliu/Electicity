/**
 * 
 */
package com.zhbit.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/** 
 * 项目名称：ElecRecord
 * 类名称：AjaxReturnUtils 
 * 类描述： Ajax返回值处理工具
 * 创建人：谭柳
 * 创建时间：2016年5月28日 下午4:25:22
 * 修改人：TanLiu 
 * 修改时间：2016年5月28日 下午4:25:22
 * 修改备注： 
 * @version 
 */
public class AjaxReturnUtils {

	public static void returnResult(HttpServletResponse response, String result) {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(result.getBytes());
			outputStream.close();
		} catch (IOException e) {
			System.out.println("所回输出流出错，在AjaxReturnUtils类中");
			e.printStackTrace();
		}
		
		
	}

}
