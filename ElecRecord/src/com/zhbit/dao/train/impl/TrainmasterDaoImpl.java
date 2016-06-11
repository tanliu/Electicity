package com.zhbit.dao.train.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;

import com.zhbit.dao.train.TrainmasterDao;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;

/** 
 * 项目名称：ElecRecord
 * 类名称：TrainmasterDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:55
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:55
 * 修改备注： 
 * @version 
 */
@Repository(value=TrainmasterDao.DAO_NAME)
public class TrainmasterDaoImpl extends BaseDaoImpl<TraininfoMaster> implements TrainmasterDao{

}
