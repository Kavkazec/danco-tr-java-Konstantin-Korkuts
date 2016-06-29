package com.danco.ems.service;

import com.danco.ems.entity.User;

public interface IUserService extends ICrudService<User> {
	
	public User findUserByLoginAndPassword(String login, String password);
	
	public User findUserByFullName(String fullName);
}
