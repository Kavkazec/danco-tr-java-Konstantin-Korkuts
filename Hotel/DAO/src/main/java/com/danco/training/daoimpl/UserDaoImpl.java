package com.danco.training.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.danco.training.api.IUserDao;
import com.danco.training.entity.User;
import com.danco.training.persisexception.PersistenceException;

public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao {

	public UserDaoImpl(){
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll(Session session) throws PersistenceException {
		List<User> users = new ArrayList<User>();
		try {
			users = session.createCriteria(User.class).list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
		return users;
	}

	public User findUser(Session session, String login, String password) throws PersistenceException {
		try {
			return  (User) session.createCriteria(User.class).
						add(Restrictions.eq("login", login)).
						add(Restrictions.eq("password", password)).uniqueResult();
		} catch (Exception e) {
			throw new PersistenceException(e);
		} 
	}

}
