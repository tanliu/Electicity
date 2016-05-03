/**
 * 
 */
package com.zhbit.services;

import java.io.Serializable;
import java.util.List;

import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：BaseServices 
 * 类描述： Services层的基类
 * 创建人：谭柳
 * 创建时间：2016年4月26日 上午10:56:12
 * 修改人：谭柳
 * 修改时间：2016年4月26日 上午10:56:12
 * 修改备注： 
 * @version 
 */
public interface BaseServices<T> {

	/**
	 * 方法描述:保存对象
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 方法描述:更新对象
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 方法描述:删除一个实体
	 * @param ids
	 */
	void deleteObjectByIds(Serializable... ids);
	/**
	 * 方法描述:批量删除
	 * @param list
	 */
	void deleteObjectByCollection(List<T> list);
	/**
	 * 方法描述:通过id查找对象
	 * @param entity
	 */
	public T findObjectById(Serializable id);
	/**
	 * 方法描述:获取分布工具
	 * @param queryUtils 查询工具
	 * @param pageNO 当前页
	 * @param pageSize 页码大小
	 * @return
	 */
	public PageUtils getPageUtils(QueryUtils queryUtils, int pageNO,
			int pageSize);
	
	/**
	 * 方法描述:能过某个字段查找对象
	 * @param queryUtils
	 * @return
	 */
	public List<T> findObjectByFields(QueryUtils queryUtils);

	
	

}
