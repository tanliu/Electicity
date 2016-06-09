package com.zhbit.services.guicontent;

import com.zhbit.entity.GuiContent;
import com.zhbit.entity.GuiContent;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface GuiContentServices extends BaseServices<GuiContent> {
	public   static final String SERVICES_NAME="com.zhbit.dao.impl.GuiContentServicesImpl";
	
	public PageUtils queryList(GuiContent guiContent, int pageNO, int pageSize);
	 
	 public GuiContent trimGuiContent(GuiContent guiContent);
}
