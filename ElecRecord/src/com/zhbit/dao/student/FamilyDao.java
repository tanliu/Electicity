/**
 * 
 */
package com.zhbit.dao.student;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Familyinfo;

/** 
 * 项目名称：ElecRecord
 * 类名称：FamilyDao 
 * 类描述： 学生家庭情况Dao层
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午12:37:46
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午12:37:46
 * 修改备注： 
 * @version 
 */
public interface FamilyDao extends BaseDao<Familyinfo> {

	public final static String DAO_NAME="com.zhbit.dao.student.FamilyDaoImpl";
}
