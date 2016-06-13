package com.zhbit.services.comscholarship;


import com.zhbit.entity.CommonScholarship;

import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：ComscholarshipServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月12日 下午7:51:33
 * 修改人：罗吉林
 * 修改时间：2016年6月12日 下午7:51:33
 * 修改备注： 
 * @version 
 */
public interface ComscholarshipServices extends BaseServices<CommonScholarship>{
	public static final String SERVICES_NAME="com.zhbit.services.comscholarship.impl.ComscholarshipServicesImpl";
	//定义数据查询的方法
		public PageUtils queryList(CommonScholarship commonScholarship, int pageNO, int pageSize);
}
