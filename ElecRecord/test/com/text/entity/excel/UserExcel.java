/**
 * 
 */
package com.text.entity.excel;

import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

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
@ExcelVoConfig
public class UserExcel extends BaseExcelVo{

	@Lang(value="id",isNull=Lang.TYPE_NONULL)
	private String id;
	@Lang(value = "姓名")
	private String username;
	@Lang(value = "密码")
	private String password;
	
	@Lang(value="生日",date=Lang.TYPE_DATE)
	private String birth;
	@Lang(value="性别")
	private String sex;
	
	@Lang(value="试试",toEntity={"1","0"},toExcle={"男","女"} )
	private String in;
	
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
	public int getHashVal() {
		return 0;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	
	
	
}
