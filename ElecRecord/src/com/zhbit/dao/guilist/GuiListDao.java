package com.zhbit.dao.guilist;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.GuiList;

public interface GuiListDao extends BaseDao<GuiList> {
	public static final String DAO_NAME="com.zhbit.dao.guilist.impl.GuiListDaoImpl";
	
	public void saveGuiLists(List<GuiList> guiLists);
}
