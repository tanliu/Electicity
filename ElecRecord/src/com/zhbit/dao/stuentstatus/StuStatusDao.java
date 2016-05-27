package com.zhbit.dao.stuentstatus;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.StuStatus;

/** 
 * 项目名称：ElecRecord
 * 类名称：StuStatusDao
 * 类描述： 用于学籍异动信息处理的Dao层接口
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
public interface StuStatusDao extends BaseDao<StuStatus> {
public static final String DAO_NAME="com.zhbit.dao.studentstatus.impl.StuStatusDaoImpl";
	
	
	/**
	 * 方法描述:批量保存、更新数据
	 */
	public void saveOrUpdateAll(List<StuStatus> status);
}
