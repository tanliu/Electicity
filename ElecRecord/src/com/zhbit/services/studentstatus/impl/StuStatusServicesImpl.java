package com.zhbit.services.studentstatus.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.stuentstatus.StuStatusDao;
import com.zhbit.entity.StuStatus;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.studentstatus.StuStatusServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： StuStatusServicesImpl
 * 类描述：用于处理学籍异动信息的Services实现类
 * 创建人：罗建鑫
 * 创建时间：2016年5月26日 上午10:43:11
 * 修改人：罗建鑫
 * 修改时间：2016年5月26日 上午10:43:11
 * 修改备注： 
 * @version 
 */ 
@Service(value=StuStatusServices.SERVICE_NAME)
public class StuStatusServicesImpl extends BaseServicesImpl<StuStatus> implements StuStatusServices {

	StuStatusDao stuStatusDao;
	@Resource(name=StuStatusDao.DAO_NAME)
	public void setStuStatusDao(StuStatusDao stuStatusDao) {
		super.setBaseDao(stuStatusDao);
		this.stuStatusDao = stuStatusDao;
	}
	

}
