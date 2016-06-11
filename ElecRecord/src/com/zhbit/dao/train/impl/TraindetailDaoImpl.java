package com.zhbit.dao.train.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.train.TraindetailDao;
import com.zhbit.entity.TraininfoDetail;




/** 
 * 项目名称：ElecRecord
 * 类名称：TraindetailDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:48
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:48
 * 修改备注： 
 * @version 
 */
@Repository(value=TraindetailDao.DAO_NAME)
public class TraindetailDaoImpl extends BaseDaoImpl<TraininfoDetail> implements TraindetailDao{

}
