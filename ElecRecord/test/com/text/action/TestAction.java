/**
 * 
 */
package com.text.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhbit.excel.annotation.Lang;

import com.opensymphony.xwork2.ModelDriven;
import com.text.entity.TestUser;
import com.text.entity.excel.TestEntity;
import com.text.entity.excel.UserExcel;
import com.text.services.TestServices;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Transform;
import com.zhbit.entity.Student;
import com.zhbit.entity.excel.BaseExcelBean;
import com.zhbit.entity.excel.StuExcel;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.TestTransform;

import jxl.Sheet;
import jxl.Workbook;

/** 
 * 项目名称：ElecRecord
 * 类名称：TestAction 
 * 类描述： 测试的Action
 * 创建人：坛子
 * 创建时间：2016年4月25日 下午3:23:02
 * 修改人：TanLiu 
 * 修改时间：2016年4月25日 下午3:23:02
 * 修改备注： 
 * @version 
 */
public class TestAction extends BaseAndExcelAction  implements ModelDriven<TestUser> {

	private TestUser user=new TestUser();	
	
	@Resource(name="testServices")
	TestServices testServices;
	
	
	public TestUser getUser() {
		return user;
	}

	public void setUser(TestUser user) {
		this.user = user;
	}


	@Override
	public TestUser getModel() {
		return user;
	}
	
	

	public String login(){
		System.out.println(user.getUsername());
		testServices.test(user);
		return "test";
	}

	public String test(){
		
		return "test";
	}
	
	
	
	public void tt(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestServices testServices=(TestServices) ac.getBean("testServices");
		TestUser user=new TestUser();
		user.setPassword("123546");
		user.setUsername("谭柳333333");
		System.out.println(user.getUsername());
		testServices.test(user);		
	}
	
	public void trasaction(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestServices testServices=(TestServices) ac.getBean("testServices");
		TestUser user=testServices.findUserbyId("8a8fa1e0544d8d9e01544d8da0270000");

		System.out.println(user.getUsername());		
	}

	@Override
	public String listUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 方法描述:
	 * @return
	 */
	@Override
	public String importExcel() {
		try {
			/**
			 * arg01:excel实体
			 * arg02:表名
			 * arg03:表头的位置
			 * arg04:上传文件的输入流
			 * arg05:文件名
			 */
			ExcelConfig config=new ExcelConfig(TestEntity.class, "谭柳", 1, new FileInputStream(excel),excelFileName);
			List<Object> lists=excelServices.parseExcel(config);
			for (Object object : lists) {
				TestEntity testEntity=(TestEntity) object;
				System.out.println(testEntity.getName());
			}
			BaseTransfrom baseTransfrom=new TestTransform();
			baseTransfrom.toDBEntity(lists);
			//baseTransfrom.toExcelObj(lists);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "importExcel";
	}

	@Override
	public void exportExcel() {
		List<TestEntity> list=new ArrayList<TestEntity>();
        list.add(new TestEntity("080105031031", "谭柳","20090501","共青团员",null));
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/x-execl");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+new String("谭柳的文件.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream=response.getOutputStream();
			ExcelConfig config=new ExcelConfig(TestEntity.class, "谭柳", outputStream);
			config.setEntitys(list);
			excelServices.createExcel(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void imp(){
		try {
			InputStream fiS=new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\谭柳的文件.xls"));
			XSSFWorkbook workbook=new XSSFWorkbook(new File("C:\\Users\\Administrator\\Desktop\\入党.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void tr(){
		UserExcel userExcel=new UserExcel();
		userExcel.setId("9527");		
		userExcel.setUsername("谭柳");
		userExcel.setPassword("123456");
		userExcel.setBirth("1994/10/04");
		
		userExcel.setSex("1");
		userExcel.setIn("女");
		
		UserExcel userExcel1=new UserExcel();
		userExcel1.setId("9527");
		userExcel1.setUsername("谭某");
		userExcel1.setPassword("123456");
		userExcel1.setBirth("1994/10/04");
		
		userExcel1.setIn("男");
		
		List<UserExcel> userExcels=new ArrayList<UserExcel>();
		userExcels.add(null);
		userExcels.add(userExcel);
		userExcels.add(userExcel1);
		List<Object> objects=this.tramsform(userExcels,TestUser.class);
		for (Object object : objects) {
			System.out.println(object);
		}
		
		Map<String, String> viladationExcel = viladationExcel(userExcels);
		System.out.println(viladationExcel);
		
		

	}
	
    private Map<String, String> viladationExcel(List list){
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
						String onereg="\\d?";
						if(value!=null&&!"".equals(value.replace(" ", ""))){
							if(!value.matches(onereg)){
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

	private List<Object> tramsform(List lists, Class clazz) {
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
					//从map中取得目标对象的对应方法
					Field target=(Field) map.get(field.getAnnotation(Lang.class).value());
					if(target==null){
						continue;
					}
					//设置目标对象的方法可以访问
					target.setAccessible(true);
					//清空目标对象中属性的值			
					
					Class<?> filedtype=target.getType();
					int index=filedtype.toString().lastIndexOf(".");
					String type=filedtype.toString().substring(index+1, filedtype.toString().length());
					if("String".equals(type)){ //如果转换为字符串
						target.set(object, null);
						target.set(object, value);
					}else if("int".equals(type)||"Integer".equals(type)){
						//从注解中取得相应的属性
						Lang lang=field.getAnnotation(Lang.class);
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

	
	@Test
	public void match(){
		String onereg="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if("817@.com".matches(onereg)){
			System.out.println("------------------");
		}
	}
	
	

	public void te(){
		try {
			FileInputStream fiS=new FileInputStream(new File("D:\\学生基本信息表.xls"));
			ExcelConfig config=new ExcelConfig(StuExcel.class, "学生基本信息", 1,fiS,excelFileName);

			List<Object> objects=paserExcel(config);
			Map<String, String> viladationExcel = viladationExcel(objects);
			System.out.println(viladationExcel);
			List<Object> tramsform = tramsform(objects, Student.class);
			for (Object object : tramsform) {
				System.out.println(object);
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Object> paserExcel(ExcelConfig config) throws Exception {
		
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
				for(int row=config.getStartRow();row<sheet.getRows()+config.getStartRow()-1;row++){
					for(int colum=0;colum<sheet.getColumns();colum++){
						Field field=(Field) Excelmap.get(colum);
						String value=sheet.getCell(colum,row).getContents();
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
	
}
