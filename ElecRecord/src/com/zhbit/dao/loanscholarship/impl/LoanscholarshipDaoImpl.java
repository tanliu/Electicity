package com.zhbit.dao.loanscholarship.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.grantscholarship.GrantscholarshipDao;
import com.zhbit.dao.loanscholarship.LoanscholarshipDao;
import com.zhbit.entity.GrantScholarship;
import com.zhbit.entity.LoanScholarship;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoanscholarshipDaoImpl
 * 类描述： 
 * 创建人：罗吉林
 * 创建时间：2016年6月15日 下午5:08:49
 * 修改人：罗吉林
 * 修改时间：2016年6月15日 下午5:08:49
 * 修改备注： 
 * @version 
 */
@Repository(value=LoanscholarshipDao.DAO_NAME)
public class LoanscholarshipDaoImpl extends BaseDaoImpl<LoanScholarship> implements LoanscholarshipDao{

}
