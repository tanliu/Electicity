package com.zhbit.dao.train.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.train.TraindetailDao;
import com.zhbit.entity.TraininfoDetail;




@Repository(value=TraindetailDao.DAO_NAME)
public class TraindetailDaoImpl extends BaseDaoImpl<TraininfoDetail> implements TraindetailDao{

}
