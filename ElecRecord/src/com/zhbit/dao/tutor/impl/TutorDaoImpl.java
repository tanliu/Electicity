package com.zhbit.dao.tutor.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.tutor.TutorDao;
import com.zhbit.entity.Tutor;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称： TutorDaoImpl
 * 类描述：用于辅导信息模块的Dao层实现类
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午8:50:13
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午8:50:13
 * 修改备注： 
 * @version 
 */ 
@Repository(value=TutorDao.DAO_NAME)
public class TutorDaoImpl extends BaseDaoImpl<Tutor> implements TutorDao {

	@Override
	public void saveTutors(List<Tutor> tutors) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdateAll(tutors);
	}

	
}
