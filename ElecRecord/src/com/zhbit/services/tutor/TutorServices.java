package com.zhbit.services.tutor;

import com.zhbit.entity.StuStatus;
import com.zhbit.entity.Tutor;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： TutorServices
 * 类描述：用于辅导信息模块的services接口层
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午8:47:59
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午8:47:59
 * 修改备注： 
 * @version 
 */ 
public interface TutorServices extends BaseServices<Tutor> {
	public static final String SERVICE_NAME="com.zhbit.services.tutor.impl.TutorServicesImpl";
	
	 public PageUtils queryList(Tutor tutor, int pageNO, int pageSize);
	 
	 public Tutor trimTutor(Tutor tutor);
	 
}
