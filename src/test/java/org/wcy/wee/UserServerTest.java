package org.wcy.wee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wcy.wee.mapper.UserMapper;
import org.wcy.wee.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="/spring/applicationContext.xml")
public class UserServerTest extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void test01() {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
	}
}
