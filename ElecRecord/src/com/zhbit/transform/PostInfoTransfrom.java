package com.zhbit.transform;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.zhbit.entity.excel.PostinfoExcel;
import com.zhbit.entity.Postinfo;


public class PostInfoTransfrom implements BaseTransfrom{

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		List<Object> postinfoList=new ArrayList<Object>();
		
		for(int i=0; i<excelObjs.size();i++){
			Postinfo postinfo=new Postinfo();
			PostinfoExcel postinfoExcel=(PostinfoExcel)excelObjs.get(i);
			
			postinfo.setEmsno(postinfoExcel.getEmsno());
			postinfo.setSchoolNo(postinfoExcel.getSchoolNo());
			postinfo.setMajor(postinfoExcel.getMajor());
			postinfo.setStudentNo(postinfoExcel.getStudentNo());
			postinfo.setStuName(postinfoExcel.getStuName());
			postinfo.setSex(postinfoExcel.getSex());
			postinfo.setDispatchType(postinfoExcel.getDispatchType());
			postinfo.setChargeUnit(postinfoExcel.getChargeUnit());	
			postinfo.setMailNo(postinfoExcel.getMailNo());
			

			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			postinfo.setCreateTime(createtime);
			postinfo.setCreator("朱嘉鑫");
			postinfo.setStuId(""+i+1);
			postinfoList.add(postinfo);
		}
		return postinfoList;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		List<Object> list=new ArrayList<Object>();
		for(int i=0; i<dbObjs.size();i++){
			PostinfoExcel postinfoExcel=new PostinfoExcel();
			Postinfo postinfo=(Postinfo) dbObjs.get(i);
			
			postinfoExcel.setEmsno(postinfo.getEmsno());
			postinfoExcel.setSchoolNo(postinfo.getSchoolNo());
			postinfoExcel.setMajor(postinfo.getMajor());
			postinfoExcel.setStudentNo(postinfo.getStudentNo());
			postinfoExcel.setStuName(postinfo.getStuName());
			postinfoExcel.setSex(postinfo.getSex());
			postinfoExcel.setDispatchType(postinfo.getDispatchType());
			postinfoExcel.setChargeUnit(postinfo.getChargeUnit());	
			postinfoExcel.setMailNo(postinfo.getMailNo());
			
			list.add(postinfoExcel);
		}
		return list;
	}
}