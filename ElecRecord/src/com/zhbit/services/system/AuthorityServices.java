/**
 * 
 */
package com.zhbit.services.system;

import com.zhbit.entity.Authority;
import com.zhbit.services.BaseServices;

/** 
 * 项目名称：ElecRecord
 * 类名称：AuthorityServices 
 * 类描述： 权限管理模块Services层的接口
 * 创建人：谭柳
 * 创建时间：2016年5月29日 下午10:50:29
 * 修改人：TanLiu 
 * 修改时间：2016年5月29日 下午10:50:29
 * 修改备注： 
 * @version 
 */
public interface AuthorityServices extends BaseServices<Authority> {
  public static final String SERVICE_NAME="";

  void saveAuthoity(Authority authority);
}
