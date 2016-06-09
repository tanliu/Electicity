package com.zhbit.dao.guicontent.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.guicontent.GuiContentDao;
import com.zhbit.entity.GuiContent;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Repository(value=GuiContentDao.DAO_NAME)
public class GuiContentDaoImpl extends BaseDaoImpl<GuiContent> implements GuiContentDao {

	
}
