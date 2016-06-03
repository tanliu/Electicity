package com.zhbit.services.SubjectContest;

import java.io.Serializable;
import java.util.List;

import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;


/**
 * 项目名称：ElecRecord
 * 类名称：SubjectContestServices
 * 类描述： 学科竞赛信息管理Services层接口
 * 创建人：朱嘉鑫
 * 创建时间：2016年5月28日 下午21:52:05
 * 修改人：zjx 
 * 修改时间：2016年5月28日 下午21:52:05
 * 修改备注： 
 * @version 
 */
public interface SubjectContestServices extends BaseServices<Subjectcontest> {
   public final static String SERVER_NAME="com.zhbit.services.SubjectContest.impl.SubjectContestServicesImpl";
   public List<Subjectcontest> queryListDownload(Serializable... id);
   public PageUtils queryList(Subjectcontest subjectcontest,int pageNO,int pageSize);
}
