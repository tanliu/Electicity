package com.zhbit.dao.tutor;

import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Tutor;

/** 
 * 项目名称：ElecRecord
 * 类名称： TutorDao
 * 类描述：用于辅导信息模块的dao接口层
 * 创建人：罗建鑫
 * 创建时间：2016年6月5日 下午8:49:51
 * 修改人：罗建鑫
 * 修改时间：2016年6月5日 下午8:49:51
 * 修改备注： 
 * @version 
 */ 
public interface TutorDao extends BaseDao<Tutor> {
	public static final String DAO_NAME="com.zhbit.dao.tutor.impl.TutorDaoImpl"; 
	
	public void saveTutors(List<Tutor> tutors);
}
