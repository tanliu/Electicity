package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhbit.entity.StuStatus;
import com.zhbit.entity.excel.StuStaEntity;

import org.apache.commons.lang3.StringUtils;

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
		
		List<Object> stuStatuss = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
			StuStaEntity stuStaEntity=(StuStaEntity)object;//进行类型转换
			
			StuStatus stuStatus=new StuStatus();
			//将stuid设定死
			stuStatus.setStuId("9527");
			//首先设定好创建时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			stuStatus.setCreateTime(createtime);
			//设定好对应的各个属性值
			if(!StringUtils.isEmpty(stuStaEntity.getTransactionNo())){
				stuStatus.setTransactionNo(stuStaEntity.getTransactionNo().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getStudentNo())){
				stuStatus.setStudentNo(stuStaEntity.getStudentNo().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getStuName())){
				stuStatus.setStuName(stuStaEntity.getStuName().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getSex())){
				stuStatus.setSex(stuStaEntity.getSex().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getAcademicYear())){
				stuStatus.setAcademicYear(stuStaEntity.getAcademicYear().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getTerm())){
				stuStatus.setTerm(stuStaEntity.getTerm().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getTansactionClass())){
				stuStatus.setTansactionClass(stuStaEntity.getTansactionClass().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getProcessSymbols())){
				stuStatus.setProcessSymbols(stuStaEntity.getProcessSymbols().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getTansactionType())){
				stuStatus.setTansactionType(stuStaEntity.getTansactionType().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getTansactionReason())){
				stuStatus.setTansactionReason(stuStaEntity.getTansactionReason().trim());
			}
			//设定异动时间，这里要先判断传过来的值是否为空
			if(!StringUtils.isEmpty((stuStaEntity.getTansactionDate()))){
				stuStatus.setTansactionDate(Timestamp.valueOf(stuStaEntity.getTansactionDate().trim()+" 00:00:00"));
			}
			//设定行文时间，这里要先判断传过来的值是否为空
			if(!StringUtils.isEmpty(stuStaEntity.getHandleDate())){
				stuStatus.setHandleDate(Timestamp.valueOf(stuStaEntity.getHandleDate().trim()+" 00:00:00"));
			}
			//设定撤消时间，这里要先判断传过来的值是否为空
			if(!StringUtils.isEmpty(stuStaEntity.getCancelDate())){
				stuStatus.setCancelDate(Timestamp.valueOf(stuStaEntity.getCancelDate().trim()+" 00:00:00"));
			}
			if(!StringUtils.isEmpty(stuStaEntity.getTansactionMemo())){
				stuStatus.setTansactionMemo(stuStaEntity.getTansactionMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZxqschool())){
				stuStatus.setZxqschool(stuStaEntity.getZxqschool().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZxqgrade())){
				stuStatus.setZxqgrade(stuStaEntity.getZxqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZxqmajor())){
				stuStatus.setZxqmajor(stuStaEntity.getZxqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqcollege())){
				stuStatus.setYdqcollege(stuStaEntity.getYdqcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqdepartment())){
				stuStatus.setYdqdepartment(stuStaEntity.getYdqdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqmajor())){
				stuStatus.setYdqmajor(stuStaEntity.getYdqmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqlength())){
				stuStatus.setYdqlength(stuStaEntity.getYdqlength().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqmajorField())){
				stuStatus.setYdqmajorField(stuStaEntity.getYdqmajorField().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqcultivateDirection())){
				stuStatus.setYdqcultivateDirection(stuStaEntity.getYdqcultivateDirection().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqgrade())){
				stuStatus.setYdqgrade(stuStaEntity.getYdqgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqclassName())){
				stuStatus.setYdqclassName(stuStaEntity.getYdqclassName().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqschoolStatus())){
				stuStatus.setYdqschoolStatus(stuStaEntity.getYdqschoolStatus().trim().equals("有")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZchschool())){
				stuStatus.setZchschool(stuStaEntity.getZchschool().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZchgrade())){
				stuStatus.setZchgrade(stuStaEntity.getZchgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getZchmajor())){
				stuStatus.setZchmajor(stuStaEntity.getZchmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhcollege())){
				stuStatus.setYdhcollege(stuStaEntity.getYdhcollege().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhdepartment())){
				stuStatus.setYdhdepartment(stuStaEntity.getYdhdepartment().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhmajor())){
				stuStatus.setYdhmajor(stuStaEntity.getYdhmajor().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhlength())){
				stuStatus.setYdhlength(stuStaEntity.getYdhlength().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhcultivatedirection())){
				stuStatus.setYdhcultivatedirection(stuStaEntity.getYdhcultivatedirection().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhgrade())){
				stuStatus.setYdhgrade(stuStaEntity.getYdhgrade().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhschoolStatus())){
				stuStatus.setYdhschoolStatus(stuStaEntity.getYdhschoolStatus().trim().equals("有")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStaEntity.getOperator())){
				stuStatus.setOperator(stuStaEntity.getOperator().trim());
			}
			
			//设定操作日期，这里要先判断传过来的值是否为空
			if(!StringUtils.isEmpty(stuStaEntity.getOperatorTime())){
			stuStatus.setOperatorTime(Timestamp.valueOf(stuStaEntity.getOperatorTime().trim()));
			}
			//将对应的是否异动前在校的信息转换为"0，1"
			if(!StringUtils.isEmpty(stuStaEntity.getYdqinSchool())){
				stuStatus.setYdqinSchool(stuStaEntity.getYdqinSchool().trim().equals("是")?"1":"0");
			}
			//将对应的是否异动前在校的信息转换为"0，1"
			if(!StringUtils.isEmpty(stuStaEntity.getYdhinSchool())){
				stuStatus.setYdhinSchool(stuStaEntity.getYdhinSchool().trim().equals("是")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqmajorCode())){
				stuStatus.setYdqmajorCode(stuStaEntity.getYdqmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhmajorCode())){
				stuStatus.setYdhmajorCode(stuStaEntity.getYdhmajorCode().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqisRegiste())){
				stuStatus.setYdqisRegiste(stuStaEntity.getYdqisRegiste().trim().equals("是")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhisRegiste())){
				stuStatus.setYdhisRegiste(stuStaEntity.getYdhisRegiste().trim().equals("是")?"1":"0");
			}
			if(!StringUtils.isEmpty(stuStaEntity.getMemo())){
				stuStatus.setMemo(stuStaEntity.getMemo().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqeducation())){
				stuStatus.setYdqeducation(stuStaEntity.getYdqeducation().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdheducation())){
				stuStatus.setYdheducation(stuStaEntity.getYdheducation().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdqmajorCategory())){
				stuStatus.setYdqmajorCategory(stuStaEntity.getYdqmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdhmajorCategory())){
				stuStatus.setYdhmajorCategory(stuStaEntity.getYdhmajorCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getYdresult())){
				stuStatus.setYdresult(stuStaEntity.getYdresult().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getStudentCategory())){
				stuStatus.setStudentCategory(stuStaEntity.getStudentCategory().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getExaminateNo())){
				stuStatus.setExaminateNo(stuStaEntity.getExaminateNo().trim());
			}
			if(!StringUtils.isEmpty(stuStaEntity.getIdCardNo())){
				stuStatus.setIdCardNo(stuStaEntity.getIdCardNo().trim());
			}
			
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
