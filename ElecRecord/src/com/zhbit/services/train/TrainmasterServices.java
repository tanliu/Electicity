package com.zhbit.services.train;

import java.util.List;

import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TrainmasterServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:31
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:31
 * 修改备注： 
 * @version 
 */
public interface TrainmasterServices extends BaseServices<TraininfoMaster>{
	public static final String SERVICES_NAME="com.zhbit.services.train.impl.TrainmasterServicesImpl";
	
	//定义数据查询的方法
		public PageUtils queryList(TraininfoMaster traininfoMaster, int pageNO, int pageSize);
		
		/**
		 * 方法描述:保存导入的数据
		 * @param students
		 * @param creator
		 */
		void saveFromExcel(List<Object> traininfoMaster, String creator);
}
