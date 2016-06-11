package com.zhbit.transform;

import java.util.List;

/** 
 * 项目名称：ElecRecord
 * 类名称：CommonTransform 
 * 类描述：通用数据转接的接口
 * 创建人：谭柳
 * 创建时间：2016年6月8日 下午10:32:54
 * 修改人：TanLiu 
 * 修改时间：2016年6月8日 下午10:32:54
 * 修改备注： 
 * @version 
 */ 
public interface CommonTransform {
	
	public final static String TRANSFORM_NAME="com.zhbit.transform.CommonTransform";
	
	List<Object> toDBEnity(List lists, Class clazz);

}
