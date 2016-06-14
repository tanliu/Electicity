/**
 * 
 */
package com.zhbit.services.student;

import java.util.List;

import com.zhbit.entity.LearningExperience;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：LearnExperienceServices 
 * 类描述： 学生学历情况的services层
 * 创建人：谭柳
 * 创建时间：2016年6月13日 下午3:48:45
 * 修改人：TanLiu 
 * 修改时间：2016年6月13日 下午3:48:45
 * 修改备注： 
 * @version 
 */
public interface LearnExperienceServices extends BaseServices<LearningExperience> {
	public final static String SERVICES_NAME="com.zhbit.services.student.LearnExperienceServicesImpl";

	/**
	 * 方法描述:能过学号查找到学生学历信息
	 * @param stuId
	 * @return
	 */
	List<LearningExperience> findExperiencByStuId(String stuId);

	/**
	 * 方法描述:保存或者更新学历
	 * @param experiences
	 */
	void saveOrUpdate(List<LearningExperience> experiences);
}
