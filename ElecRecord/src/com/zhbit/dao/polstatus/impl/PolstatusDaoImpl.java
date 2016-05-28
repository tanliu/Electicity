package com.zhbit.dao.polstatus.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.entity.Politicalstatus;



/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:06:41
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:06:41
 * 修改备注： 
 * @version 
 */
@Repository(value=PolstatusDao.DAO_NAME)
public class PolstatusDaoImpl extends BaseDaoImpl<Politicalstatus> implements PolstatusDao {
/* (non-Javadoc)
 * @see com.zhbit.dao.system.PolstatusDao#add(com.zhbit.entity.TPoliticalstatus)
 * 添加信息 
 */
public void add(Politicalstatus politicalstatus){
	save(politicalstatus);
}
}
