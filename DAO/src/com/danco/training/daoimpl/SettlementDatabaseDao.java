package com.danco.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danco.training.api.ISettlementDao;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persistexception.PersistenceException;

public class SettlementDatabaseDao implements ISettlementDao {

	private static final String PARSE_EXCEPTION = "ParseException";
	private RoomDatabaseDao rdd = RoomDatabaseDao.getInsatnce();
	private GuestDatabaseDao gdd = GuestDatabaseDao.getInsatnce();
	private ServiceDatabaseDao sdd = ServiceDatabaseDao.getInsatnce();
	private static SettlementDatabaseDao instance;

	public static SettlementDatabaseDao getInsatnce() {
		if (instance == null) {
			instance = new SettlementDatabaseDao();
		}
		return instance;
	}

	public Settlement getById(Connection connection, int id) throws PersistenceException {
		ResultSet result = null;
		Settlement settlement = null;
		try {
			String sql = "SELECT * FROM room_guests WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
				settlement = parserRS(connection, result);

			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return settlement;
	}

	@Override
	public List<Settlement> getAll(Connection connection) throws PersistenceException {
		ResultSet result = null;
		List<Settlement> settlementsList = new ArrayList<Settlement>();
		try (Statement statament = connection.createStatement()) {
			result = statament.executeQuery("SELECT * FROM room_guests;");
			while (result.next()) {
				settlementsList.add(parserRS(connection, result));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return settlementsList;
	}

	public Map<Integer, List<Settlement>> setSetToGuest(Connection connection) throws PersistenceException {
		ResultSet result = null;
		Map<Integer, List<Settlement>> map = new LinkedHashMap<Integer, List<Settlement>>();
		List<Settlement> list;
		try (Statement statament = connection.createStatement()) {
			result = statament.executeQuery("SELECT * FROM room_guests;");
			while (result.next()) {
				Settlement settlement = parserRS(connection, result);
				if (map.containsKey(settlement.getGuest().getId())) {
					if (!map.get(settlement.getGuest().getId()).contains(settlement)) {
						map.get(settlement.getGuest().getId()).add(settlement);
					}
				} else {
					list = new ArrayList<Settlement>();
					list.add(settlement);
					map.put(settlement.getGuest().getId(), list);
				}
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return map;
	}
	
	public void addSetToGuest(Connection connection) throws PersistenceException{
		Set<Integer> keys = setSetToGuest(connection).keySet();
		for (Integer id : keys) {
			Guest guest = gdd.getById(connection, id);
			System.out.println(guest.getName());
			guest.setSettlementList(setSetToGuest(connection).get(id));
			System.out.println(setSetToGuest(connection).get(id).size());
		}
	}

	@Override
	public void delete(Connection connection, Settlement model) throws PersistenceException {
		try {
			String sql = "DELETE FROM room_guests WHERE Id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getId());
			statement.executeUpdate();
			connection.commit();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	@Override
	public void update(Connection connection, Settlement model) throws PersistenceException {
		try {
			java.sql.Date dateOfArrival = new java.sql.Date(model.getDateOfArrival().getTime());
			java.sql.Date dateOfDeparture = new java.sql.Date(model.getDateOfDeparture().getTime());
			java.sql.Date serviceDate = new java.sql.Date(model.getServiceDateOfAdd().getTime());
			String sql = "UPDATE room_guests SET room_ID=?, guest_ID=?, service_ID=?, date_arrive=?,"
					+ "date_departure=? , service_date=?, is_paid=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getRoom().getId());
			statement.setInt(2, model.getGuest().getId());
			statement.setInt(3, model.getService().getId());
			statement.setDate(4, dateOfArrival);
			statement.setDate(5, dateOfDeparture);
			statement.setDate(6, serviceDate);
			statement.setBoolean(7, model.isPaid());
			statement.setInt(8, model.getId());
			statement.executeUpdate();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	@Override
	public void add(Connection connection, Settlement model) throws PersistenceException {
		try {
			java.sql.Date dateOfArrival = new java.sql.Date(model.getDateOfArrival().getTime());
			java.sql.Date dateOfDeparture = new java.sql.Date(model.getDateOfDeparture().getTime());
			String sql = "INSERT INTO room_guests (room_ID, guest_ID, date_arrive, date_departure)"
					+ " VALUES (?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getRoom().getId());
			statement.setInt(2, model.getGuest().getId());
			statement.setDate(3, dateOfArrival);
			statement.setDate(4, dateOfDeparture);
			statement.executeUpdate();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	@Override
	public Settlement parserRS(Connection connection, ResultSet result) throws PersistenceException {
		Settlement settlement = null;
		try {
			int id = result.getInt("Id");
			Room room = rdd.getById(connection, result.getInt("room_ID"));
			Guest guest = gdd.getById(connection, result.getInt("guest_ID"));
			Service service = sdd.getById(connection, result.getInt("service_ID"));
			Date dateOfArrival = result.getDate("date_arrive");
			Date dateOfDeparture = result.getDate("date_departure");
			Date serviceDateOfAdd = result.getDate("service_date");
			boolean isPaid = result.getBoolean("is_paid");
			settlement = new Settlement(id, room, guest, service, dateOfArrival, dateOfDeparture, serviceDateOfAdd,isPaid);
			
		} catch (Exception ex) {
			throw new PersistenceException(PARSE_EXCEPTION);
		}
		return settlement;
	}

	@Override
	public List<Room> releasedInTheFuture(Connection con, Date date) throws PersistenceException {
		ResultSet result = null;
		List<Room> list = null;
		try (Statement statament = con.createStatement()) {
			java.sql.Date dateOfDeparture = new java.sql.Date(date.getTime());
			String sql = "SELECT DISTINCT * FROM room_guests WHERE date_departure='" + dateOfDeparture + "';";
			result = statament.executeQuery(sql);
			list = new ArrayList<Room>();
			while (result.next()) {
				Settlement settlement = parserRS(con, result);
				list.add(settlement.getRoom());
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public int paiForRoom(Connection con, Guest guest) throws PersistenceException {
		int finalPrice = 0;
		ResultSet result = null;
		List<Service> list = new ArrayList<Service>();
		try (Statement statament = con.createStatement()) {
			String sql1 = "SELECT * FROM room_guests WHERE guest_ID=" + guest.getId()
					+ " AND is_paid=false AND service_ID is NULL;";
			String sql2 = "SELECT * FROM room_guests WHERE guest_ID=" + guest.getId()
					+ " AND is_paid=false AND service_ID is NOT NULL;";
			result = statament.executeQuery(sql1);
			while (result.next()) {
				Settlement settlement = parserRS(con, result);
				finalPrice += settlement.getRoom().getCoast();
			}
			result = statament.executeQuery(sql2);
			while (result.next()) {
				Settlement settlement = parserRS(con, result);
				if (settlement != null) {
					list.add(settlement.getService());
				}
			}
			if (!list.isEmpty()) {
				for (Service service : list) {
					finalPrice += service.getCoast();
				}
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return finalPrice;
	}

	@Override
	public List<String> servicesAndRoomsPriceSortedBy(Connection con, String string) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();
		;
		try (Statement statament = con.createStatement()) {
			switch (string) {
			case "type":
				String sql1 = "SELECT coast, type FROM room_model " + "UNION "
						+ "SELECT coast, type FROM service_model ORDER BY type";
				result = statament.executeQuery(sql1);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2));
				}
				break;
			case "coast":
				String sql2 = "SELECT coast, type FROM room_model " + "UNION "
						+ "SELECT coast, type FROM service_model ORDER BY coast";
				result = statament.executeQuery(sql2);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2));
				}
				break;
			default:
				String sql4 = "SELECT coast, type FROM room_model " + "UNION "
						+ "SELECT coast, type FROM service_model";
				result = statament.executeQuery(sql4);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2));
				}
				break;
			}

		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> listGuestsAndRoomsSortedBy(Connection con, String string) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();
		;
		try (Statement statament = con.createStatement()) {
			switch (string) {
			case "name":
				String sql1 = "SELECT g.guest_name, r.room_number, date_departure  "
						+ "FROM room_guests INNER JOIN guest_model g INNER JOIN room_model r "
						+ "ON room_guests.guest_ID=g.Id AND room_guests.room_ID=r.Id ORDER BY g.guest_name;";
				result = statament.executeQuery(sql1);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4) + "-|-" + result.getString(5));
				}
				break;
			case "date":
				String sql2 = "SELECT g.guest_name, r.room_number, date_departure  "
						+ "FROM room_guests INNER JOIN guest_model g INNER JOIN room_model r "
						+ "ON room_guests.guest_ID=g.Id AND room_guests.room_ID=r.Id ORDER BY date_departure;";
				result = statament.executeQuery(sql2);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4) + "-|-" + result.getString(5));
				}
				break;
			default:
				String sql3 = "SELECT g.guest_name, r.room_number, date_departure  "
						+ "FROM room_guests INNER JOIN guest_model g INNER JOIN room_model r "
						+ "ON room_guests.guest_ID=g.Id AND room_guests.room_ID=r.Id;";
				result = statament.executeQuery(sql3);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4) + "-|-" + result.getString(5));
				}
				break;
			}

		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> listGuestServicesSortedBy(Connection con, Guest guest, String string)
			throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();
		;
		try (Statement statament = con.createStatement()) {
			switch (string) {
			case "coast":
				String sql1 = "SELECT s.Id, s.service_name, s.coast ,date_arrive  "
						+ "FROM room_guests INNER JOIN service_model s  "
						+ "ON room_guests.service_ID=s.Id AND room_guests.service_date is NOT NULL AND room_guests.guest_ID=" 
						+ guest.getId() + " ORDER BY s.coast;";
				result = statament.executeQuery(sql1);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4));
				}
				break;
			case "date":
				String sql2 = "SELECT s.Id, s.service_name, s.coast ,date_arrive  "
						+ "FROM room_guests INNER JOIN service_model s  "
						+ "ON room_guests.service_ID=s.Id AND room_guests.service_date is NOT NULL AND room_guests.guest_ID=" 
						+ guest.getId() + " ORDER BY service_date;";
				result = statament.executeQuery(sql2);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4));
				}
				break;
			default:
				String sql = "SELECT s.Id, s.service_name, s.coast ,date_arrive  "
						+ "FROM room_guests INNER JOIN service_model s  "
						+ "ON room_guests.service_ID=s.Id AND room_guests.service_date is NOT NULL AND room_guests.guest_ID=" 
						+ guest.getId() + ";";
				result = statament.executeQuery(sql);
				while (result.next()) {
					list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-"
							+ result.getString(4));
				}
				break;
			}

		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public void addServiceToGuest(Connection connection, Guest guest, Service service, Date date)
			throws PersistenceException {
		try {

			Settlement sett = null;
			for (Settlement s : getAll(connection)) {
				if (s.getGuest().getName().equals(guest.getName()) && !s.isPaid()) {
					sett = s;
				}
			}
			java.sql.Date dateOfArrival = new java.sql.Date(sett.getDateOfArrival().getTime());
			java.sql.Date dateOfDeparture = new java.sql.Date(sett.getDateOfDeparture().getTime());
			java.sql.Date serviceDate = new java.sql.Date(date.getTime());
			String sql = "INSERT INTO room_guests (room_ID, guest_ID, service_ID, date_arrive, date_departure, service_date)"
					+ " VALUES (?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, sett.getRoom().getId());
			statement.setInt(2, sett.getGuest().getId());
			statement.setInt(3, service.getId());
			statement.setDate(4, dateOfArrival);
			statement.setDate(5, dateOfDeparture);
			statement.setDate(6, serviceDate);
			statement.executeUpdate();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
}
