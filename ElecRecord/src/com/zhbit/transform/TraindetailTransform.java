package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.excel.TraindetailExcel;



public class TraindetailTransform implements BaseTransfrom{

	//将excel类的实体转化成存入数据库时的实体对象
	@Override
	public List<Object> toDBEntity(List excelObjs) {
		//创建list集合  存放 对象
        List<Object> Traindetail = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
			TraindetailExcel traindetailExcel=(TraindetailExcel)object;//进行类型转换
			
			TraininfoDetail traininfoDetail=new TraininfoDetail();
			//设置一个默认stu_id
			traininfoDetail.setStuId("9527");
			//设置一个默认
			traininfoDetail.setMaster_id("437464");
			//设定创建时间
			//Timestamp createtime = new Timestamp(System.currentTimeMillis());
			//traininfoDetail.setCreateTime(createtime);
			

			//设定好对应的各个属性值  并判断不为空
			if(!StringUtils.isEmpty(traindetailExcel.getStudentNo())){
				traininfoDetail.setStudentNo(traindetailExcel.getStudentNo());}
			
			if(!StringUtils.isEmpty(traindetailExcel.getStuName())){
				traininfoDetail.setStuName(traindetailExcel.getStuName());}
			
			if(!StringUtils.isEmpty(traindetailExcel.getMaster_trainsTopic())){
				traininfoDetail.setMaster_trainsTopic(traindetailExcel.getMaster_trainsTopic());}
			

			if(!StringUtils.isEmpty(traindetailExcel.getTrainsResult())){
				traininfoDetail.setTrainsResult(traindetailExcel.getTrainsResult());}
			
			if(!StringUtils.isEmpty(traindetailExcel.getMemo())){
				traininfoDetail.setMemo(traindetailExcel.getMemo());}

			//设定入党日期 
			//if(!StringUtils.isEmpty((polstatusExcel.getJoinDate()))){
			//politicalstatus.setJoinDate(Timestamp.valueOf(polstatusExcel.getJoinDate().trim()+" 00:00:00"));}
			//将此对象放入集合Polstatus中
			//Polstatus.add(politicalstatus);
		}
		//返回对象集合 
		return Traindetail;
	}

	
	
	
	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
