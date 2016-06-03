package com.zhbit.transform;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.text.entity.excel.SubjectContestExcel;
import com.zhbit.entity.Subjectcontest;

public class SubjectContestTransfrom implements BaseTransfrom{

	@Override
	public List<Object> toDBEntity(List excelObjs) {
		List<Object> subjectcontestsList=new ArrayList<Object>();
		
		for(int i=0; i<excelObjs.size();i++){
			Subjectcontest subjectcontests=new Subjectcontest();
			SubjectContestExcel subjectContestExcel=(SubjectContestExcel)excelObjs.get(i);
			subjectcontests.setStuId("001");
			subjectcontests.setStudentNo("130202010001"+i);
			subjectcontests.setStuName(subjectContestExcel.getStuName());
			subjectcontests.setRewardName(subjectContestExcel.getRewardName());
			subjectcontests.setRewardLevel(subjectContestExcel.getRewardLevel());
			subjectcontests.setRewardGrade(subjectContestExcel.getRewardGrade());
			subjectcontests.setGrantUnits(subjectContestExcel.getGrantUnits());
			subjectcontests.setRewardProject(subjectContestExcel.getRewardProject());
			subjectcontests.setGuidTeacher(subjectContestExcel.getGuidTeacher());	
			//DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			//Timestamp time =Timestamp.valueOf(subjectContestExcel.getRewardDate());
			//System.out.println("日期="+subjectContestExcel.getRewardDate().replace("//", "-"));
			//subjectcontests.setRewardDate(Timestamp.valueOf(subjectContestExcel.getRewardDate().replace("//", "-")));
			subjectcontests.setMemo(subjectContestExcel.getMemo());

			Timestamp createtime = new Timestamp(System.currentTimeMillis());
			subjectcontests.setCreateTime(createtime);
			subjectcontests.setCreator("朱嘉鑫");
			
			subjectcontestsList.add(subjectcontests);
		}
		return subjectcontestsList;
	}

	@Override
	public List<Object> toExcelObj(List dbObjs) {
		List<Object> list=new ArrayList<Object>();
		for(int i=0; i<dbObjs.size();i++){
			SubjectContestExcel subjectContestExcel=new SubjectContestExcel();
			Subjectcontest subjectContest=(Subjectcontest) dbObjs.get(i);
			
			subjectContestExcel.setSequence(""+(i+1));
			subjectContestExcel.setStuName(subjectContest.getStuName());
			subjectContestExcel.setRewardName(subjectContest.getRewardName());
			subjectContestExcel.setRewardLevel(subjectContest.getRewardLevel());
			subjectContestExcel.setRewardGrade(subjectContest.getRewardGrade());
			subjectContestExcel.setGrantUnits(subjectContest.getGrantUnits());
			subjectContestExcel.setRewardProject(subjectContest.getRewardProject());
			subjectContestExcel.setGuidTeacher(subjectContest.getGuidTeacher());
			subjectContestExcel.setRewardDate("2015-06-03");
			subjectContestExcel.setMemo(subjectContest.getMemo());
			
			list.add(subjectContestExcel);
		}
		return list;
	}
}
