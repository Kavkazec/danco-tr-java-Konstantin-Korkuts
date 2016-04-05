package com.danco.training.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.training.api.ISettlementDao;
import com.danco.training.api.ISettlementService;
import com.danco.training.di.DependencyInjection;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.properties.HibernateUtil;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;

public class SettlementService implements ISettlementService {
	private static final Logger LOGGER = Logger.getLogger(RoomService.class);
	private ISettlementDao dao = (ISettlementDao) DependencyInjection.getInstance().getClassInstance(ISettlementDao.class);
	private ImportAndExport ie = ImportAndExport.getInstance();

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

	public List<Settlement> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Settlement> settlements = null;
		try {
			session.beginTransaction();
			settlements = dao.getAll(session);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return settlements;
	}

	public void add(Settlement model) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.add(session, model);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void delete(Settlement model) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.delete(session, model);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public void update(Settlement model) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			dao.update(session, model);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Room> releasedInTheFuture(Date date) {
		
		return null;
	}

	public List<Guest> showLastThreeGuest(Room room) {
		
		return null;
	}

	public int paiForRoom(Guest guest) {
		return 0;
		
	}

	public Settlement getByIdSettlement(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Settlement settlement = null;
		try {
			session.beginTransaction();
			settlement = dao.getById(session, id);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
			
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return settlement;
	}

	public void exportSettlements() {
		try {
			ie.writeToFileSettlements(getPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public void importSettlements() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ie.readFromFileSettlements(getPath(), session);
			session.getTransaction();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<String> servicesAndRoomsPriceSortedBy(String string) {
		return null;
	}

	public List<String> listGuestsAndRoomsSortedBy(String string) {
		return null;
	}

	public List<String> listGuestServicesSortedBy(Guest guest, String string) {
		return null;
	}

	public void addServiceToGuest(Guest guest, Service service, Date date) {
		
	}
}
