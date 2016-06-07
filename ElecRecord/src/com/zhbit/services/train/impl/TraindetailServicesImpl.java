package com.zhbit.services.train.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.train.TraindetailDao;
import com.zhbit.entity.TraininfoDetail;

import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.train.TraindetailServices;

import com.zhbit.util.PageUtils;



@Service(value=TraindetailServices.SERVICES_NAME)
public class TraindetailServicesImpl extends BaseServicesImpl<TraininfoDetail> implements
TraindetailServices{

	//初始化Dao层
    TraindetailDao traindetailDao;
	@Resource(name=TraindetailDao.DAO_NAME)
	 public void setTrainDao(TraindetailDao traindetailDao) {
   	super.setBaseDao(traindetailDao);
		this.traindetailDao = traindetailDao;
	}
	
	@Override
	public PageUtils queryList(TraininfoDetail traininfoDetail, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
