package com.text.entity.excel;

import java.util.List;

import org.zhbit.excel.annotation.ExcelColumnGroup;
import org.zhbit.excel.annotation.ExcelVoConfig;
import org.zhbit.excel.annotation.Lang;
import org.zhbit.excel.bean.BaseExcelVo;

import com.zhbit.excel.InnerVo;



@ExcelVoConfig
public class TestEntity extends BaseExcelVo {
	
	
    @Lang(value="学号")
	private String id;
	@Lang(value = "姓名")
	private String name;
	@Lang(value = "入党团日期")
	private String entertime;
	@Lang(value = "政治面貌")
	private String identify;
	@Lang(value = "备注")
	private String comment;
	
	//非对就
    @ExcelColumnGroup(type = String.class)
    private List<String> baseArray;
    @ExcelColumnGroup(type = InnerVo.class)
    private List<InnerVo> innerVoArray;


    public TestEntity(){
    	
    }

	public TestEntity(String id, String name, String entertime, String identify,
			String comment) {
		super();
		this.id = id;
		this.name = name;
		this.entertime = entertime;
		this.identify = identify;
		this.comment = comment;
	}







	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEntertime() {
		return entertime;
	}




	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}




	public String getIdentify() {
		return identify;
	}




	public void setIdentify(String identify) {
		this.identify = identify;
	}




	@Override
	public int getHashVal() {
		return 0;
	}




	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}

}
