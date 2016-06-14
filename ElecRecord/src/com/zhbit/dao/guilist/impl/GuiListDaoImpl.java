package com.zhbit.dao.guilist.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.guilist.GuiListDao;
import com.zhbit.entity.GuiList;

@Repository(value=GuiListDao.DAO_NAME)
public class GuiListDaoImpl extends BaseDaoImpl<GuiList> implements GuiListDao {
	
	//批量添加guiList信息
	@Override
	public void saveGuiLists(List<GuiList> guiLists){
		getHibernateTemplate().saveOrUpdateAll(guiLists);
	}
}
