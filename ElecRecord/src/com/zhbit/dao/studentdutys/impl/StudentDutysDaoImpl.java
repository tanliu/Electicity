package com.zhbit.dao.studentdutys.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.studentdutys.StudentDutysDao;
import com.zhbit.dao.subjectcontest.SubjectContestDao;
import com.zhbit.dao.system.UserDao;
import com.zhbit.entity.StudentDutys;
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
@Repository(value=StudentDutysDao.DAO_NAME)
public class StudentDutysDaoImpl extends BaseDaoImpl<StudentDutys> 
	implements StudentDutysDao{

	@Override
	public void add(StudentDutys studentDutys) {
		//save(studentDutys);
	}

	@Override
	public List<StudentDutys> queryListDownload(Serializable... id) {
		List<StudentDutys> list=new ArrayList<StudentDutys>();
		if(id!=null && id.length>0){
			for(Serializable ids:id){
				//先查询
				StudentDutys entity = (StudentDutys) this.findObjectById(ids);
				//放入list
				list.add(entity);
			}
		}

		return list;
	}

	@Override
	public List<StudentDutys> queryAllList() {
		Query query=getSession().createQuery("from com.zhbit.entity.StudentDutys");
		List<StudentDutys> list=query.list();
		return list;
	}
	
	
}