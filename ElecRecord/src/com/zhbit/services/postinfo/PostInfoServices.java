package com.zhbit.services.postinfo;

import java.io.Serializable;
import java.util.List;

import com.zhbit.entity.Postinfo;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;



/**
 * 项目名称：ElecRecord 
 * 类名称： PostInfoServices 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月11日 下午12:31:46 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月11日 下午12:31:46 
 * 修改备注： 
 * @version 
 */
public interface PostInfoServices extends BaseServices<Postinfo> {
   public final static String SERVER_NAME="com.zhbit.services.postinfo.impl.PostInfoServicesImpl";
   public List<Postinfo> queryListDownload(Serializable... id);
   public List<Postinfo> queryAllList();
   public PageUtils queryList(Postinfo postinfo,int pageNO,int pageSize);
}