/**
 * 
 */
package com.text.entity;

import java.sql.Timestamp;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

import com.fasterxml.jackson.core.sym.Name;
import com.zhbit.annotation.Transform;

/** 
 * 项目名称：ElecRecord
 * 类名称：TestUser 
 * 类描述： 
 * 创建人：坛子
 * 创建时间：2016年4月25日 下午3:25:06
 * 修改人：TanLiu 
 * 修改时间：2016年4月25日 下午3:25:06
 * 修改备注： 
 * @version 
 */
public class TestUser implements Cloneable{

	@Transform(name="id")
	private String id;
	@Transform(name="姓名")
	private String username;
	@Transform(name="密码")	
	private String password;
	@Transform(name="生日")
	private Timestamp birth;
	@Transform(name="性别")
	private Integer sex;
	
	@Transform(name="试试")
	private int my;
	
	@Override
	protected Object clone(){		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", username=" + username + ", password=" + password + ", birth=" + birth
				+ ", sex=" + sex + ", my=" + my + "]";
	}
	public Timestamp getBirth() {
		return birth;
	}
	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public int getMy() {
		return my;
	}
	public void setMy(int my) {
		this.my = my;
	}
	

	
	
	
}
