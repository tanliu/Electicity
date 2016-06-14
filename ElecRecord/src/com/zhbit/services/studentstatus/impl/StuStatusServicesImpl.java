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
			if(!StringUtils.isEmpty(stuStatus.getTransactionNo())){//异动序号
				stuStatus.setTransactionNo(stuStatus.getTransactionNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStudentNo())){//学号
				stuStatus.setStudentNo(stuStatus.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStuName())){//姓名
				stuStatus.setStuName(stuStatus.getStuName().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getSex())){//性别
				stuStatus.setSex(stuStatus.getSex().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getAcademicYear())){//学年
				stuStatus.setAcademicYear(stuStatus.getAcademicYear().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTerm())){//学期
				stuStatus.setTerm(stuStatus.getTerm().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionClass())){//异动后行政班
				stuStatus.setTansactionClass(stuStatus.getTansactionClass().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getProcessSymbols())){//处理文号
				stuStatus.setProcessSymbols(stuStatus.getProcessSymbols().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionType())){//异动类别
				stuStatus.setTansactionType(stuStatus.getTansactionType().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionReason())){//异动原因
				stuStatus.setTansactionReason(stuStatus.getTansactionReason().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getTansactionMemo())){//异动说明
				stuStatus.setTansactionMemo(stuStatus.getTansactionMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqschool())){//转学前学校名称
				stuStatus.setZxqschool(stuStatus.getZxqschool().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqgrade())){//转学前所在年级
				stuStatus.setZxqgrade(stuStatus.getZxqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZxqmajor())){//转学前专业
				stuStatus.setZxqmajor(stuStatus.getZxqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqcollege())){//异动前学院
				stuStatus.setYdqcollege(stuStatus.getYdqcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqdepartment())){//异动前系
				stuStatus.setYdqdepartment(stuStatus.getYdqdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajor())){//异动前专业
				stuStatus.setYdqmajor(stuStatus.getYdqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqlength())){//异动前学制
				stuStatus.setYdqlength(stuStatus.getYdqlength().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorField())){//异动前专业方向
				stuStatus.setYdqmajorField(stuStatus.getYdqmajorField().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqcultivateDirection())){//异动前培养方向
				stuStatus.setYdqcultivateDirection(stuStatus.getYdqcultivateDirection().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqgrade())){//异动前所在年级
				stuStatus.setYdqgrade(stuStatus.getYdqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqclassName())){//异动前行政班
				stuStatus.setYdqclassName(stuStatus.getYdqclassName().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqschoolStatus())){//异动前学籍状态
				stuStatus.setYdqschoolStatus(stuStatus.getYdqschoolStatus().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZchschool())){//转出后学校名称
				stuStatus.setZchschool(stuStatus.getZchschool().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZchgrade())){//转出后年级
				stuStatus.setZchgrade(stuStatus.getZchgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getZchmajor())){//转出后专业
				stuStatus.setZchmajor(stuStatus.getZchmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhcollege())){//异动后学院
				stuStatus.setYdhcollege(stuStatus.getYdhcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhdepartment())){//异动后系
				stuStatus.setYdhdepartment(stuStatus.getYdhdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajor())){//异动后专业
				stuStatus.setYdhmajor(stuStatus.getYdhmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhlength())){//异动后学制
				stuStatus.setYdhlength(stuStatus.getYdhlength().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajorField())){//异动后专业方向
				stuStatus.setYdhmajorField(stuStatus.getYdhmajorField().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhcultivatedirection())){//异动后培养方向
				stuStatus.setYdhcultivatedirection(stuStatus.getYdhcultivatedirection().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhgrade())){//异动后所在年级
				stuStatus.setYdhgrade(stuStatus.getYdhgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhschoolStatus())){//异动后学籍状态
				stuStatus.setYdhschoolStatus(stuStatus.getYdhschoolStatus().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getOperator())){//操作人
				stuStatus.setOperator(stuStatus.getOperator().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorCode())){//异动前专业代码
				stuStatus.setYdqmajorCode(stuStatus.getYdqmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajorCode())){//异动后专业代码
				stuStatus.setYdhmajorCode(stuStatus.getYdhmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqisRegiste())){//异动前是否注册
				stuStatus.setYdqisRegiste(stuStatus.getYdqisRegiste().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhisRegiste())){//异动后是否注册
				stuStatus.setYdhisRegiste(stuStatus.getYdhisRegiste().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getMemo())){//备注
				stuStatus.setMemo(stuStatus.getMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqeducation())){//异动前学历层次
				stuStatus.setYdqeducation(stuStatus.getYdqeducation().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdheducation())){//异动后学历层次
				stuStatus.setYdheducation(stuStatus.getYdheducation().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqmajorCategory())){//异动前专业类别
				stuStatus.setYdqmajorCategory(stuStatus.getYdqmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhmajorCategory())){//异动后专业类别
				stuStatus.setYdhmajorCategory(stuStatus.getYdhmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdresult())){//异动结果
				stuStatus.setYdresult(stuStatus.getYdresult().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getStudentCategory())){//学生类别
				stuStatus.setStudentCategory(stuStatus.getStudentCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getExaminateNo())){//考生号
				stuStatus.setExaminateNo(stuStatus.getExaminateNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getIdCardNo())){//身份证号
				stuStatus.setIdCardNo(stuStatus.getIdCardNo().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdqinSchool())){//异动前是否在校
				stuStatus.setYdqinSchool(stuStatus.getYdqinSchool().trim());
			}
			if(!StringUtils.isEmpty(stuStatus.getYdhinSchool())){//异动后是否在校
				stuStatus.setYdhinSchool(stuStatus.getYdhinSchool().trim());
			}
		}
		return stuStatus;
	}

	@Override
	public void saveStatuss(List<StuStatus> stuStatus) {
		// TODO Auto-generated method stub
		stuStatusDao.saveStuStatuss(stuStatus);
	}
}
