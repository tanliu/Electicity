/**
 * 
 */
package com.zhbit.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.OrganizeDao;
import com.zhbit.entity.Organization;

/** 
 * 项目名称：ElecRecord
 * 类名称：OrganizeDaoImpl 
 * 类描述： 部分模块Dao层的实现类
 * 创建人：谭柳
 * 创建时间：2016年5月6日 下午12:55:50
 * 修改人：谭柳
 * 修改时间：2016年5月6日 下午12:55:50
 * 修改备注： 
 * @version 
 */
@Repository(value=OrganizeDao.DAO_NAME)
public class OrganizeDaoImpl extends BaseDaoImpl<Organization> implements OrganizeDao {

}
