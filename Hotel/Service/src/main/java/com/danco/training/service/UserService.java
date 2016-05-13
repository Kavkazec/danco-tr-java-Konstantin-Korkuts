package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IUserDao;
import com.danco.training.api.IUserService;
import com.danco.training.daoimpl.UserDaoImpl;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.User;
import com.danco.training.properties.HibernateUtil;

public class UserService implements IUserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	//private IUserDao dao = (IUserDao) DependencyInjection.getInstance().getClassInstance(IUserDao.class);
	private UserDaoImpl dao = new UserDaoImpl();
	public User getByIdRoom(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
		try {
			session.beginTransaction();
			user = dao.getById(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return user;
	}

	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.add(session, user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.delete(session, user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<User> getUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> users = null;
		try {
			session.beginTransaction();
			users = dao.getAll(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return users;
	}

	public boolean findUser(String login, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean userFindStatus = false;
		User user = null;
		try {
			session.beginTransaction();
			user = dao.findUser(session, login, password);
			userFindStatus = (user != null) ? true : false;
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return userFindStatus;
	}

}
