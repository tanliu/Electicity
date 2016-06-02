package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.List;

import com.zhbit.entity.StuStatus;
import com.zhbit.entity.excel.StuStaEntity;

/** 
 * 项目名称：ElecRecord
 * 类名称： StuStatusTransform
 * 类描述：此类用于将excel实体对象转换为实体对象
 * 创建人：罗建鑫
 * 创建时间：2016年6月3日 上午1:48:24
 * 修改人：罗建鑫
 * 修改时间：2016年6月3日 上午1:48:24
 * 修改备注： 
 * @version 
 */ 
public class StuStatusTransform implements BaseTransfrom {

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		// TODO Auto-generated method stub
		
		List<Object> stuStatuss = null;
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
			StuStaEntity stuStaEntity=(StuStaEntity)object;//进行类型转换
			
			StuStatus stuStatus=new StuStatus();
			//首先设定好创建时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			stuStatus.setCreateTime(createtime);
			//设定好对应的各个属性值
			stuStatus.setTransactionNo(stuStaEntity.getTransactionNo());
			stuStatus.setStudentNo(stuStaEntity.getStudentNo());
			stuStatus.setStuName(stuStaEntity.getStuName());
			stuStatus.setSex(stuStaEntity.getSex());
			stuStatus.setAcademicYear(stuStaEntity.getAcademicYear());
			stuStatus.setTerm(stuStaEntity.getTerm());
			stuStatus.setTansactionClass(stuStaEntity.getTansactionClass());
			stuStatus.setProcessSymbols(stuStaEntity.getProcessSymbols());
			stuStatus.setTansactionType(stuStaEntity.getTansactionType());
			stuStatus.setTansactionReason(stuStaEntity.getTansactionReason());
			//设定异动时间
			stuStatus.setTansactionDate(Timestamp.valueOf(stuStaEntity.getTansactionDate()));
			//设定行文时间
			stuStatus.setHandleDate(Timestamp.valueOf(stuStaEntity.getHandleDate()));
			//设定撤消时间
			stuStatus.setCancelDate(Timestamp.valueOf(stuStaEntity.getCancelDate()));
			stuStatus.setTansactionMemo(stuStaEntity.getTansactionMemo());
			stuStatus.setZxqschool(stuStaEntity.getZxqschool());
			stuStatus.setZxqgrade(stuStaEntity.getZxqgrade());
			stuStatus.setZxqmajor(stuStaEntity.getZxqmajor());
			stuStatus.setYdqcollege(stuStaEntity.getYdqcollege());
			stuStatus.setYdqdepartment(stuStaEntity.getYdqdepartment());
			stuStatus.setYdqmajor(stuStaEntity.getYdqmajor());
			stuStatus.setYdqlength(stuStaEntity.getYdqlength());
			stuStatus.setYdqmajorField(stuStaEntity.getYdqmajorField());
			stuStatus.setYdqcultivateDirection(stuStaEntity.getYdqcultivateDirection());
			stuStatus.setYdqgrade(stuStaEntity.getYdqgrade());
			stuStatus.setYdqclassName(stuStaEntity.getYdqclassName());
			stuStatus.setYdqschoolStatus(stuStaEntity.getYdqschoolStatus());
			stuStatus.setZchschool(stuStaEntity.getZchschool());
			stuStatus.setZchgrade(stuStaEntity.getZchgrade());
			stuStatus.setZchmajor(stuStaEntity.getZchmajor());
			stuStatus.setYdhcollege(stuStaEntity.getYdhcollege());
			stuStatus.setYdhdepartment(stuStaEntity.getYdhdepartment());
			stuStatus.setYdhmajor(stuStaEntity.getYdhmajor());
			stuStatus.setYdhlength(stuStaEntity.getYdhlength());
			stuStatus.setYdhcultivatedirection(stuStaEntity.getYdhcultivatedirection());
			stuStatus.setYdhgrade(stuStaEntity.getYdhgrade());
			stuStatus.setYdhschoolStatus(stuStaEntity.getYdhschoolStatus());
			stuStatus.setOperator(stuStaEntity.getOperator());
			//设定操作日期
			stuStatus.setOperatorTime(Timestamp.valueOf(stuStaEntity.getOperatorTime()));
			stuStatus.setYdqinSchool(stuStaEntity.getYdqinSchool());
			stuStatus.setYdhinSchool(stuStaEntity.getYdhinSchool());
			stuStatus.setYdqmajorCode(stuStaEntity.getYdqmajorCode());
			stuStatus.setYdhmajorCode(stuStaEntity.getYdhmajorCode());
			stuStatus.setYdqisRegiste(stuStaEntity.getYdqisRegiste());
			stuStatus.setYdhisRegiste(stuStaEntity.getYdhisRegiste());
			stuStatus.setMemo(stuStaEntity.getMemo());
			stuStatus.setYdqeducation(stuStaEntity.getYdqeducation());
			stuStatus.setYdheducation(stuStaEntity.getYdheducation());
			stuStatus.setYdqmajorCategory(stuStaEntity.getYdqmajorCategory());
			stuStatus.setYdhmajorCategory(stuStaEntity.getYdhmajorCategory());
			stuStatus.setYdresult(stuStaEntity.getYdresult());
			stuStatus.setStudentCategory(stuStaEntity.getStudentCategory());
			stuStatus.setExaminateNo(stuStaEntity.getExaminateNo());
			stuStatus.setIdCardNo(stuStaEntity.getIdCardNo());
			
			//将此对象放入集合中
			stuStatuss.add(stuStatus);
		}
		return stuStatuss;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
