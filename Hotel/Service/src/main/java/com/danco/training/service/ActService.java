package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IActDao;
import com.danco.training.api.IActService;
import com.danco.training.daoimpl.ActDaoImpl;
import com.danco.training.entity.Act;
import com.danco.training.properties.HibernateUtil;

public class ActService implements IActService {
	private static final Logger LOGGER = Logger.getLogger(ActService.class);

	private IActDao dao = new ActDaoImpl();
	
	@Override
	public Act getByIdAct(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Act act = null;
		try {
			session.beginTransaction();
			act = dao.getById(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return act;
	}

	@Override
	public void addAct(Act act) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.add(session, act);
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

	@Override
	public void deleteAct(Act act) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.delete(session, act);
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

	@Override
	public void updateAct(Act act) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, act);
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

	@Override
	public List<Act> getActs() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Act> acts = null;
		try {
			session.beginTransaction();
			acts = dao.getAll(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return acts;
	}

}
