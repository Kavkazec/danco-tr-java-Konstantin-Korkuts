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
	public static SettlementDatabaseDao getInsatnce(){
		if(instance == null){
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

	public Map<String, List<Service>> getAllInListGS(Connection connection) throws PersistenceException {
		ResultSet result = null;
		Map<String, List<Service>> map = new LinkedHashMap<String, List<Service>>();
		List<Service> list;
		try (Statement statament = connection.createStatement()) {
			result = statament.executeQuery("SELECT * FROM room_guests;");
			while (result.next()) {
				Settlement settlement = parserRS(connection, result);
				if (map.containsKey(settlement.getGuest().getName())) {
					if (!map.get(settlement.getGuest().getName()).contains(settlement.getService())) {
						map.get(settlement.getGuest().getName()).add(settlement.getService());
					}
				} else {
					list = new ArrayList<Service>();
					list.add(settlement.getService());
					map.put(settlement.getGuest().getName(), list);
				}
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return map;
	}

	public Map<Integer, List<Guest>> getAllInListRG(Connection connection) throws PersistenceException {
		ResultSet result = null;
		Map<Integer, List<Guest>> map = new LinkedHashMap<Integer, List<Guest>>();
		List<Guest> list;
		try (Statement statament = connection.createStatement()) {
			result = statament.executeQuery("SELECT * FROM room_guests;");
			while (result.next()) {
				Settlement settlement = parserRS(connection, result);
				if (map.containsKey(settlement.getRoom().getNumber())) {
					if (!map.get(settlement.getRoom().getNumber()).contains(settlement.getGuest())) {
						map.get(settlement.getRoom().getNumber()).add(settlement.getGuest());
					}
				} else {
					list = new ArrayList<Guest>();
					list.add(settlement.getGuest());
					map.put(settlement.getRoom().getNumber(), list);
				}
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return map;
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
			String sql = "UPDATE room_guests SET room_ID=?, guest_ID=?, service_ID=?, date_arrive=?,"
					+ "date_departure=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getRoom().getId());
			statement.setInt(2, model.getGuest().getId());
			statement.setInt(3, model.getService().getId());
			statement.setDate(4, dateOfArrival);
			statement.setDate(5, dateOfDeparture);
			statement.setInt(6, model.getId());
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
			String sql = "INSERT INTO room_guests (room_ID, guest_ID, service_ID, date_arrive, date_departure)"
					+ " VALUES (?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getRoom().getId());
			statement.setInt(2, model.getGuest().getId());
			statement.setInt(3, model.getService().getId());
			statement.setDate(4, dateOfArrival);
			statement.setDate(5, dateOfDeparture);
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
			settlement = new Settlement(id, room, guest, service, dateOfArrival, dateOfDeparture);
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
		Map<Integer, Service> map = new LinkedHashMap<Integer, Service>();
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT * FROM room_guests WHERE guest_ID='" + guest.getId() + "';";
			result = statament.executeQuery(sql);
			while (result.next()) {
				Settlement settlement = parserRS(con, result);
				if(map.keySet().isEmpty()){
					map.put(settlement.getRoom().getNumber(), settlement.getService());
					finalPrice = settlement.getRoom().getCoast() + settlement.getService().getCoast();
				} else {
					
				}
			}
			
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return finalPrice;
	}

	@Override
	public List<String> servicesAndRoomsPriceSortedByCoast(Connection con) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();;
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT coast, type FROM room_model "
					+ 	"UNION "
					+ 	"SELECT coast, type FROM service_model ORDER BY coast";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1)+"-|-"+result.getString(2));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> servicesAndRoomsPriceSortedByType(Connection con) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();;
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT coast, type FROM room_model "
					+ 	"UNION "
					+ 	"SELECT coast, type FROM service_model ORDER BY type";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1)+"-|-"+result.getString(2));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
		
		
	}
	@Override
	public List<String> listGuestsAndRoomsSortedByName(Connection con) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();;
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT g.guest_name, r.room_number, date_departure  "
					+ 	"FROM room_guests INNER JOIN guest_model g INNER JOIN room_model r "
					+ 	"ON room_guests.guest_ID=g.Id AND room_guests.room_ID=r.Id ORDER BY g.guest_name;";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-" + 
						result.getString(4) + "-|-" + result.getString(5));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> listGuestsAndRoomsSortedByDate(Connection con) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();;
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT g.Id, g.guest_name, r.Id, r.room_number, date_departure  "
					+ 	"FROM room_guests INNER JOIN guest_model g INNER JOIN room_model r "
					+ 	"ON room_guests.guest_ID=g.Id AND room_guests.room_ID=r.Id ORDER BY date_departure;";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-" + 
						result.getString(4) + "-|-" + result.getString(5));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> listGuestServicesSortedByCoast(Connection con, Guest guest) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT s.Id, s.service_name, s.coast ,date_arrive  "
					+ 	"FROM room_guests INNER JOIN service_model s  "
					+ 	"ON room_guests.service_ID=s.Id AND room_guests.guest_ID=" + guest.getId()+ " ORDER BY s.coast;";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-" + 
						result.getString(4));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	@Override
	public List<String> listGuestServicesSortedByDate(Connection con, Guest guest) throws PersistenceException {
		ResultSet result = null;
		List<String> list = new ArrayList<String>();;
		try (Statement statament = con.createStatement()) {
			String sql = "SELECT s.Id, s.service_name, s.coast ,date_arrive  "
					+ 	"FROM room_guests INNER JOIN service_model s  "
					+ 	"ON room_guests.service_ID=s.Id AND room_guests.guest_ID=" + guest.getId()+ " ORDER BY date_arrive;";
			result = statament.executeQuery(sql);
			while (result.next()) {
				list.add(result.getInt(1) + "-|-" + result.getString(2) + "-|-" + result.getInt(3) + "-|-" + 
						result.getString(4));
			}
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

}
