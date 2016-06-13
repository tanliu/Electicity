package com.zhbit.dao.guilist.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.guilist.GuiListDao;
import com.zhbit.entity.GuiList;

@Repository(value=GuiListDao.DAO_NAME)
public class GuiListDaoImpl extends BaseDaoImpl<GuiList> implements GuiListDao {
	
	public void test(){
		//getHibernateTemplate().saveOrUpdateAll(entities);
	}
}
