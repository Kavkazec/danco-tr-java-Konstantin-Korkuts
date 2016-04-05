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
			dao.add(session, guest);
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
			dao.delete(session, guest);
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
			dao.update(session, guest);
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
		try {
			return dao.getAll(session);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}

	}

	public void exportGuests() {
		try {
			ie.writeToFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void importGuests() {
		try {
			ie.readFromFileGuests(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public int numberOfGuests() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getAll(session).size();
		} catch (Exception e) {
			LOGGER.error(e);
			return 0;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public Guest getByIdGuest(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return dao.getById(session, id);
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

}
