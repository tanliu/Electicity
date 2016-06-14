package com.zhbit.services.couscholarship;


import java.util.List;

import com.zhbit.entity.CountryScholarship;

import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：CouscholarshipServices
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:47:47
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:47:47
 * 修改备注： 
 * @version 
 */
public interface CouscholarshipServices extends BaseServices<CountryScholarship> {
	public static final String SERVICES_NAME="com.zhbit.services.couscholarship.impl.CouscholarshipServicesImpl";
	//定义数据查询的方法
		public PageUtils queryList(CountryScholarship countryScholarship, int pageNO, int pageSize);

		/**
		 * 方法描述:保存导入的数据
		 * @param students
		 * @param creator
		 */
		void saveFromExcel(List<Object> countryScholarship, String creator);
}
