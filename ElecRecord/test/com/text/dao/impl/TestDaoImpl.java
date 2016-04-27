package com.text.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.text.dao.TestDao;
import com.text.entity.TestUser;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao{

	@Override
	public void save(TestUser user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public TestUser findUserById(Serializable id) {
		
		return getHibernateTemplate().get(TestUser.class, id);
		
	}

}
