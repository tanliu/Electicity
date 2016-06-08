package com.zhbit.transform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.entity.excel.PolstatusExcel;
import com.zhbit.entity.excel.TrainmasterExcel;

public class TrainmasterTransform implements BaseTransfrom{

	//将excel类的实体转化成存入数据库时的实体对象
	@Override
	public List<Object> toDBEntity(List excelObjs) {
		//创建list集合  存放 对象
        List<Object> Trainmaster = new ArrayList<Object>();
		
		//将对应的Excel实体类对象转化为真正的实体对象
		for(Object object:excelObjs){
			TrainmasterExcel trainmasterExcel=(TrainmasterExcel)object;//进行类型转换
			
			TraininfoMaster traininfoMaster=new TraininfoMaster();
		
			//设定创建时间
			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			traininfoMaster.setCreateTime(createtime);
			

			//设定好对应的各个属性值  并判断不为空
			if(!StringUtils.isEmpty(trainmasterExcel.getTrainsTopic())){
				traininfoMaster.setTrainsTopic(trainmasterExcel.getTrainsTopic());}
			
			if(!StringUtils.isEmpty(trainmasterExcel.getManager())){
				traininfoMaster.setManager(trainmasterExcel.getManager());}
			
			if(!StringUtils.isEmpty(trainmasterExcel.getTrainsAddress())){
				traininfoMaster.setTrainsAddress(trainmasterExcel.getTrainsAddress());}
			
			if(!StringUtils.isEmpty(trainmasterExcel.getMemo())){
				traininfoMaster.setMemo(trainmasterExcel.getMemo());}

			//设定入党日期 
			if(!StringUtils.isEmpty((trainmasterExcel.getTrainsDate()))){
				traininfoMaster.setTrainsDate(Timestamp.valueOf(trainmasterExcel.getTrainsDate().trim()+" 00:00:00"));}
			//将此对象放入集合Trainmaster中
			Trainmaster.add(traininfoMaster);
		}
		//返回对象集合 
		return Trainmaster;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		// TODO Auto-generated method stub
		return null;
	}

}
