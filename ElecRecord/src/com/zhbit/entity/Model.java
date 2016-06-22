/**
 * 
 */
package com.zhbit.entity;

/** 
 * 项目名称：ElecRecord
 * 类名称：FileInfo 
 * 类描述： 模块文件信息
 * 创建人：谭柳
 * 创建时间：2016年6月22日 上午11:06:25
 * 修改人：TanLiu 
 * 修改时间：2016年6月22日 上午11:06:25
 * 修改备注： 
 * @version 
 */
public class Model {
	String id;
	String fileName;
	String filePath;
	String creator;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	
	
	
}
