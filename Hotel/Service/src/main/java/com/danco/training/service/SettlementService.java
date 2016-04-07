package com.danco.training.service;

import java.util.ArrayList;
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
	private static final String STRING = " ----- ";
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
			session.getTransaction().commit();
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
			session.getTransaction().commit();
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
			session.getTransaction().commit();
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
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	public List<Room> releasedInTheFuture(Date date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Room> room = null;
		try {
			session.beginTransaction();
			room = dao.releasedInTheFuture(session, date);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return room;
	}

	public List<String> showLastThreeGuest(Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<String> guests = null;
		try {
			session.beginTransaction();
			List<Settlement> list = dao.showLastThreeGuest(session, room);
			guests = new ArrayList<String>();
			if(!list.isEmpty() && (list.size() <= 3)){
				for (int i = list.size() - 1; i >= 0; i--) {
					StringBuilder sb = new StringBuilder();
					sb.append(list.get(i).getGuest().getName());
					sb.append(STRING);
					sb.append(list.get(i).getDateOfArrival());
					guests.add(sb.toString());
				}
			} else if(!list.isEmpty() && (list.size() > 3)){
				for (int i = list.size() - 1; i >= list.size() - 4; i--) {
					StringBuilder sb = new StringBuilder();
					sb.append(list.get(i).getGuest().getName());
					sb.append(STRING);
					sb.append(list.get(i).getDateOfArrival());
					guests.add(sb.toString());
				}
			}
			session.getTransaction().commit();;
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return guests;
	}

	public int paiForRoom(Guest guest) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int resultSum = 0;
		try {
			session.beginTransaction();
			Settlement list = dao.getSettlementByGuest(session, guest);
			resultSum +=list.getRoom().getCoast();
			for (Service serv : list.getServiceList()) {
				resultSum+=serv.getCoast();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return resultSum;
	}

	public Settlement getByIdSettlement(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Settlement settlement = null;
		try {
			session.beginTransaction();
			settlement = dao.getById(session, id);
			session.getTransaction().commit();
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
			session.getTransaction().commit();
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Settlement> settlements = null;
		List<String> list = null;
		try {
			session.beginTransaction();
			settlements =  dao.listGuestsAndRoomsSortedBy(session, string);
			list = new ArrayList<String>();
			for (Settlement settlement : settlements) {
				StringBuilder sb = new StringBuilder();
				sb.append(settlement.getGuest().getName());
				sb.append(STRING);
				sb.append(settlement.getRoom().getNumber());
				sb.append(STRING);
				sb.append(settlement.getDateOfDeparture());
				list.add(sb.toString());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return list;
	}

	public List<String> listGuestServicesSortedBy(Guest guest, String string) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Settlement settlement = null;
		List<Service> services = null;
		List<String> list = null;
		try {
			session.beginTransaction();
			settlement = dao.getSettlementByGuest(session, guest);
			services = dao.listGuestServicesSortedBy(session, settlement, string);
			list = new ArrayList<String>();
			for (Service service : services) {
				list.add(service.getCoast() + STRING +  service.getDate());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
		return list;
	}

	public void addServiceToGuest(Guest guest, Service service, Date date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			service.setSettlement(dao.getSettlementByGuest(session, guest));
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}

	@Override
	public void moveOutFromRoom(Room room, Guest guest) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Settlement settlement = null;
		try {
			session.beginTransaction();
			settlement = dao.getSettlementByGuestAndRoom(session, room, guest);
			settlement.setPaid(true);
			session.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			 if (session != null && session.isOpen()) {
			      session.close();
			 }
		}
	}
}
