/**
 * 
 */
package com.zhbit.services.student;

import java.util.List;

import com.zhbit.entity.Familyinfo;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：FamilyServices 
 * 类描述： 学生家庭情况Sevices层
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午12:41:22
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午12:41:22
 * 修改备注： 
 * @version 
 */
public interface FamilyServices extends BaseServices<Familyinfo> {
	public final static String SERVICES_NAME="com.zhbit.services.student.FamilyServicesImpl";
	List<Familyinfo> findFamilyByStuId(String stuId);
	
	public void saveOrUpdate(List<Familyinfo> familyinfos);
	
	
}
