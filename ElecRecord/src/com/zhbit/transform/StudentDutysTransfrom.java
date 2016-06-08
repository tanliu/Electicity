package com.zhbit.transform;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhbit.entity.excel.StudentDutysExcel;
import com.zhbit.entity.excel.SubjectContestExcel;
import com.zhbit.entity.StudentDutys;
import com.zhbit.entity.Subjectcontest;


public class StudentDutysTransfrom implements BaseTransfrom{

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		List<Object> studentDutyslist=new ArrayList<Object>();
		for(int i=0; i<excelObjs.size();i++){
			StudentDutys studentDutys=new StudentDutys();
			StudentDutysExcel studentDutysExcel=(StudentDutysExcel) excelObjs.get(i);
			
			studentDutys.setGrade(studentDutysExcel.getGrade());
			studentDutys.setCollege(studentDutysExcel.getCollege());
			studentDutys.setClassName(studentDutysExcel.getClassName());
			studentDutys.setStuName(studentDutysExcel.getStuName());
			studentDutys.setSex(studentDutysExcel.getSex());
			studentDutys.setDuty(studentDutysExcel.getDuty());
			studentDutys.setTelNo(studentDutysExcel.getTelNo());
			studentDutys.setShortTelNo(studentDutysExcel.getShortTelNo());
			studentDutys.setAddress(studentDutysExcel.getAddress());
			
			studentDutys.setStuId(""+i);
			studentDutys.setStudentNo("1102020110"+i);
			studentDutyslist.add(studentDutys);
		}
		return studentDutyslist;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		List<Object> studentDutyslist=new ArrayList<Object>();
		for(int i=0; i<dbObjs.size();i++){
			StudentDutysExcel studentDutysExcel=new StudentDutysExcel();
			StudentDutys studentDutys=(StudentDutys) dbObjs.get(i);
			
			studentDutysExcel.setGrade(studentDutys.getGrade());
			studentDutysExcel.setCollege(studentDutys.getCollege());
			studentDutysExcel.setClassName(studentDutys.getClassName());
			studentDutysExcel.setStuName(studentDutys.getStuName());
			studentDutysExcel.setSex(studentDutys.getSex());
			studentDutysExcel.setDuty(studentDutys.getDuty());
			studentDutysExcel.setTelNo(studentDutys.getTelNo());
			studentDutysExcel.setShortTelNo(studentDutys.getShortTelNo());
			studentDutysExcel.setAddress(studentDutys.getAddress());
			
			studentDutyslist.add(studentDutysExcel);
		}
		return studentDutyslist;
	}
}