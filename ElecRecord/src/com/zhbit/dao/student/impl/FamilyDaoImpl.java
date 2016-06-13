/**
 * 
 */
package com.zhbit.dao.student.impl;

import org.springframework.stereotype.Repository;

import com.zhbit.dao.BaseDaoImpl;
import com.zhbit.dao.student.FamilyDao;
import com.zhbit.entity.Familyinfo;

/** 
 * 项目名称：ElecRecord
 * 类名称：FamilyDaoImpl 
 * 类描述： 学生家庭情况Dao层
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午12:40:00
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午12:40:00
 * 修改备注： 
 * @version 
 */
@Repository(value=FamilyDao.DAO_NAME)
public class FamilyDaoImpl extends BaseDaoImpl<Familyinfo> implements FamilyDao {

}
