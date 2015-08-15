package org.wcy.wee.service;

import java.util.List;

import org.wcy.wee.model.User;

public interface UserService {
	
	
	public List<User> findUserList() throws Exception;
	
	public void updateUserById(int id, User user) throws Exception;
	
	public User findByUserId(int id) throws Exception;

}
