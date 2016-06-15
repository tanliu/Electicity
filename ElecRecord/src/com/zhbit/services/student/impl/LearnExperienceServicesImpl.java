/**
 * 
 */
package com.zhbit.services.student.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.student.LearnExperienceDao;
import com.zhbit.entity.LearningExperience;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.student.LearnExperienceServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：LearnExperienceServicesImpl 
 * 类描述： 学生学历情况
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午3:50:17
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午3:50:17
 * 修改备注： 
 * @version 
 */
@Service(value=LearnExperienceServices.SERVICES_NAME)
public class LearnExperienceServicesImpl extends BaseServicesImpl<LearningExperience> implements LearnExperienceServices {

	LearnExperienceDao experienceDao;
	
	@Resource(name=LearnExperienceDao.DAO_NAME)
	public void setExperienceDao(LearnExperienceDao experienceDao) {
		super.setBaseDao(experienceDao);
		this.experienceDao = experienceDao;
	}

	@Override
	public List<LearningExperience> findExperiencByStuId(String stuId) {
		String[] fields={"stuId = ?"};
		String[] params={stuId};
		
		return this.findObjectByFields(fields, params);
	}

	@Override
	public void saveOrUpdate(List<LearningExperience> experiences) {

		experienceDao.saveOrUpdate(experiences);
	}
	
}
