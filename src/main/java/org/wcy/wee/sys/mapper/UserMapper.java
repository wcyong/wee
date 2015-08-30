package org.wcy.wee.sys.mapper;

import java.util.List;

import org.wcy.wee.sys.model.User;

public interface UserMapper {

	public User findUserById(int id);
	
	public List<User> findUserList();
	
	public void updateUserById(User user);
	
	
}
