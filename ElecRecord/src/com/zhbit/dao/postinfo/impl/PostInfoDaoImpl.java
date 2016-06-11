package com.zhbit.dao.postinfo.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.postinfo.PostInfoDao;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.Postinfo;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;


/**
 * 项目名称：ElecRecord 
 * 类名称： PostInfoDaoImpl 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月11日 下午12:38:26 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月11日 下午12:38:26 
 * 修改备注： 
 * @version 
 */
@Repository(value=PostInfoDao.DAO_NAME)
public class PostInfoDaoImpl extends BaseDaoImpl<Postinfo> 
	implements PostInfoDao{

	@Override
	public List<Postinfo> queryListDownload(Serializable... id) {
		List<Postinfo> list=new ArrayList<Postinfo>();
		if(id!=null && id.length>0){
			for(Serializable ids:id){
				//先查询
				Postinfo entity = this.findObjectById(ids);
				//放入list
				list.add(entity);
			}
		}

		return list;
	}

	@Override
	public List<Postinfo> queryAllList() {
		Query query=getSession().createQuery("from com.zhbit.entity.Postinfo");
		List<Postinfo> list=query.list();
		return list;
	}

	@Override
	public void add(Postinfo postinfo) {
		save(postinfo);	
	}
	
	
}