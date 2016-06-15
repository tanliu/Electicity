package com.zhbit.dao.guicontent;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.GuiContent;

public interface GuiContentDao extends BaseDao<GuiContent> {
	public static final String DAO_NAME="com.zhbit.dao.impl.GuiContentDaoImpl";
	
	public void saveGuiContents(List<GuiContent> guiContents);
}
