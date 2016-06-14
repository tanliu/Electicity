package com.zhbit.dao.stuentstatus.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.stuentstatus.StuStatusDao;
import com.zhbit.entity.StuStatus;


/** 
 * 项目名称：ElecRecord
 * 类名称： StuStatusDaoImpl
 * 类描述：用于处理学籍异动信息的Dao层实现类
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
@Repository(value=StuStatusDao.DAO_NAME)
public class StuStatusDaoImpl extends BaseDaoImpl<StuStatus> implements StuStatusDao{

	@Override
	public void saveStuStatuss(List<StuStatus> statuss) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdateAll(statuss);
	}
	
}
