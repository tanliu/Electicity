package com.zhbit.transform;

import java.lang.management.PlatformLoggingMXBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.StuStatus;
import com.zhbit.entity.excel.PolstatusExcel;
import org.apache.commons.lang3.StringUtils;

public class PolstatusTransform implements BaseTransfrom{

	
	//将excel类的实体转化成存入数据库时的实体对象
	@Override
	public List<Object> toDBEntity(List excelObjs) {
		// TODO Auto-generated method stub
		//创建list集合  存放 对象
        List<Object> Polstatus = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
			PolstatusExcel polstatusExcel=(PolstatusExcel)object;//进行类型转换
			
			Politicalstatus politicalstatus=new Politicalstatus();
			//设置一个默认stu_id
			politicalstatus.setStuId("9527");
			//设定创建时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			politicalstatus.setCreateTime(createtime);
			

			//设定好对应的各个属性值  并判断不为空
			if(!StringUtils.isEmpty(polstatusExcel.getStudentNo())){
			politicalstatus.setStudentNo(polstatusExcel.getStudentNo());}
			
			if(!StringUtils.isEmpty(polstatusExcel.getStuName())){
			politicalstatus.setStuName(polstatusExcel.getStuName());}
			
			if(!StringUtils.isEmpty(polstatusExcel.getPoliticalStatus())){
			politicalstatus.setPoliticalStatus(polstatusExcel.getPoliticalStatus());}
			
			if(!StringUtils.isEmpty(polstatusExcel.getMemo())){
			politicalstatus.setMemo(polstatusExcel.getMemo());}

			//设定入党日期 
			if(!StringUtils.isEmpty((polstatusExcel.getJoinDate()))){
			politicalstatus.setJoinDate(Timestamp.valueOf(polstatusExcel.getJoinDate().trim()+" 00:00:00"));}
			//将此对象放入集合Polstatus中
			Polstatus.add(politicalstatus);
		}
		//返回对象集合 
		return Polstatus;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
