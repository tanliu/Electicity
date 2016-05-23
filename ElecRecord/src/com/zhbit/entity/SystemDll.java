package com.zhbit.entity;
/** 
 * 项目名称：ElecRecord
 * 类名称：SystemDll 
 * 类描述： 数据字典的实体
 * 创建人：谭柳
 * 创建时间：2016年4月28日 上午9:30:29
 * 修改人：谭柳
 * 修改时间：2016年4月28日 上午9:30:29
 * 修改备注： 
 * @version 1.0
 */ 
public class SystemDll implements java.io.Serializable {



	private static final long serialVersionUID = 1L;
	private String seqId;   //标识
	private String keyword;  //类型名称
	private Integer ddlCode; //数据代码
	private String ddlName;  //数据名字

	

	public SystemDll(String keyword) {
		super();
		this.keyword = keyword;
	}


	public SystemDll() {
	}


	public SystemDll(String keyword, Integer ddlCode, String ddlName) {
		this.keyword = keyword;
		this.ddlCode = ddlCode;
		this.ddlName = ddlName;
	}

  //-----------------------------------getter&setter------------------------------
	public String getSeqId() {
		return this.seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getDdlCode() {
		return this.ddlCode;
	}

	public void setDdlCode(Integer ddlCode) {
		this.ddlCode = ddlCode;
	}

	public String getDdlName() {
		return this.ddlName;
	}

	public void setDdlName(String ddlName) {
		this.ddlName = ddlName;
	}

}