package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zhbit.entity.Tutor;
import com.zhbit.entity.excel.TutorEntity;

public class TutorTransform implements BaseTransfrom {

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		// TODO Auto-generated method stub
		List<Object> tutors = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
				TutorEntity tutorEntity=(TutorEntity) object;
				
				if(tutorEntity.getXuhao()!=null||tutorEntity.getStudentNo()!=null){//当序号或学号不为空时，才进行转换操作
					Tutor tutor=new Tutor();
					
					//将stuid设定死
					tutor.setStuId("9528");
					//首先设定好创建时间
					Timestamp createtime = new Timestamp(System.currentTimeMillis());
					tutor.setCreateTime(createtime);
					
					//设定好对应的各个属性值
					if(!StringUtils.isEmpty(tutorEntity.getStudentNo())){
						tutor.setStudentNo(tutorEntity.getStudentNo().trim());
					}
					if(!StringUtils.isEmpty(tutorEntity.getClassName())){
						tutor.setClassName(tutorEntity.getClassName().trim());
					}
					
					if(!StringUtils.isEmpty(tutorEntity.getStuName())){
						tutor.setStuName(tutorEntity.getStuName().trim());
					}
					//对于辅导时间要进行相应的转换处理
					if(!StringUtils.isEmpty(tutorEntity.getGuidDate())){
						tutor.setGuidDate(Timestamp.valueOf(tutorEntity.getGuidDate().trim()));
					}
					if(!StringUtils.isEmpty(tutorEntity.getGuidContent())){
						tutor.setGuidContent(tutorEntity.getGuidContent().trim());
					}
					if(!StringUtils.isEmpty(tutorEntity.getDemo())){
						tutor.setDemo(tutorEntity.getDemo().trim());
					}
					
					tutors.add(tutor);
				}
				
		}
		
		return tutors;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
