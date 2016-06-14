package com.zhbit.dao.comscholarship.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.comscholarship.ComscholarshipDao;

import com.zhbit.entity.CommonScholarship;




/** 
 * 项目名称：ElecRecord
 * 类名称：ComscholarshipDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月12日 下午7:46:35
 * 修改人：罗吉林
 * 修改时间：2016年6月12日 下午7:46:35
 * 修改备注： 
 * @version 
 */
@Repository(value=ComscholarshipDao.DAO_NAME)
public class ComscholarshipDaoImpl extends BaseDaoImpl<CommonScholarship> implements ComscholarshipDao{

}
