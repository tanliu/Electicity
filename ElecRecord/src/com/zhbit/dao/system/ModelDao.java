/**
 * 
 */
package com.zhbit.dao.system;

import com.zhbit.dao.BaseDao;
import com.zhbit.dao.system.impl.ModelDaoImpl;
import com.zhbit.entity.Model;

/** 
 * 项目名称：ElecRecord
 * 类名称：ModelDao 
 * 类描述： 模板信息管理
 * 创建人：谭柳
 * 创建时间：2016年6月22日 上午11:16:13
 * 修改人：TanLiu 
 * 修改时间：2016年6月22日 上午11:16:13
 * 修改备注： 
 * @version 
 */
public interface ModelDao extends BaseDao<Model> {
	public final static String DAO_NAME="com.zhbit.dao.system.impl.ModelDaoImpl";

}
