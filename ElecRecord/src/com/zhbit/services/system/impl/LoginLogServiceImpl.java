/**
 * 
 */
package com.zhbit.services.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhbit.dao.system.LoginLogDao;
import com.zhbit.entity.LoginLog;
import com.zhbit.services.system.LoginLogService;

/** 
 * 项目名称：ElecRecord
 * 类名称：LoginLogServiceImpl 
 * 类描述： 系统登录日志Service层接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月5日 上午10:58:32
 * 修改人：TanLiu 
 * 修改时间：2016年6月5日 上午10:58:32
 * 修改备注： 
 * @version 
 */
@Service(value=LoginLogService.SERVICES_NAME)
public class LoginLogServiceImpl implements LoginLogService {
	@Resource(name=LoginLogDao.DAO_NAME)
	LoginLogDao loginLogDao;

	@Override
	public List<LoginLog> findLoginLogByUserNO(String employNo) {
		// TODO Auto-generated method stub
		return loginLogDao.findLoginLogByUserNO(employNo);
	}

	@Override
	public void save(LoginLog loginLog) {
		loginLogDao.save(loginLog);
		
	}


}
