package com.zhbit.services.polstatus.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zhbit.dao.polstatus.PolstatusDao;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Politicalstatus;
import com.zhbit.entity.Student;
import com.zhbit.entity.Tutor;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.polstatus.PolstatusServices;
import com.zhbit.services.student.StudentServices;
import com.zhbit.util.EncryptUtils;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;


/** 
 * 项目名称：ElecRecord
 * 类名称：PolstatusServicesImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年5月26日 上午11:07:52
 * 修改人：罗吉林
 * 修改时间：2016年5月26日 上午11:07:52
 * 修改备注： 
 * @version 
 */
@Service(value=PolstatusServices.SERVICES_NAME)
public class PolstatusServicesImpl extends BaseServicesImpl<Politicalstatus> implements
    PolstatusServices{
	
	@Resource(name=StudentServices.SERVICES_NAME)
	StudentServices studentServices;
	
	//初始化Dao层
	PolstatusDao polstatusDao;
	@Resource(name=PolstatusDao.DAO_NAME)
	 public void setPolstatusDao(PolstatusDao polstatusDao) {
    	super.setBaseDao(polstatusDao);
		this.polstatusDao = polstatusDao;
		
	}
	//调用Dao层的增加信息的add方法
	public String add(Politicalstatus politicalstatus){
		polstatusDao.add(politicalstatus);
		return null;
	}
	
	
	//继承Services接口的queryList方法，实现数据查询
	@Override
	public PageUtils queryList(Politicalstatus politicalstatus, int pageNO, int pageSize) {
		String[] fields=null;
		Object[] params=null;
		//排序条件，根据创建时间去排序查出来的结果集
		String proterty="createTime";	
		
		
		if(politicalstatus!=null){ //判定politicalstatus不为空时
			
			//先去除学号和姓名中可能存在的空格
			if(!StringUtils.isEmpty(politicalstatus.getStuName())){
				politicalstatus.setStuName(politicalstatus.getStuName().trim());
			}
			if(!StringUtils.isEmpty(politicalstatus.getStudentNo())){
				politicalstatus.setStudentNo(politicalstatus.getStudentNo().trim());
			}
			
			//用于查询某个具体日期的数据
			if(politicalstatus.getJoinDate()!=null){
				long time=politicalstatus.getJoinDate().getTime();
				//下一天的时间
				//time=time+24*60*60*1000; 
				//nextday=new Timestamp(time);
			}
//			////多个查询条件组合
			if(politicalstatus!=null){ //politicalstatus不为空时
				 if(politicalstatus.getJoinDate()!=null){
					fields=new String[]{"joinDate=?","studentNo=?","stuName like ?"};
					params=new Object[]{politicalstatus.getJoinDate(),politicalstatus.getStudentNo(),"%"+politicalstatus.getStuName()+"%"};	
				}else if(!StringUtils.isEmpty(politicalstatus.getStudentNo())){ //查询条件是用户名
					fields=new String[]{"studentNo=?","stuName like ?"};
					params=new Object[]{politicalstatus.getStudentNo(),"%"+politicalstatus.getStuName()+"%"};	
				
			    }else if(!StringUtils.isEmpty(politicalstatus.getStuName())){ //查询条件
					fields=new String[]{"stuName like ?","studentNo=?"};
					params=new Object[]{"%"+politicalstatus.getStuName()+"%",politicalstatus.getStudentNo()};
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
	QueryUtils queryUtils=new QueryUtils(Politicalstatus.class, "entity");
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
	
	return polstatusDao.getPageUtils(queryUtils, pageNO, pageSize);
	
}
	@Override
	public void saveFromExcel(List<Object> politicalstatuss, String creator) {
		
		if(politicalstatuss!=null&&politicalstatuss.size()>0){
			//对每一条数据进行校验和设置相应的值
			for (Object object : politicalstatuss) {
				Politicalstatus politicalstatus=(Politicalstatus) object;
				//获取学生的学号,将学号赋给politicalstatus实体。
				//Student student=studentServices.getStudentByNo(politicalstatus.getStudentNo());
				//politicalstatus.setStuId(student.getStuId());

				String[] fields;
				Object[] params;
				
               fields=new String[]{"studentNo=?",};
               params=new Object[]{politicalstatus.getStudentNo()};
               if(this.findObjectByFields(fields, params)==null){
            	   //先查询要插入的数据系统中是否为空，为空才插入
				//这里先设置一个值用来测试
				politicalstatus.setStuId("9527");
				politicalstatus.setCreator(creator);
				politicalstatus.setCreateTime(new Timestamp(new Date().getTime()));
				this.add(politicalstatus);
				}
               
			}
		}

	}
	
}
