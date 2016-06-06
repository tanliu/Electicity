package com.zhbit.services.train;

import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface TrainmasterServices extends BaseServices<TraininfoMaster>{
	public static final String SERVICES_NAME="com.zhbit.services.train.impl.TrainmasterServicesImpl";
	
	//定义数据查询的方法
		public PageUtils queryList(TraininfoMaster traininfoMaster, int pageNO, int pageSize);
}
