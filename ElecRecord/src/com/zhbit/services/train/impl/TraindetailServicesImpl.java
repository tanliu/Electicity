package com.zhbit.services.train.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.train.TraindetailDao;
import com.zhbit.entity.TraininfoDetail;

import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.train.TraindetailServices;

import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;



/** 
 * 项目名称：ElecRecord
 * 类名称：TraindetailServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:08
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:08
 * 修改备注： 
 * @version 
 */
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
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="id";	
		
		if(traininfoDetail!=null){ //判定traininfoMaster不为空时
			
			//先去除存在的空格
			if(!StringUtils.isEmpty(traininfoDetail.getStuName())){
				traininfoDetail.setStuName(traininfoDetail.getStuName().trim());
		    }
		    if(!StringUtils.isEmpty(traininfoDetail.getTrainsResult())){
		    	traininfoDetail.setTrainsResult(traininfoDetail.getTrainsResult().trim());
			}
			////多个查询条件组合
			if(!StringUtils.isEmpty(traininfoDetail.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","trainsResult=?","master_trainsTopic=?"};
				params=new String[]{"%"+traininfoDetail.getStuName()+"%",traininfoDetail.getTrainsResult(),traininfoDetail.getMaster_trainsTopic()};
			}else if(!StringUtils.isEmpty(traininfoDetail.getTrainsResult())){
				fields=new String[]{"trainsResult=?","stuName like ?","master_trainsTopic=?"};
				params=new String[]{traininfoDetail.getTrainsResult(),"%"+traininfoDetail.getStuName()+"%",traininfoDetail.getMaster_trainsTopic()};
			}else if(!StringUtils.isEmpty(traininfoDetail.getMaster_trainsTopic())){
				fields=new String[]{"master_trainsTopic=?","trainsResult=?","stuName like ?",};
				params=new String[]{traininfoDetail.getMaster_trainsTopic(),traininfoDetail.getTrainsResult(),"%"+traininfoDetail.getStuName()+"%"};
			}
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}

}
