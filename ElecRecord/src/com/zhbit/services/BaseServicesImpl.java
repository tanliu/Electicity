/**
 * 
 */
package com.zhbit.services;

import java.io.Serializable;
import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：BaseServicesImpl 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年4月26日 上午11:14:02
 * 修改人：谭柳
 * 修改时间：2016年4月26日 上午11:14:02
 * 修改备注： 
 * @version 
 */
public class BaseServicesImpl<T> implements BaseServices<T> {
	
	BaseDao<T> baseDao;
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		baseDao.deleteObjectByIds(ids);
	}

	@Override
	public void deleteObjectByCollection(List<T> list) {
		baseDao.deleteObjectByCollection(list);
	}

	@Override
	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	@Override
	public PageUtils getPageUtils(QueryUtils queryUtils, int pageNO,
			int pageSize) {
		// TODO Auto-generated method stub
		return baseDao.getPageUtils(queryUtils, pageNO, pageSize);
	}

	@Override
	public List<T> findObjectByFields(QueryUtils queryUtils) {
		return baseDao.findObjectByFields(queryUtils);
	}

	@Override
	public List<T> findAllObject(QueryUtils queryUtils) {
		return this.findObjectByFields(queryUtils);
	}
   

}
