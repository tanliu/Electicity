package com.zhbit.services.train.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.train.TraindetailDao;
import com.zhbit.entity.Student;
import com.zhbit.entity.TraininfoDetail;
import com.zhbit.entity.TraininfoMaster;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.StudentServices;
import com.zhbit.services.train.TraindetailServices;
import com.zhbit.services.train.TrainmasterServices;
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
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	//注入TrainmasterServices
	@Resource(name=TrainmasterServices.SERVICES_NAME)
	TrainmasterServices trainmasterServices;
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

	@Override
	public void saveFromExcel(List<Object> traininfoDetails) {
		//对每一条数据进行校验和设置相应的值
		for (Object object : traininfoDetails) {
			TraininfoDetail traininfoDetail=(TraininfoDetail) object;
			//获取到主题对应的ID
			TraininfoMaster traininfoMaster=getmasterID(traininfoDetail.getMaster_trainsTopic());
			//如果不为空 则赋值
			if(traininfoMaster!=null){
				traininfoDetail.setMaster_id(traininfoMaster.getId());
				String[] fields;
				Object[] params;
				
               fields=new String[]{"studentNo=?","master_trainsTopic=?"};
               params=new Object[]{traininfoDetail.getStudentNo(),traininfoDetail.getMaster_trainsTopic()};
               if(this.findObjectByFields(fields, params)==null){
               //获取学生的id,将学号赋给traininfoDetail实体。
      			Student student=studentServices.getStudentByNo(traininfoDetail.getStudentNo());
      			traininfoDetail.setStuId(student.getStuId());
				
				this.save(traininfoDetail);
			}
			}
		}
	}

	//获取主题对应的ID
	public TraininfoMaster getmasterID(String topic){
		String[] fields={"trainsTopic=?"};
		String[] params={topic};
		List<TraininfoMaster> traininfoMaster = trainmasterServices.findObjectByFields(fields, params);
		if(traininfoMaster!=null&&traininfoMaster.size()>0){
			return traininfoMaster.get(0);
		}
		return null;
	}
	

}
