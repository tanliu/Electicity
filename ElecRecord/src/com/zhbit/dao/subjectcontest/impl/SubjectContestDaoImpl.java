package com.zhbit.dao.subjectcontest.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.subjectcontest.SubjectContestDao;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/**
 * 项目名称：ElecRecord
 * 类名称：SubjectContestDaoImpl 
 * 类描述： 学科竞赛信息管理Dao层实现类
 * 创建人：朱嘉鑫
 * 创建时间：2016年5月28日 下午21:49:05
 * 修改人：zjx 
 * 修改时间：2016年5月28日 下午21:49:05
 * 修改备注： 
 * @version 
 */
@Repository(value=SubjectContestDao.DAO_NAME)
public class SubjectContestDaoImpl extends BaseDaoImpl<Subjectcontest> 
	implements SubjectContestDao{

	@Override
	public void add(Subjectcontest subjectcontest) {
		save(subjectcontest);
	}

	@Override
	public List<Subjectcontest> queryListDownload(Serializable... id) {
		List<Subjectcontest> list=new ArrayList<Subjectcontest>();
		if(id!=null && id.length>0){
			for(Serializable ids:id){
				//先查询
				Subjectcontest entity = this.findObjectById(ids);
				//放入list
				list.add(entity);
			}
		}

		return list;
	}

	@Override
	public List<Subjectcontest> queryAllList() {
		Query query=getSession().createQuery("from com.zhbit.entity.Subjectcontest");
		List<Subjectcontest> list=query.list();
		return list;
	}
	
	
}