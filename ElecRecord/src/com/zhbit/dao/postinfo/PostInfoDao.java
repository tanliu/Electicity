package com.zhbit.dao.postinfo;

import java.io.Serializable;
import java.util.List;

import com.zhbit.dao.BaseDao;
import com.zhbit.entity.Postinfo;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;

/**
 * 项目名称：ElecRecord 
 * 类名称： PostInfoDao 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月11日 下午12:38:35 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月11日 下午12:38:35 
 * 修改备注： 
 * @version 
 */
public interface PostInfoDao extends BaseDao<Postinfo> {
	public static final String DAO_NAME="com.zhbit.dao.postinfo.impl.PostInfoDaoImpl";
	public void add(Postinfo postinfo);
	public List<Postinfo> queryAllList();
	public List<Postinfo> queryListDownload(Serializable... id);
}