package com.zhbit.dao.train;

import com.zhbit.dao.BaseDao;

import com.zhbit.entity.TraininfoMaster;

/** 
 * 项目名称：ElecRecord
 * 类名称：TrainmasterDao
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:49:10
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:49:10
 * 修改备注： 
 * @version 
 */
public interface TrainmasterDao extends BaseDao<TraininfoMaster>{
	public static final String DAO_NAME="com.zhbit.dao.train.impl.TrainmasterDaoImpl";
}
