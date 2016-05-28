/**
 * 
 */
package com.zhbit.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/** 
 * 项目名称：ElecRecord
 * 类名称：DecodeUtils 
 * 类描述： 编码工具
 * 创建人：谭柳
 * 创建时间：2016年5月28日 下午7:29:23
 * 修改人：TanLiu 
 * 修改时间：2016年5月28日 下午7:29:23
 * 修改备注： 
 * @version 
 */
public class DecodeUtils {
	
	public static String decodeUTF(String code) throws UnsupportedEncodingException{
		return URLDecoder.decode(code, "utf-8");
	}

}
