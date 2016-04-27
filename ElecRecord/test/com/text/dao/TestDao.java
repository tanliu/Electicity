package com.text.dao;

import java.io.Serializable;

import com.text.entity.TestUser;

public interface TestDao {

	public void save(TestUser user);

	public TestUser findUserById(Serializable id);
}
