/**
 * 
 */
package com.zhbit.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.AuthorityDao;
import com.zhbit.entity.Authority;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityDaoImpl 
 * 类描述： 权限管理实现Dao层接口数
 * 创建人：谭柳
 * 创建时间：2016年5月29日 下午10:47:24
 * 修改人：TanLiu 
 * 修改时间：2016年5月29日 下午10:47:24
 * 修改备注： 
 * @version 
 */
@Repository(value=AuthorityDao.DAO_NAME)
public class AuthorityDaoImpl extends BaseDaoImpl<Authority> implements AuthorityDao {

}
