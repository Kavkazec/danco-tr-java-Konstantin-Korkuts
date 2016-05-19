package com.danco.training.api;

import java.util.List;

import com.danco.training.entity.User;

public interface IUserService {
	public User getByIdUser(int id);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> getUsers();
	public User findUser(String login, String password);
}
