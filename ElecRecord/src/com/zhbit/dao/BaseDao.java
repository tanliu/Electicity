/**
 * 
 */
package com.zhbit.dao;

import java.io.Serializable;
import java.util.List;

import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：BaseDao 
 * 类描述： 是Dao层的基类，封装了增、删除、更改、查看、通过id查找对象、分页等方法
 * 创建人：坛子
 * 创建时间：2016年4月26日 上午8:40:19
 * 修改人：TanLiu 
 * 修改时间：2016年4月26日 上午8:40:19
 * 修改备注： 
 * @version 
 */
public interface BaseDao<T> {

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
	
    /**
     * 方法描述:保存或者更新一个实体
     * @param entity
     */
    public void saveOrUpdate(T entity);
    
    /**
     * 方法描述:保存或者更新一个集合
     * @param entity
     */
    public void saveOrUpdate(List<T> entitys);
    
    /**
     * 方法描述:保存或者更新一个集合
     * @param entity
     */
    public void saveAll(List<T> entitys);
    
}
