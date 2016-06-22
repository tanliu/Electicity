/**
 * 
 */
package com.zhbit.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.ModelDao;
import com.zhbit.entity.Model;

/** 
 * 项目名称：ElecRecord
 * 类名称：ModelDaoImpl 
 * 类描述： 模板信息管理
 * 创建人：谭柳
 * 创建时间：2016年6月22日 上午11:19:59
 * 修改人：TanLiu 
 * 修改时间：2016年6月22日 上午11:19:59
 * 修改备注： 
 * @version 
 */
@Repository(value=ModelDao.DAO_NAME)
public class ModelDaoImpl extends BaseDaoImpl<Model> implements ModelDao {

}
