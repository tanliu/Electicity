/**
 * 
 */
package com.zhbit.services.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.system.ModelDao;
import com.zhbit.entity.Model;
import com.zhbit.services.BaseServices;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.ModelServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：ModelServicesImpl 
 * 类描述： 模板Services层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月22日 上午11:23:51
 * 修改人：TanLiu 
 * 修改时间：2016年6月22日 上午11:23:51
 * 修改备注： 
 * @version 
 */
@Service(value=ModelServices.SERVICES_NAME)
public class ModelServicesImpl extends BaseServicesImpl<Model> implements ModelServices {
	ModelDao modelDao;
	@Resource(name=ModelDao.DAO_NAME)
	public void setModelDao(ModelDao modelDao) {
		setBaseDao(modelDao);
		this.modelDao = modelDao;
	}

	
}
