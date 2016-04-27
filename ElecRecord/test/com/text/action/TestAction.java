/**
 * 
 */
package com.text.action;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.text.entity.TestUser;
import com.text.services.TestServices;

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
public class TestAction extends ActionSupport implements ModelDriven<TestUser> {

	private TestUser user=new TestUser();	
	
	@Resource
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
	
	
	@Test
	public void tt(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestServices testServices=(TestServices) ac.getBean("testServices");
		TestUser user=new TestUser();
		user.setPassword("123546");
		user.setUsername("谭柳333333");
		System.out.println(user.getUsername());
		testServices.test(user);		
	}
	
	
	@Test
	public void trasaction(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestServices testServices=(TestServices) ac.getBean("testServices");
		TestUser user=testServices.findUserbyId("8a8fa1e0544d8d9e01544d8da0270000");

		System.out.println(user.getUsername());		
	}

	
}
