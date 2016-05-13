package com.danco.training.api;

import org.hibernate.Session;

import com.danco.training.entity.User;
import com.danco.training.persisexception.PersistenceException;

public interface IUserDao extends ItemDao<User> {

	public User findUser(Session session, String login, String password) throws PersistenceException;
}
