package org.wcy.wee.pagehelper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wcy.wee.demo.ssm.mapper.UserMapper;
import org.wcy.wee.demo.ssm.model.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="/spring/applicationContext.xml")
public class TestPager {
	
	@Autowired
	UserMapper userMapper;

	@Test
	public void testPage01() {
		List<User> list = userMapper.findUserList();
		for(User u : list) {
			System.out.println(u.getId()+"-------"+u.getUsername());
		}
	}
	
	@Test
	public void testPage02() {
		PageHelper.startPage(0, 3);
		List<User> list = userMapper.findUserList();
		PageInfo<User> page = new PageInfo<User>(list);
		System.out.println(list.size());
		System.out.println(page.getList().size());
		for(User u : page.getList()) {
			System.out.println(u.getId()+"-------"+u.getUsername());
		}
	}
}
