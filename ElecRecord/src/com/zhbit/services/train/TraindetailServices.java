package com.zhbit.services.train;


import com.zhbit.entity.TraininfoDetail;

import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TraindetailServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:22
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:22
 * 修改备注： 
 * @version 
 */
public interface TraindetailServices extends BaseServices<TraininfoDetail>{
	public static final String SERVICES_NAME="com.zhbit.services.train.impl.TraindetailServicesImpl";
	//定义数据查询的方法
	public PageUtils queryList(TraininfoDetail traininfoDetail, int pageNO, int pageSize);
}
