package org.wcy.wee.demo.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcy.wee.demo.ssm.mapper.UserMapper;
import org.wcy.wee.demo.ssm.model.User;
import org.wcy.wee.demo.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByUserId(int id) throws Exception {
		return userMapper.findUserById(id);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}

	@Override
	public void updateUserById(int id, User user) throws Exception {
		userMapper.updateUserById(user);
	}

}
