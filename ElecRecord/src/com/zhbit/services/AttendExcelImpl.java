/**
 * 
 */
package com.zhbit.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhbit.entity.AttendanceDetail;
import com.zhbit.entity.AttendanceMaster;
import com.zhbit.excel.ExcelConfig;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/** 
 * 项目名称：ElecRecord
 * 类名称：AttendExcelImpl 
 * 类描述： 考勤信息的Excel导入接口实现类
 * 创建人：谭柳
 * 创建时间：2016年6月17日 上午11:42:57
 * 修改人：TanLiu 
 * 修改时间：2016年6月17日 上午11:42:57
 * 修改备注： 
 * @version 
 */
public class AttendExcelImpl implements ExcelServicesMake {

	/* 方法描述:导入excel返回的是一个对象集合，其中集合的每一元素是master信息。后面的是detail的信息。
	 * @see com.zhbit.services.ExcelServicesMake#parseExcel(com.zhbit.excel.ExcelConfig)
	 */
	@Override
	public List<Object> parseExcel(ExcelConfig config) throws Exception {
		List<Object> infos=new ArrayList<Object>();//考勤表中的所有信息
		InputStream fis;
		try {
			Workbook wb=Workbook.getWorkbook(config.getFio());
			Sheet sheets[]=wb.getSheets();
			Sheet sheet=sheets[0];
			if(sheet!=null){
				//处理完成主表
				AttendanceMaster attendanceMaster=new AttendanceMaster();
				attendanceMaster.setAcademicyear(sheet.getCell(2, 1).getContents());
				attendanceMaster.setTerm(sheet.getCell(4, 1).getContents());
				String selectedcourseno=sheet.getCell(9, 1).getContents();
				attendanceMaster.setSelectedcourseno(sheet.getCell(9, 1).getContents());
				attendanceMaster.setCoursename(sheet.getCell(21, 1).getContents());
				
				attendanceMaster.setEmployName(sheet.getCell(2, 2).getContents());
				attendanceMaster.setEmployNo(sheet.getCell(9, 1).getContents().substring(23, 28));
				attendanceMaster.setOrgName(sheet.getCell(4, 2).getContents());
				attendanceMaster.setSchooltime(sheet.getCell(11, 2).getContents());
				attendanceMaster.setAddress(sheet.getCell(21, 2).getContents());
				infos.add(attendanceMaster);
				//管理详细表				
				Cell gradecell=sheet.findCell("平时成绩");
				int dateend=gradecell.getColumn();
				Map<String,String> attendMap=new HashMap<String, String>();
				attendMap.put("○", "病假");
				attendMap.put("※", "事假");
				attendMap.put("×", "旷课");
				attendMap.put("△", "迟到");
				attendMap.put("#", "早退");
				attendMap.put("√", "出勤");
				for (int row = 5; row < sheet.getRows()-1; row++) {
					for(int column=7;column<dateend;column++){
						AttendanceDetail detail=new AttendanceDetail();
						//判断时间
						Date date=null;
						String time=sheet.getCell(column,4).getContents();
						if(time!=null&&!"".equals(time)){							
							String fromat=null;
							String onereg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$"; 
							
							if(time.matches(onereg)){
								if(time.contains("-")){
									fromat="yyyy-MM-dd";									
								}else if(time.contains("/")){
									fromat="yyyy/MM/dd";
								}else{
									fromat="yyyyMMdd";
								}
							}
							if(fromat!=null){
								SimpleDateFormat sdf=new SimpleDateFormat(fromat);
								date = sdf.parse(time);
							}						
						}else{
							break;
						}
						if(date==null){ //如果时间格式不对，跳到下一页
							continue;
						}
						detail.setSelectedcourseno(selectedcourseno);
						detail.setAttendanceTime(new Timestamp(date.getTime()));
						detail.setStudentno(sheet.getCell(2, row).getContents());
						detail.setStuname(sheet.getCell(3, row).getContents());
						detail.setSex(sheet.getCell(4, row).getContents());
						detail.setClassname(sheet.getCell(5, row).getContents());
						String mark=sheet.getCell(column,row).getContents();
						detail.setAttendanceStatus(attendMap.get(mark));
						infos.add(detail);				
						
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}

	@Override
	public void createExcel(ExcelConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> viladationExcel(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> toDBEnity(List lists, Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
