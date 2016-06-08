/**
 * 
 */
package com.text.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhbit.excel.annotation.Lang;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.jmx.snmp.Timestamp;
import com.text.entity.TestUser;
import com.text.entity.excel.TestEntity;
import com.text.entity.excel.UserExcel;
import com.text.services.TestServices;
import com.text.services.impl.TestServicesImpl;
import com.zhbit.action.BaseAction;
import com.zhbit.action.BaseAndExcelAction;
import com.zhbit.annotation.Transform;
import com.zhbit.excel.ExcelConfig;
import com.zhbit.services.ExcelServices;
import com.zhbit.services.ExcelServicesImpl;
import com.zhbit.transform.BaseTransfrom;
import com.zhbit.transform.TestTransform;

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
			//HSSFWorkbook workbook=new HSSFWorkbook(fiS);
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
	
	@Test
	public void tr(){
		UserExcel userExcel=new UserExcel();
		userExcel.setId("9527");
		userExcel.setUsername("谭柳");
		userExcel.setPassword("123456");
		userExcel.setBirth("19941004");
		userExcel.setSex("1");
		userExcel.setIn("2");
		//System.out.println(userExcel.getClass());
		List<UserExcel> userExcels=new ArrayList<UserExcel>();
		userExcels.add(userExcel);
		List<Object> objects=this.tramsform(userExcels,TestUser.class);
	}

	private List<Object> tramsform(List lists, Class clazz) {
		//先创建一个保存属性map（注解名，属性对象）
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			//现再创建一个实体对像
			Object object=clazz.newInstance();
			//把实体对象的属性保存到map中
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				map.put(field.getAnnotation(Transform.class).name(), field);
			}
			//进行value的的转化
			for (Object excel : lists) {
				//取得所有属性
				Field[] declaredFields = excel.getClass().getDeclaredFields();
				for (Field field : declaredFields) {
					//设置可以访问
					field.setAccessible(true);
				    //取得属性的值
					String value=(String) field.get(excel);
					//从map中取得目标对象的对应方法
					Field target=(Field) map.get(field.getAnnotation(Lang.class).value());
					//设置目标对象的方法可以访问
					target.setAccessible(true);
					//清空目标对象中属性的值			
					
					Class<?> filedtype=target.getType();
					int index=filedtype.toString().lastIndexOf(".");
					String type=filedtype.toString().substring(index+1, filedtype.toString().length());
					System.out.println(type);
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
							String onereg = "^\\d{4}-0[1-9]|1[1-2]-0[1-9]|[1-2]\\d|3[0-1]"; 
							String otherreg = "^\\d{4}0[1-9]|1[1-2]0[1-9]|[1-2]\\d|3[0-1]"; 
							if(value.matches(onereg)){
								fromat="yyyy-MM-dd";
							}else if(value.matches(otherreg)){
								fromat="yyyyMMdd";							
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
			}
			
			try {
				
				Method method=object.getClass().getDeclaredMethod("clone", null);
				method.setAccessible(true);
				Object obj=method.invoke(object, null);
				System.out.println(obj);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
