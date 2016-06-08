package com.zhbit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//该注解只能用在成员变量上
@Retention(RetentionPolicy.RUNTIME)
public @interface Transform {
	String name();
	String type() default TYPE_String;
	String isNull() default TYPE_ISNULL;
	public final static String TYPE_String="String";
	public final static String TYPE_Date="Date";
	public final static String TYPE_Integer="Integer";
	public final static String TYPE_ISNULL="Null";
	public final static String TYPE_NULL="Nonull";

}
