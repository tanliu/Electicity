package com.zhbit.dao.train.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;

import com.zhbit.dao.train.TrainmasterDao;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;

@Repository(value=TrainmasterDao.DAO_NAME)
public class TrainmasterDaoImpl extends BaseDaoImpl<TraininfoMaster> implements TrainmasterDao{

}
