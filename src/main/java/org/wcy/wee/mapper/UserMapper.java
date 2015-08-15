package org.wcy.wee.mapper;

import java.util.List;

import org.wcy.wee.model.User;

public interface UserMapper {

	public User findUserById(int id);
	
	public List<User> findUserList();
	
	public void updateUserById(User user);
	
	
}
