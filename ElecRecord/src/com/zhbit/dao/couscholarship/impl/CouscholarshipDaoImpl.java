package com.zhbit.dao.couscholarship.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.couscholarship.CouscholarshipDao;
import com.zhbit.entity.CountryScholarship;




/** 
 * 项目名称：ElecRecord
 * 类名称：CouscholarshipDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月10日 下午8:47:12
 * 修改人：罗吉林
 * 修改时间：2016年6月10日 下午8:47:12
 * 修改备注： 
 * @version 
 */
@Repository(value=CouscholarshipDao.DAO_NAME)
public class CouscholarshipDaoImpl extends BaseDaoImpl<CountryScholarship> implements CouscholarshipDao{

}
