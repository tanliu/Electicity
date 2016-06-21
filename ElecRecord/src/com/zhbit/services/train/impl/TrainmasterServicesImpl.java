package com.zhbit.services.train.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import com.zhbit.dao.train.TrainmasterDao;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.services.BaseServicesImpl;

import com.zhbit.services.train.TrainmasterServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：TrainmasterServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:48:15
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:48:15
 * 修改备注： 
 * @version 
 */
@Service(value=TrainmasterServices.SERVICES_NAME)
public class TrainmasterServicesImpl extends BaseServicesImpl<TraininfoMaster> implements
TrainmasterServices{
	//初始化Dao层
	Timestamp nextday;
	     TrainmasterDao trainmasterDao;
		@Resource(name=TrainmasterDao.DAO_NAME)
		 public void setTrainDao(TrainmasterDao trainmasterDao) {
	    	super.setBaseDao(trainmasterDao);
			this.trainmasterDao = trainmasterDao;
		}
		@Override
		public PageUtils queryList(TraininfoMaster traininfoMaster, int pageNO, int pageSize) {
			String[] fields=null;
			Object[] params=null;
			
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
			  //用于查询某个具体日期的数据
				if(traininfoMaster.getTrainsDate()!=null){
					long time=traininfoMaster.getTrainsDate().getTime();
					//下一天的时间,用于查询当天到下一天的所有
					time=time+24*60*60*1000; 
					nextday=new Timestamp(time);
				}
				////多个查询条件组合
				if(traininfoMaster!=null){ //politicalstatus不为空时
					if(traininfoMaster.getTrainsDate()!=null){
						fields=new String[]{"trainsDate>=?","trainsDate<?","trainsTopic like ?","manager like ?"};
						params=new Object[]{traininfoMaster.getTrainsDate(),nextday,"%"+traininfoMaster.getTrainsTopic()+"%","%"+traininfoMaster.getManager()+"%"};
					}else if(!StringUtils.isEmpty(traininfoMaster.getManager())){ //查询条件是用户名
						fields=new String[]{"manager like ?","trainsTopic like ?"};
						params=new Object[]{"%"+traininfoMaster.getManager()+"%","%"+traininfoMaster.getTrainsTopic()+"%"};	
					}else if(!StringUtils.isEmpty(traininfoMaster.getTrainsTopic())){ //查询条件
						fields=new String[]{"trainsTopic like ?","manager like ?"};
						params=new Object[]{"%"+traininfoMaster.getTrainsTopic()+"%","%"+traininfoMaster.getManager()+"%"};
				}
			}
			}
			// TODO Auto-generated method stub
			return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
		}
		/**
		 * 方法描述:重写getPageUtils方法，因为此模块的查询条件中有比较特殊(时间日期查询)的查询条件
		 * @param
		 * @param 
		 */
	@Override
	public PageUtils getPageUtils(String[] fields, Object[] params, String proterty, String order, int pageNO,
			int pageSize) {
		
		// TODO Auto-generated method stub
		QueryUtils queryUtils=new QueryUtils(TraininfoMaster.class, "entity");
		//添加查询条件
		if(fields!=null&&fields.length>0&&params!=null&&params.length>0&&fields.length==params.length){
			for(int i=0;i<fields.length;i++){
				if(!StringUtils.isEmpty(fields[i])&&!StringUtils.isEmpty((params[i])+"")){
					queryUtils.addCondition("entity."+fields[i], params[i]);				
				}
			}
		}
		
		//添加排序
		if(!StringUtils.isEmpty(proterty)&&!StringUtils.isEmpty(order)){
			queryUtils.addOrderByProperty("entity."+proterty, order);
		}
		
		return trainmasterDao.getPageUtils(queryUtils, pageNO, pageSize);
		
	}
		@Override
		public void saveFromExcel(List<Object> traininfoMasters, String creator) {
			
			if(traininfoMasters!=null&&traininfoMasters.size()>0){
				//对每一条数据进行校验和设置相应的值
				for (Object object : traininfoMasters) {
					TraininfoMaster traininfoMaster=(TraininfoMaster) object;
					//获取学生的学号,将学号赋给politicalstatus实体。
					//Student student=studentServices.getStudentByNo(politicalstatus.getStudentNo());
					//politicalstatus.setStuId(student.getStuId());

					String[] fields;
					Object[] params;
					
	               fields=new String[]{"manager=?","trainsTopic=?"};
	               params=new Object[]{traininfoMaster.getManager(),traininfoMaster.getTrainsTopic()};
	               if(this.findObjectByFields(fields, params)==null){
	            	   //先查询要插入的数据系统中是否为空，为空才插入
					//这里先设置一个值用来测试
					//politicalstatus.setStuId("9527");
					traininfoMaster.setCreator(creator);
					traininfoMaster.setCreateTime(new Timestamp(new Date().getTime()));
					this.save(traininfoMaster);
				}
				}
			}
			
			
		}
		
}
