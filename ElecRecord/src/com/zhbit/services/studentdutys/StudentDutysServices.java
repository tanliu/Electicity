package com.zhbit.services.studentdutys;

import java.io.Serializable;
import java.util.List;

import com.zhbit.entity.StudentDutys;
import com.zhbit.entity.Subjectcontest;
import com.zhbit.entity.User;
import com.zhbit.services.BaseServices;
import com.zhbit.util.PageUtils;

/**
 * 项目名称：ElecRecord 
 * 类名称： StudentDutysServices 
 * 类描述： TODO
 * 创建人：朱嘉鑫
 * 创建时间：2016年6月7日 下午7:23:08 
 * 修改人：朱嘉鑫
 * 修改时间：2016年6月7日 下午7:23:08 
 * 修改备注： 
 * @version 
 */
public interface StudentDutysServices extends BaseServices<StudentDutys> {
   public final static String SERVER_NAME="com.zhbit.services.studentdutys.impl.StudentDutysServicesImpl";
   public List<StudentDutys> queryListDownload(Serializable... id);
   public List<StudentDutys> queryAllList();
   public PageUtils queryList(StudentDutys studentDutys,int pageNO,int pageSize);
}