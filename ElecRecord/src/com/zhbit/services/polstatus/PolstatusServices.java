package com.zhbit.services.polstatus;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:07:42
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:07:42
 * 修改备注： 
 * @version 
 */
public interface PolstatusServices extends BaseServices<Politicalstatus> {
	public static final String SERVICES_NAME="com.zhbit.services.polstatus.impl.PolstatusServicesImpl";
    
	/**
	 * @param politicalstatus
	 * @return
	 * 定义add增加信息
	 */
	public String add(Politicalstatus politicalstatus);
    
	//定义数据查询的方法
	public PageUtils queryList(Politicalstatus politicalstatus, int pageNO, int pageSize);
}
