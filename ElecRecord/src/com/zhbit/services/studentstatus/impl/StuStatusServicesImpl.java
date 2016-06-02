package com.zhbit.services.studentstatus.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.stuentstatus.StuStatusDao;
import com.zhbit.entity.StuStatus;
import com.zhbit.entity.User;
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
	
	/**
		 * 方法描述:此方法用于根据用户选择的查询条件返回相应的查询结果
		 * @param
		 * @param 
		 */
	@Override
	public PageUtils queryList(StuStatus stuStatus, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";		
		if(stuStatus!=null){ //当stuStatus不为空时
			if(!StringUtils.isEmpty(stuStatus.getAcademicYear())){
				fields=new String[]{"academicYear=?","studentNo=?","stuName like ?"};
				params=new String[]{stuStatus.getAcademicYear(),stuStatus.getStudentNo(),"%"+stuStatus.getStuName()+"%"};
			}
			else if(!StringUtils.isEmpty(stuStatus.getStudentNo())){
				fields=new String[]{"studentNo=?","academicYear=?","stuName like ?"};
				params=new String[]{stuStatus.getStudentNo(),stuStatus.getAcademicYear(),"%"+stuStatus.getStuName()+"%"};
			}
			else if(!StringUtils.isEmpty(stuStatus.getStuName())){
				fields=new String[]{"stuName like ?","academicYear=?","studentNo=?"};
				params=new String[]{"%"+stuStatus.getStuName()+"%",stuStatus.getAcademicYear(),stuStatus.getStudentNo()};
			}
			
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

	
}
