package com.zhbit.services.grantscholarship;

import java.util.List;

import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：GrantscholarshipServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月14日 下午9:30:10
 * 修改人：罗吉林
 * 修改时间：2016年6月14日 下午9:30:10
 * 修改备注： 
 * @version 
 */
public interface GrantscholarshipServices extends BaseServices<GrantScholarship>{
	public static final String SERVICES_NAME="com.zhbit.services.grantscholarship.impl.GrantscholarshipServicesImpl";
	//定义数据查询的方法
	public PageUtils queryList(GrantScholarship grantScholarship, int pageNO, int pageSize);
	/**
	 * 方法描述:保存导入的数据
	 * @param students
	 * @param creator
	 */
	void saveFromExcel(List<Object> grantScholarship, String creator);
}
