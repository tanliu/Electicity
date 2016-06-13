package com.zhbit.services.comscholarship.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.comscholarship.ComscholarshipDao;
import com.zhbit.entity.CommonScholarship;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.comscholarship.ComscholarshipServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;




/** 
 * 项目名称：ElecRecord
 * 类名称：ComscholarshipServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月12日 下午7:55:21
 * 修改人：罗吉林
 * 修改时间：2016年6月12日 下午7:55:21
 * 修改备注： 
 * @version 
 */
@Service(value=ComscholarshipServices.SERVICES_NAME)
public class ComscholarshipServicesImpl extends BaseServicesImpl<CommonScholarship> implements
ComscholarshipServices{

	//初始化Dao层
		ComscholarshipDao comscholarshipDao;
			@Resource(name=ComscholarshipDao.DAO_NAME)
			 public void setPolstatusDao(ComscholarshipDao comscholarshipDao) {
		    	super.setBaseDao(comscholarshipDao);
				this.comscholarshipDao = comscholarshipDao;
			}
	@Override
	public PageUtils queryList(CommonScholarship commonScholarship, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		if(commonScholarship!=null){ //判定countryScholarship不为空时
			
			//先去除存在的空格
			if(!StringUtils.isEmpty(commonScholarship.getStuName())){
				commonScholarship.setStuName(commonScholarship.getStuName().trim());
		    }
		    if(!StringUtils.isEmpty(commonScholarship.getMajor())){
		    	commonScholarship.setMajor(commonScholarship.getMajor().trim());
			}
		    if(!StringUtils.isEmpty(commonScholarship.getRewardName())){
		    	commonScholarship.setRewardName(commonScholarship.getRewardName().trim());
			}
			////多个查询条件组合
			if(!StringUtils.isEmpty(commonScholarship.getStuName())){ 
				//查询语句组合
				fields=new String[]{"stuName like ?","major=?","rewardName=?"};
				params=new String[]{"%"+commonScholarship.getStuName()+"%",commonScholarship.getMajor(),commonScholarship.getRewardName()};
			}else if(!StringUtils.isEmpty(commonScholarship.getMajor())){
				fields=new String[]{"major=?","stuName like ?","rewardName=?"};
				params=new String[]{commonScholarship.getMajor(),"%"+commonScholarship.getStuName()+"%",commonScholarship.getRewardName()};
			}else if(!StringUtils.isEmpty(commonScholarship.getRewardName())){
				fields=new String[]{"rewardName=?","orgName=?","stuName like ?",};
				params=new String[]{commonScholarship.getRewardName(),commonScholarship.getMajor(),"%"+commonScholarship.getStuName()+"%"};
			}
		}
		// TODO Auto-generated method stub
		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	
	}


}
