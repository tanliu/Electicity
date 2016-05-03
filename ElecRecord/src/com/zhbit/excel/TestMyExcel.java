package com.zhbit.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.text.entity.excel.TestEntity;
import com.zhbit.services.system.impl.SystemDllServicesImpl;

public class TestMyExcel {
	
    private static List<TestEntity> getpList(){
        List<TestEntity> list=new ArrayList<TestEntity>();
        list.add(new TestEntity("080105031031", "谭柳","20090501","共青团员",null));
        return list;
    }
	@Test
	public void importExcel() throws FileNotFoundException{
		ExcelConfig config=new ExcelConfig(TestEntity.class,"党团关系",2);
		config.setFio(new FileInputStream("D://党团关系信息表.xls"));
		try {
			List<TestEntity> lists=new ExcelUtil().SimpleImportExcel(config);
			for (TestEntity testEntity : lists) {
				System.out.println("--------------------"+testEntity.getName());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void ex() throws Exception{
		ExcelConfig config=new ExcelConfig(TestEntity.class,"党团关系",2);
		config.setFos(new FileOutputStream("D://tan.xls"));
		config.setEntitys(getpList());
		new ExcelUtil().testSimpleVoExport(config);
		

	}
	
	@Test
	public void tet(){
		System.out.println(SystemDllServicesImpl.class.getCanonicalName());
	}
	
	@Test
	public void te() throws Exception{
		
/*		      ExcelConfig config=new ExcelConfig();
		      config.setClazz(TestEntity.class);
		      String[] list=config.getEntityFiled();
		      for (String string : list) {
				System.out.println(string);
			}*/
		      /* Class clazz=TestEntity.class;
		       //Class clazz=Class.forName(TestEntity.class.getName());
		       //System.out.println(TestEntity.class);
		      // 获取所有的属性名称
				Field[]  fs =  clazz.getDeclaredFields();
				// 遍历：输出每一个属性名称、值
				for (Field f : fs) {
					// 设置强制访问
					f.setAccessible(true);
					
					// 名称
					String name = f.getName();
					

	
					Lang lang=f.getAnnotation(Lang.class);

					if(lang!=null){
						
					System.out.println(name);
                    }
				}*/

	}

}
