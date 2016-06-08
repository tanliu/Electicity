package com.zhbit.services.studentstatus.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
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
			//先去除学号和姓名中可能存在的空格
			if(!StringUtils.isEmpty(stuStatus.getStuName())){
				stuStatus.setStuName(stuStatus.getStuName().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStudentNo())){
				stuStatus.setStudentNo(stuStatus.getStudentNo().trim());
			}
				fields=new String[]{"academicYear=?","studentNo=?","stuName like ?"};
				params=new String[]{stuStatus.getAcademicYear(),stuStatus.getStudentNo(),"%"+stuStatus.getStuName()+"%"};
			
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

	/**
		 * 方法描述:此方法用于在将数据存入数据库前去除其前后的字符串
		 * @param
		 * @param 
		 */
	@Override
	public StuStatus trimStustatus(StuStatus stuStatus) {
		// TODO Auto-generated method stub
		if(stuStatus!=null){
			if(!StringUtils.isEmpty(stuStatus.getTransactionNo())){
				stuStatus.setTransactionNo(stuStatus.getTransactionNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStudentNo())){
				stuStatus.setStudentNo(stuStatus.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStuName())){
				stuStatus.setStuName(stuStatus.getStuName().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getSex())){
				stuStatus.setSex(stuStatus.getSex().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getAcademicYear())){
				stuStatus.setAcademicYear(stuStatus.getAcademicYear().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTerm())){
				stuStatus.setTerm(stuStatus.getTerm().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionClass())){
				stuStatus.setTansactionClass(stuStatus.getTansactionClass().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getProcessSymbols())){
				stuStatus.setProcessSymbols(stuStatus.getProcessSymbols().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionType())){
				stuStatus.setTansactionType(stuStatus.getTansactionType().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionReason())){
				stuStatus.setTansactionReason(stuStatus.getTansactionReason().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionMemo())){
				stuStatus.setTansactionMemo(stuStatus.getTansactionMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqschool())){
				stuStatus.setZxqschool(stuStatus.getZxqschool().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqgrade())){
				stuStatus.setZxqgrade(stuStatus.getZxqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqmajor())){
				stuStatus.setZxqmajor(stuStatus.getZxqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqcollege())){
				stuStatus.setYdqcollege(stuStatus.getYdqcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqdepartment())){
				stuStatus.setYdqdepartment(stuStatus.getYdqdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajor())){
				stuStatus.setYdqmajor(stuStatus.getYdqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqlength())){
				stuStatus.setYdqlength(stuStatus.getYdqlength().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorField())){
				stuStatus.setYdqmajorField(stuStatus.getYdqmajorField().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqcultivateDirection())){
				stuStatus.setYdqcultivateDirection(stuStatus.getYdqcultivateDirection().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqgrade())){
				stuStatus.setYdqgrade(stuStatus.getYdqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqclassName())){
				stuStatus.setYdqclassName(stuStatus.getYdqclassName().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqschoolStatus())){
				stuStatus.setYdqschoolStatus(stuStatus.getYdqschoolStatus().trim().equals("有")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStatus.getZchschool())){
				stuStatus.setZchschool(stuStatus.getZchschool().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZchgrade())){
				stuStatus.setZchgrade(stuStatus.getZchgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZchmajor())){
				stuStatus.setZchmajor(stuStatus.getZchmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhcollege())){
				stuStatus.setYdhcollege(stuStatus.getYdhcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhdepartment())){
				stuStatus.setYdhdepartment(stuStatus.getYdhdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajor())){
				stuStatus.setYdhmajor(stuStatus.getYdhmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhlength())){
				stuStatus.setYdhlength(stuStatus.getYdhlength().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhcultivatedirection())){
				stuStatus.setYdhcultivatedirection(stuStatus.getYdhcultivatedirection().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhgrade())){
				stuStatus.setYdhgrade(stuStatus.getYdhgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhschoolStatus())){
				stuStatus.setYdhschoolStatus(stuStatus.getYdhschoolStatus().trim().equals("有")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStatus.getOperator())){
				stuStatus.setOperator(stuStatus.getOperator().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorCode())){
				stuStatus.setYdqmajorCode(stuStatus.getYdqmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajorCode())){
				stuStatus.setYdhmajorCode(stuStatus.getYdhmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getMemo())){
				stuStatus.setMemo(stuStatus.getMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqeducation())){
				stuStatus.setYdqeducation(stuStatus.getYdqeducation().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdheducation())){
				stuStatus.setYdheducation(stuStatus.getYdheducation().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorCategory())){
				stuStatus.setYdqmajorCategory(stuStatus.getYdqmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajorCategory())){
				stuStatus.setYdhmajorCategory(stuStatus.getYdhmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdresult())){
				stuStatus.setYdresult(stuStatus.getYdresult().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStudentCategory())){
				stuStatus.setStudentCategory(stuStatus.getStudentCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getExaminateNo())){
				stuStatus.setExaminateNo(stuStatus.getExaminateNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getIdCardNo())){
				stuStatus.setIdCardNo(stuStatus.getIdCardNo().trim());
			}
		}
		return stuStatus;
	}
}
