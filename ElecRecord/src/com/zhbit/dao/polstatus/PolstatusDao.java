package com.zhbit.dao.polstatus;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.dao.BaseDao;

/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusDao
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:06:04
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:06:04
 * 修改备注： 
 * @version 
 */
public interface PolstatusDao extends BaseDao<Politicalstatus>{
	public static final String DAO_NAME="com.zhbit.dao.polstatus.impl.PolstatusDaoImpl";
/**
 * @param tpoliticalstatus
 * 添加信息
 */
public void add(Politicalstatus politicalstatus);
}
