package com.text.services.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.text.dao.TestDao;
import com.text.dao.impl.TestDaoImpl;
import com.text.entity.TestUser;
import com.text.services.TestServices;


@Service("testServices")
public class TestServicesImpl implements TestServices {

    @Resource
	TestDao testDao;
	
	public TestDao getTestDao() {
		return testDao;
	}
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	@Override
	public void test(TestUser user) {
		
		testDao.save(user);
		int i=1/0;
	}
	@Override
	public TestUser findUserbyId(Serializable id) {

		TestUser user=testDao.findUserById(id);
		TestUser user1=new TestUser();
		user1.setPassword("123546");
		user1.setUsername("谭柳柳柳柳柳柳柳");
		testDao.save(user1);
		return user;
	}
	
	

}
