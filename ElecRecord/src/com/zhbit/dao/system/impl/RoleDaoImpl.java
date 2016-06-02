/**
 * 
 */
package com.zhbit.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.system.RoleDao;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.entity.UserRole;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleDaoImpl 
 * 类描述： 角色模块的Dao层实现类
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:28:37
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:28:37
 * 修改备注： 
 * @version 
 */
@Repository(value=RoleDao.DAO_NAME)
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {





}
