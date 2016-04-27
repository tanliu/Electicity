package com.text.services;

import java.io.Serializable;

import com.text.entity.TestUser;

public interface TestServices {
	
	public void test(TestUser user);

	public TestUser findUserbyId(Serializable id);

}
