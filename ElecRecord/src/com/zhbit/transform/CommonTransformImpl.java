/**
 * 
 */
package com.zhbit.transform;

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

import org.springframework.stereotype.Component;
import org.zhbit.excel.annotation.Lang;

import com.zhbit.annotation.Transform;

/**
 * 项目名称：ElecRecord 类名称：CommonTransformImpl 类描述： 通用数据转接的接口实现类 创建人：谭柳
 * 创建时间：2016年6月8日 下午10:35:59 修改人：TanLiu 修改时间：2016年6月8日 下午10:35:59 修改备注：
 * 
 * @version
 */
@Component(value=CommonTransform.TRANSFORM_NAME)
public class CommonTransformImpl implements CommonTransform {

	/*
	 * 方法描述:
	 * 
	 * @see com.zhbit.transform.CommonTransform#toDBEnity(java.util.List,
	 * java.lang.Class)
	 */
	@Override
	public List<Object> toDBEnity(List lists, Class clazz) {
		// 先创建一个保存属性map（注解名，属性对象）
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> objects = new ArrayList<Object>();
		try {
			// 现再创建一个实体对像
			Object object = clazz.newInstance();
			// 把实体对象的属性保存到map中
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.getAnnotation(Transform.class)==null){
					continue;
				}
				map.put(field.getAnnotation(Transform.class).name(), field);
			}
			// 进行value的的转化
			for (Object excel : lists) {
				if (excel == null) {
					continue;
				}
				// 取得所有属性
				Field[] declaredFields = excel.getClass().getDeclaredFields();
				for (Field field : declaredFields) {
					// 设置可以访问
					field.setAccessible(true);
					// 取得属性的值
					String value = (String) field.get(excel);
					// 从map中取得目标对象的对应方法
					Field target = (Field) map.get(field.getAnnotation(Lang.class).value());
					if (target == null) {
						continue;
					}
					// 设置目标对象的方法可以访问
					target.setAccessible(true);
					// 清空目标对象中属性的值

					Class<?> filedtype = target.getType();
					int index = filedtype.toString().lastIndexOf(".");
					String type = filedtype.toString().substring(index + 1, filedtype.toString().length());
					if ("String".equals(type)) { // 如果转换为字符串
						target.set(object, null);
						target.set(object, value);
					} else if ("int".equals(type) || "Integer".equals(type)) {
						// 从注解中取得相应的属性
						Lang lang = field.getAnnotation(Lang.class);
						String[] myexcels = lang.toExcle();
						String[] myentity = lang.toEntity();
						// 注解类型转换值不为空时
						if (myentity != null && myexcels != null && myentity.length > 0 && myexcels.length > 0) {
							// 查找一个和相同
							for (int i = 0; i < myexcels.length; i++) {
								if (myexcels[i].equals(value)) {
									value = myentity[i];
									break;
								}
							}
						}
						target.set(object, 0);
						if (value != null && !"".equals(value)) {
							target.set(object, Integer.parseInt(value));
						}
					} else if ("Timestamp".equals(type)) {
						if (value != null && !"".equals(value)) {
							String fromat = null;
							String onereg = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";

							if (value.matches(onereg)) {
								if (value.contains("-")) {
									fromat = "yyyy-MM-dd";
								} else if (value.contains("/")) {
									fromat = "yyyy/MM/dd";
								} else {
									fromat = "yyyyMMdd";
								}
							}
							if (fromat != null) {
								SimpleDateFormat sdf = new SimpleDateFormat(fromat);
								Date date = sdf.parse(value);
								target.set(object, new Timestamp(date.getTime()));
							}
						}
					}

					target.setAccessible(false);
					// 设置不可以访问
					field.setAccessible(false);
				}
				Method method = object.getClass().getDeclaredMethod("clone", null);
				method.setAccessible(true);
				Object obj = method.invoke(object, null);
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
