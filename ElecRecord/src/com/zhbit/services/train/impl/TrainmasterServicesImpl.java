package com.zhbit.services.train.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import com.zhbit.dao.train.TrainmasterDao;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.services.BaseServicesImpl;

import com.zhbit.services.train.TrainmasterServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

@Service(value=TrainmasterServices.SERVICES_NAME)
public class TrainmasterServicesImpl extends BaseServicesImpl<TraininfoMaster> implements
TrainmasterServices{
	//初始化Dao层
	     TrainmasterDao trainmasterDao;
		@Resource(name=TrainmasterDao.DAO_NAME)
		 public void setTrainDao(TrainmasterDao trainmasterDao) {
	    	super.setBaseDao(trainmasterDao);
			this.trainmasterDao = trainmasterDao;
		}
		@Override
		public PageUtils queryList(TraininfoMaster traininfoMaster, int pageNO, int pageSize) {
			String[] fields=null;
			String[] params=null;
			//排序条件，根据创建时间去排序查出来的结果集
			String proterty="createTime";	
			
			if(traininfoMaster!=null){ //判定traininfoMaster不为空时
				
				//先去除存在的空格
				if(!StringUtils.isEmpty(traininfoMaster.getManager())){
					traininfoMaster.setManager(traininfoMaster.getManager().trim());
			    }
			    if(!StringUtils.isEmpty(traininfoMaster.getTrainsTopic())){
			    	traininfoMaster.setTrainsTopic(traininfoMaster.getTrainsTopic().trim());
				}
				////多个查询条件组合
				if(!StringUtils.isEmpty(traininfoMaster.getManager())){ 
					//查询语句组合
					fields=new String[]{"manager like ?","trainsTopic like ?"};
					params=new String[]{"%"+traininfoMaster.getManager()+"%",traininfoMaster.getTrainsTopic()};
				}else if(!StringUtils.isEmpty(traininfoMaster.getTrainsTopic())){
					fields=new String[]{"trainsTopic like ?","manager like ?",};
					params=new String[]{traininfoMaster.getTrainsTopic(),"%"+traininfoMaster.getManager()+"%"};
				}//else if(politicalstatus.getJoinDate()!=null){
					//politicalstatus.setJoinDate(new Timestamp(new Date().getTime()));
				//	String time=politicalstatus.getJoinDate();
					
				//	fields=new String[]{"joinDate=?"};
				//	params=new String[]{time};
				//}
			}
			// TODO Auto-generated method stub
			return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
		}

}
