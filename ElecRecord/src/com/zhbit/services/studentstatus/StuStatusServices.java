package com.zhbit.services.studentstatus;

import com.zhbit.entity.StuStatus;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称： StuStatusServices
 * 类描述：用于处理学籍异动信息的Services层接口
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
public interface StuStatusServices extends BaseServices<StuStatus> {
	public static final String SERVICE_NAME="com.zhbit.dao.studentstatus.impl.StuStatusServicesImpl";
}
