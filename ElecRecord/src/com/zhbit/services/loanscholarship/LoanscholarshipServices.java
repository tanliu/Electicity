package com.zhbit.services.loanscholarship;

import java.util.List;


import com.zhbit.entity.LoanScholarship;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoanscholarshipServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月15日 下午4:57:23
 * 修改人：罗吉林
 * 修改时间：2016年6月15日 下午4:57:23
 * 修改备注： 
 * @version 
 */
public interface LoanscholarshipServices extends BaseServices<LoanScholarship>{
	public static final String SERVICES_NAME="com.zhbit.services.loanscholarship.impl.LoanscholarshipServicesImpl";
	//定义数据查询的方法
			public PageUtils queryList(LoanScholarship loanscholarship, int pageNO, int pageSize);

			/**
			 * 方法描述:保存导入的数据
			 * @param students
			 * @param creator
			 */
			void saveFromExcel(List<Object> loanscholarship, String creator);
}
