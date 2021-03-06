/*
 * Copyright 2015 www.hyberbin.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Email:hyberbin@qq.com
 */
package org.zhbit.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 *
 * @author Hyberbin
 */
@Target(ElementType.FIELD)//该注解只能用在成员变量上
@Retention(RetentionPolicy.RUNTIME)
public @interface Lang {
    String value();
	String isNull() default TYPE_CANNULL;
	String isNum() default TYPE_NONUM;
	String[] toExcle() default Excel;
	String[] toEntity() default Entity;
	String date() default  TYPE_NODATE;
	String type() default  TYPE_DEFAULT;
	
	
	public final static String TYPE_DEFAULT="DEFAULT";
	public final static String TYPE_TEL="1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
	public final static String TYPE_EMAIL="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	//是不是日期
	public final static String TYPE_DATE="DATE";
	public final static String TYPE_NODATE="NODATE";
	
	public final static String TYPE_CANNULL="Null";
	public final static String TYPE_NONULL="Nonull";
	
	public final static String TYPE_ISNUM="Null";
	public final static String TYPE_NONUM="Nonull";
	
	public final static String Excel="null";
	public final static String Entity="null";
	
	
	
}
