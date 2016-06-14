package com.zhbit.services.guilist;

import java.util.List;

import com.zhbit.entity.GuiContent;
import com.zhbit.entity.GuiList;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

public interface GuiListServices extends BaseServices<GuiList> {
	public  final static String SERVICES_NAME="com.zhbit.services.impl.GuiListServicesImpl";
	
	public GuiList trimGuiList(GuiList guiList);
	
	public void saveGuiLists(List<GuiList> guiLists);
	
	public PageUtils queryList(GuiList guiList, int pageNO, int pageSize);
}
