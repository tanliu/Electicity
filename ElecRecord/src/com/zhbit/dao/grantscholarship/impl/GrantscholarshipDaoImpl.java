package com.zhbit.dao.grantscholarship.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.couscholarship.CouscholarshipDao;
import com.zhbit.dao.grantscholarship.GrantscholarshipDao;
import com.zhbit.entity.CountryScholarship;
import com.zhbit.entity.GrantScholarship;

/** 
 * 项目名称：ElecRecord
 * 类名称：GrantscholarshipDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月14日 下午9:25:35
 * 修改人：罗吉林
 * 修改时间：2016年6月14日 下午9:25:35
 * 修改备注： 
 * @version 
 */
@Repository(value=GrantscholarshipDao.DAO_NAME)
public class GrantscholarshipDaoImpl extends BaseDaoImpl<GrantScholarship> implements GrantscholarshipDao{

}
