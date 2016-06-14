/**
 * 
 */
package com.zhbit.services;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.annotation.Transform;
import com.zhbit.entity.excel.BaseExcelBean;
import com.zhbit.excel.ExcelConfig;

import jxl.Sheet;
import jxl.Workbook;

/** 
 * 项目名称：ElecRecord
 * 类名称：ExcelServicesJXL 
 * 类描述： 用jxl实现
 * 创建人：谭柳
 * 创建时间：2016年6月9日 上午10:11:28
 * 修改人：TanLiu 
 * 修改时间：2016年6月9日 上午10:11:28
 * 修改备注： 
 * @version 
 */
@Controller(value="excelServicesMakeImpl")
public class ExcelServicesMakeImpl implements ExcelServicesMake {

	/* 方法描述:
	 * 
	 */
	@Override
	public List<Object> parseExcel(ExcelConfig config) throws Exception {		
		Map<String, Object> map=new HashMap<String, Object>();
		Map<Integer, Object> Excelmap=new HashMap<Integer, Object>();
		List<Object> objects=new ArrayList<Object>();
		if(config.getFio()==null){
			throw new Exception("文件不可以为空");
		}
		Workbook wb=Workbook.getWorkbook(config.getFio());
		Sheet sheets[]=wb.getSheets();
		//现再创建一个实体对像
		Object object=config.getClazz().newInstance();
		//把实体对象的属性保存到map中
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(field.getAnnotation(Lang.class)==null){
				continue;
			}
			map.put(field.getAnnotation(Lang.class).value(), field);
		}
		//操作表
		if(sheets!=null){
			for (Sheet sheet : sheets) {//指定的表
				if(!sheet.getName().equalsIgnoreCase(config.getSheetName())){
					throw new Exception("找不到指定的表");
				}
				for(int i=0;i<sheet.getColumns();i++){					
					String title=sheet.getCell(i, config.getStartRow()-1).getContents();
					if(title!=null){
						Field field=(Field) map.get(title);
						if (field!=null) {							
							Excelmap.put(i,field);
						}
						
					}

				}
				map=null;
				//System.out.println(Excelmap);
				//装载数据
				for(int row=config.getStartRow();row<sheet.getRows();row++){
					for(int colum=0;colum<sheet.getColumns();colum++){
						String value=sheet.getCell(colum,row).getContents();
						Field field=(Field) Excelmap.get(colum);

						if(field!=null&&value!=null){
							field.setAccessible(true);							
							field.set(object, value);							
							field.setAccessible(false);
						}
					}			
					
					Method rowmethod=object.getClass().getSuperclass().getDeclaredMethod("setRow", String.class);
					rowmethod.setAccessible(true);
					rowmethod.invoke(object, row+"");
					rowmethod.setAccessible(false);
					
					Method method=object.getClass().getDeclaredMethod("clone", null);
					method.setAccessible(true);
					Object obj=method.invoke(object, null);
					method.setAccessible(false);
					objects.add(obj);	
				}							
			}
		}
		return objects;
	}

	/* 方法描述:
	 * 
	 */
	@Override
	public void createExcel(ExcelConfig config) {

	}

	/* 方法描述:
	 * @see com.zhbit.services.ExcelServices#viladationExcel(java.util.List)
	 */
	@Override
	public Map<String, String> viladationExcel(List list) {
    	Map<String, String> map=new HashMap<String, String>();
    	for (Object object : list) {
    		
    		if(object==null){
    			continue;
    		}
    		BaseExcelBean baseExcelBean=(BaseExcelBean) object;
			
    		
    		Field[] declaredFields = object.getClass().getDeclaredFields();
    		for (Field field : declaredFields) {
    			field.setAccessible(true);
    			try {
					String value=(String) field.get(object);
					Lang annotation = field.getAnnotation(Lang.class);
					if(annotation==null){
						continue;
					}
					//判断是否可以为空
					if(Lang.TYPE_NONULL.equals(annotation.isNull())){
						if(value==null||"".equals(value.replace(" ", ""))){
							map.put("第"+baseExcelBean.getRow()+"行的("+field.getAnnotation(Lang.class).value()+")列","存在空值");
							//return map;
						}

					}
					//判断指定格式是否正确
					if(!Lang.TYPE_DEFAULT.equals(annotation.type())&&annotation.type()!=null){
						String onereg=annotation.type();
						if(value!=null&&!"".equals(value.replace(" ", ""))){
							if(!value.matches(onereg)){
								map.put("第"+baseExcelBean.getRow()+"行的("+field.getAnnotation(Lang.class).value()+")列","：输入的格式不对，不应该是:"+value);
								//return map;	
							}
						}
					}
					//判断是不是数字
					if(Lang.TYPE_ISNUM.equals(annotation.isNum())){
						String onereg="^\\d+$";
						if(value!=null&&!"".equals(value.replace(" ", ""))){
							if(!(value.trim()).matches(onereg)){
								map.put("第"+baseExcelBean.getRow()+"行的("+field.getAnnotation(Lang.class).value()+")列","：输入的格式应该是数字，不应该是:"+value);
								//return map;	
							}
						}
					}
					
					//判断日期是否正常
					if(Lang.TYPE_DATE.equals(annotation.date())){
						String onereg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$"; 
						if(value!=null&&!"".equals(value.replace(" ", ""))){
							if(!value.matches(onereg)){
								map.put("第"+baseExcelBean.getRow()+"行的("+field.getAnnotation(Lang.class).value()+")列","日期格式(eg:19911004,1991-10-04,1991/10/04)，不应该是:"+value);
								//return map;								
							}
						}

					}
					//判断类型是否正确
					if(!Lang.Excel.equals(annotation.toExcle())){
						boolean flag=false;
						StringBuffer buffer=new StringBuffer("");
						if(value!=null&&!"".equals(value.replace(" ", ""))){
							String[] entitys = annotation.toExcle();
							if(entitys!=null&&entitys.length>1){
								for (String entity : entitys) {
									buffer.append(entity).append("、");
									if(value.equals(entity)){
										
										flag=true;
									}
								}
								if(!flag){
									buffer.deleteCharAt(buffer.length()-1);
									map.put("第"+baseExcelBean.getRow()+"行的("+field.getAnnotation(Lang.class).value()+")列","类型应该是："+buffer.toString());
									//return map;
								}
								
							}
						}
						
					}
					
					//类型的指定
					
					
					//判断日期是否正常
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				field.setAccessible(false);
			}
    		
		}
    	
    	
    	return map;
    }

	@Override
	public List<Object> toDBEnity(List lists, Class clazz) {
		//先创建一个保存属性map（注解名，属性对象）
		Map<String, Object> map=new HashMap<String, Object>();
		List<Object> objects=new ArrayList<Object>();
		try {
			//现再创建一个实体对像
			Object object=clazz.newInstance();
			//把实体对象的属性保存到map中
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.getAnnotation(Transform.class)==null){
					continue;
				}
				map.put(field.getAnnotation(Transform.class).name(), field);
			}
			//进行value的的转化
			for (Object excel : lists) {
				if(excel==null){
					continue;
				}
				//取得所有属性
				Field[] declaredFields = excel.getClass().getDeclaredFields();
				for (Field field : declaredFields) {
					//设置可以访问
					field.setAccessible(true);
				    //取得属性的值
					String value=(String) field.get(excel);
					Lang mylang=field.getAnnotation(Lang.class);
					if(mylang==null){
						continue;
					}
					//从map中取得目标对象的对应方法
					Field target=(Field) map.get(mylang.value());
					if(target==null){
						continue;
					}
					//设置目标对象的方法可以访问
					target.setAccessible(true);
					//清空目标对象中属性的值			
					
					Class<?> filedtype=target.getType();
					int index=filedtype.toString().lastIndexOf(".");
					String type=filedtype.toString().substring(index+1, filedtype.toString().length());
					//从注解中取得相应的属性
					Lang lang=field.getAnnotation(Lang.class);
					if(lang==null){
						continue;
					}
					String[] myexcels=lang.toExcle();
					String[] myentity=lang.toEntity();
					//注解类型转换值不为空时
					if(myentity!=null&&myexcels!=null&&myentity.length>0&&myexcels.length>0){
						//查找一个和相同
						for(int i=0;i<myexcels.length;i++){
							if(myexcels[i].equals(value)){
								value=myentity[i];
								break;
							}
						}
					}
					if("String".equals(type)){ //如果转换为字符串
						target.set(object, null);
						target.set(object, value);
					}else if("int".equals(type)||"Integer".equals(type)){
						target.set(object, 0);
						if(value!=null&&!"".equals(value)){
							target.set(object, Integer.parseInt(value));							
						}
					}else if("Timestamp".equals(type)){
						if(value!=null&&!"".equals(value)){							
							String fromat=null;
							String onereg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$"; 
							
							if(value.matches(onereg)){
								if(value.contains("-")){
									fromat="yyyy-MM-dd";									
								}else if(value.contains("/")){
									fromat="yyyy/MM/dd";
								}else{
									fromat="yyyyMMdd";
								}
							}
							if(fromat!=null){
								SimpleDateFormat sdf=new SimpleDateFormat(fromat);
								Date date = sdf.parse(value);
								target.set(object, new Timestamp(date.getTime()));	
							}						
						}
					}
					
					target.setAccessible(false);
					//设置不可以访问
					field.setAccessible(false);
				}
				Method method=object.getClass().getDeclaredMethod("clone", null);
				method.setAccessible(true);
				Object obj=method.invoke(object, null);
				objects.add(obj);				
			}			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objects;
	}


}
