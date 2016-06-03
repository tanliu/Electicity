/**
 * 
 */
package com.zhbit.services.system.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.zhbit.dao.system.RoleDao;
import com.zhbit.entity.Authority;
import com.zhbit.entity.Role;
import com.zhbit.entity.RoleAuthority;
import com.zhbit.services.BaseServicesImpl;
import com.zhbit.services.system.RoleServices;
import com.zhbit.util.DecodeUtils;
import com.zhbit.util.PageUtils;
import com.zhbit.util.QueryUtils;

/** 
 * 项目名称：ElecRecord
 * 类名称：RoleServicesImpl 
 * 类描述： 
 * 创建人：谭柳
 * 创建时间：2016年6月2日 下午5:39:33
 * 修改人：TanLiu 
 * 修改时间：2016年6月2日 下午5:39:33
 * 修改备注： 
 * @version 
 */
@Service(value=RoleServices.SEVICES_NAME)
public class RoleServicesImpl extends BaseServicesImpl<Role> implements RoleServices {

	RoleDao roleDao;
	@Resource(name=RoleDao.DAO_NAME)
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}
	
	/* 
	 * 方法描述:保存角色信息	 *
	 */
	@Override
	public void saveRole(Role role, String[] authoritys) {
		//先保存角色
		roleDao.save(role);
		//再保存角色权限
		if(authoritys!=null){
			for (String authorityId : authoritys) {
				if(!StringUtils.isEmpty(authorityId)){
					
					roleDao.saveRoleAuthority(new RoleAuthority(authorityId, role.getRoleId()));
				}
			}

		}

		
	}

	@Override
	public List<RoleAuthority> getRoleAuthority(String roleId) {
		
		return roleDao.getRoleAuthority(roleId);
	}

	@Override
	public PageUtils getPageUtils(String querycon, int pageNO, int pageSize) {
		String[] fiels=null;
		String[] params=null;
		if(querycon!=null){
			querycon=querycon.trim();
			try {
				DecodeUtils.decodeUTF(querycon);
			} catch (UnsupportedEncodingException e) {
				System.out.println("在RoleServicesImpl转编码时出错！");
				e.printStackTrace();
			}
		}
		if(!StringUtils.isEmpty(querycon)){
			fiels=new String[]{"roleName like ?"};
			params=new String[]{"%"+querycon+"%"};
		}
		String proterty="roleNo";
		String order=QueryUtils.ORDER_BY_DESC;
		PageUtils pageUtils=this.getPageUtils(fiels, params, proterty, order, pageNO, pageSize);	
		return pageUtils;
	}

	@Override
	public void editorRole(Role role, String[] authoritys) {
		List<RoleAuthority> roleAuthorities=roleDao.getRoleAuthority(role.getRoleId());
		roleDao.deleteRoleAuthority(roleAuthorities);
		roleDao.update(role);
		//再保存角色权限
		if(authoritys!=null){
			for (String authorityId : authoritys) {
				if(!StringUtils.isEmpty(authorityId)){
					
					roleDao.saveRoleAuthority(new RoleAuthority(authorityId, role.getRoleId()));
				}
			}

		}
		
	}

	@Override
	public void deleteRole(String[] selectedRow) {
		for (String roleId : selectedRow) {
			//先删除对应的权限角色
			List<RoleAuthority> roleAuthorities=roleDao.getRoleAuthority(roleId);
			roleDao.deleteRoleAuthority(roleAuthorities);
			//再删除角色
			roleDao.deleteObjectByIds(roleId);			
		}
		
	}
}
