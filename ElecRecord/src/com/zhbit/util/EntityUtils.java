package com.zhbit.util;

import java.util.ArrayList;
import java.util.List;

import com.zhbit.entity.Familyinfo;
import com.zhbit.entity.excel.FamilyExcel;

public class EntityUtils {

	public static List<Object> getMotherInfos(List<Object> objects) {
		List<Object> familyinfos=new ArrayList<Object>();
		if(objects!=null&&objects.size()>0){
			for (Object object : objects) {
				FamilyExcel excel=(FamilyExcel) object;
				Familyinfo familyinfo=new Familyinfo();
				familyinfo.setStudentNo(excel.getStudentNo());
				familyinfo.setStuName(excel.getStuName());
				familyinfo.setName(excel.getMname());
				familyinfo.setPoliticalStatus(excel.getMpoliticalStatus());
				familyinfo.setTelNo(excel.getMtelNo());
				familyinfo.setCompany(excel.getMcompany());
				familyinfo.setPostCode(excel.getMpostCode());
				familyinfos.add(familyinfo);
			}
		}
		return familyinfos;
	}

}
