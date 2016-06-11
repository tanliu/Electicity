package com.zhbit.services.postinfo.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.postinfo.PostInfoDao;
import com.zhbit.entity.Postinfo;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.postinfo.PostInfoServices;
import com.zhbit.services.subjectcontest.SubjectContestServices;
import com.zhbit.services.system.UserServices;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;


/**
 * 项目名称：ElecRecord 
 * 类名称： PostInfoServicesImpl 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月11日 下午12:37:57 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月11日 下午12:37:57 
 * 修改备注： 
 * @version 
 */
@Service(value=PostInfoServices.SERVER_NAME)
public class PostInfoServicesImpl extends BaseServicesImpl<Postinfo> 
	implements PostInfoServices {
	
	PostInfoDao postinfoDao;
	@Resource(name=PostInfoDao.DAO_NAME)
	 public void setSubjectContestDao(PostInfoDao postinfoDao) {
	    	super.setBaseDao(postinfoDao);
			this.postinfoDao = postinfoDao;
			
		}


	

	@Override
	public PageUtils queryList(Postinfo postinfo, int pageNO, int pageSize) {
		String[] fields=null;
		String[] params=null;
		String proterty="createTime";		
		if(postinfo!=null){ //判定politicalstatus不为空时
			////多个查询条件组合
			if(!StringUtils.isEmpty(postinfo.getEmsno())){ 
				//查询语句组合
				fields=new String[]{"emsno like ?","mailNo=?","major like ?","stuName like ?"};
				params=new String[]{postinfo.getEmsno()+"%",postinfo.getMailNo(),"%"+postinfo.getMajor()+"%","%"+postinfo.getStuName()+"%"};
			}else if(!StringUtils.isEmpty(postinfo.getMailNo())){
				fields=new String[]{"mailNo=?","emsno like ?","major like ?","stuName like ?"};
				params=new String[]{postinfo.getMailNo(),postinfo.getEmsno()+"%","%"+postinfo.getMajor()+"%","%"+postinfo.getStuName()+"%"};
			}else if(!StringUtils.isEmpty(postinfo.getMajor())){
				fields=new String[]{"major like ?","emsno like ?","mailNo=?","stuName like ?"};
				params=new String[]{"%"+postinfo.getMajor()+"%",postinfo.getEmsno()+"%",postinfo.getMailNo(),"%"+postinfo.getStuName()+"%"};
			}else  if(!StringUtils.isEmpty(postinfo.getStuName())){
				fields=new String[]{"stuName like ?","emsno like ?","mailNo=?","major like ?"};
				params=new String[]{"%"+postinfo.getStuName()+"%",postinfo.getEmsno()+"%",postinfo.getMailNo(),"%"+postinfo.getMajor()+"%"};
			}
		}

		return getPageUtils(fields, params, proterty, QueryUtils.ORDER_BY_ASC, pageNO, pageSize);
	}
	
	
	
	public List<Postinfo> queryListDownload(Serializable... id) {
		List<Postinfo> list=postinfoDao.queryListDownload(id);
		return list;
	}
	@Override
	public List<Postinfo> queryAllList() {
		return postinfoDao.queryAllList();
	}
	
}