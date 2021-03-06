package com.zhbit.dao.studentdutys;

import java.io.Serializable;
import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.StudentDutys;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
/** 
 /**
 * 项目名称：ElecRecord
 * 类名称：SubjectContestDao层
 * 类描述： 学科竞赛信息管理Dao层接口 
 * 创建人：朱嘉鑫
 * 创建时间：2016年5月28日 下午21:49:05
 * 修改人：zjx 
 * 修改时间：2016年5月28日 下午21:49:05
 * 修改备注： 
 * @version 
 */ 
public interface StudentDutysDao extends BaseDao<StudentDutys> {
	public static final String DAO_NAME="com.zhbit.dao.StudentDutys.impl.StudentDutystDaoImpl";
	public void add(StudentDutys studentDutys);
	public List<StudentDutys> queryAllList();
	public List<StudentDutys> queryListDownload(Serializable... id);
}