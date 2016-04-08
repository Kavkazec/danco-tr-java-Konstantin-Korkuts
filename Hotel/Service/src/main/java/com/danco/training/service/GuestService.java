package com.danco.training.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.IGuestDao;
import com.danco.training.api.IGuestService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.properties.HibernateUtil;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */

public class GuestService implements IGuestService{
	private static final Logger LOGGER = Logger.getLogger(GuestService.class);
	private ImportAndExport ie = ImportAndExport.getInstance();
	private IGuestDao dao = (IGuestDao) DependencyInjection.getInstance().getClassInstance(IGuestDao.class);
	
	public String getPath() {
		try {
			PropertiesReader prop = PropertiesReader.getInstance();
			prop.setProperties();
			return prop.getUtil().getCsvPath();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}
	
	public void addGuest(Guest guest) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.add(session, guest);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void deleteGuest(Guest guest) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.delete(session, guest);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void updateGuest(Guest guest) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, guest);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Guest> getGuests() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Guest> guests = null;
		try {
			session.beginTransaction();
			guests = dao.getAll(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return guests;
	}

	public void exportGuests() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.writeToFileGuests(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void importGuests() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.readFromFileGuests(session, getPath());
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public int numberOfGuests() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int count = 0;
		try {
			session.beginTransaction();
			count = dao.getAll(session).size();
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return count;
	}

	public Guest getByIdGuest(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Guest guest = null;
		try {
			session.beginTransaction();
			guest = dao.getById(session, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return guest;
	}

}
