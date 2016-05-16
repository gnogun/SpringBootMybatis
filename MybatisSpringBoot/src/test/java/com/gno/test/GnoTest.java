package com.gno.test;

import org.apache.derby.tools.sysinfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gno.dto.UserT;
import com.gno.main.GnoApplication;
import com.gno.mapper.UserMapper;
import com.gno.mapper.UserMapperr;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GnoApplication.class)
public class GnoTest {
	@Autowired
	private UserMapper userMapper;


	@Autowired
	private UserMapperr userMapperr;
	
	@Before
	public void setUp() {
		UserT entity = new UserT();
		entity.setName("stunstun");
		entity.setPassword("stunstun");

		userMapperr.insertUser(entity);
	}

	@Test
	public void select(){
		UserT returnVal = userMapperr.selectByUserName("stunstun");
		
		System.out.println("!");
	}
}
