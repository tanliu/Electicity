package com.zhbit.services.train;


import com.zhbit.entity.TraininfoDetail;

import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface TraindetailServices extends BaseServices<TraininfoDetail>{
	public static final String SERVICES_NAME="com.zhbit.services.train.impl.TraindetailServicesImpl";
	//定义数据查询的方法
	public PageUtils queryList(TraininfoDetail traininfoDetail, int pageNO, int pageSize);
}
