/**
 * 
 */
package com.zhbit.services.student.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.student.FamilyDao;
import com.zhbit.entity.Familyinfo;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.FamilyServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：FamilyServicesImpl 
 * 类描述：  学生家庭情况Sevices层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午12:42:52
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午12:42:52
 * 修改备注： 
 * @version 
 */
@Service(value=FamilyServices.SERVICES_NAME)
public class FamilyServicesImpl extends BaseServicesImpl<Familyinfo> implements FamilyServices {

	FamilyDao familyDao;
	@Resource(name=FamilyDao.DAO_NAME)
	public void setFamilyDao(FamilyDao familyDao) {
		super.setBaseDao(familyDao);
		this.familyDao = familyDao;
	}
}
