package com.danco.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.api.IRoomDao;
import com.danco.training.entity.Room;
import com.danco.training.persistexception.PersistenceException;

public class RoomDatabaseDao implements IRoomDao{
	private static final String PARSE_EXCEPTION = "ParseException";
	private static RoomDatabaseDao instance;
	public static RoomDatabaseDao getInsatnce(){
		if(instance == null){
			instance = new RoomDatabaseDao();
		}
		return instance;
	}
	public Room getById(Connection connection, int id) throws PersistenceException{
		ResultSet result = null;
		Room room = null;
		try{
			String sql = "SELECT * FROM room_model WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while(result.next()){
				room = parserRS(result);
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return room;
	}

	@Override
	public List<Room> getAll(Connection connection) throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public void delete(Connection connection, Room model) throws PersistenceException{
		try{
			String sql = "DELETE FROM room_model WHERE Id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getId());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void update(Connection connection, Room model) throws PersistenceException{
		try{
			String sql = "UPDATE room_model SET room_number=?, capasity=?, numberOfStars=?, coast=?,"
					+ "isFreeRoom=?, isOnRepair=? WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getNumber());
			statement.setInt(2, model.getCapacity());
			statement.setInt(3, model.getNumberOfStars());
			statement.setInt(4, model.getCoast());
			statement.setBoolean(5, model.isFreeRoom());
			statement.setBoolean(6, model.isOnRepair());
			statement.setInt(7, model.getId());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public void add(Connection connection, Room model) throws PersistenceException{
		try{
			String sql = "INSERT INTO room_model (room_number, capasity, numberOfStars, coast, isFreeRoom, isOnRepair)"
					+ " VALUES (?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, model.getNumber());
			statement.setInt(2, model.getCapacity());
			statement.setInt(3, model.getNumberOfStars());
			statement.setInt(4, model.getCoast());
			statement.setBoolean(5, model.isFreeRoom());
			statement.setBoolean(6, model.isOnRepair());
			statement.executeUpdate();
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
	}

	@Override
	public Room parserRS(ResultSet result) throws PersistenceException {
		Room room = null;
		try{
				int id = result.getInt("Id");
				int number = result.getInt("room_number");
				int capasity = result.getInt("capasity");
				int numberOfStars = result.getInt("numberOfStars");
				int coast = result.getInt("coast");
				boolean isFreeRoom = result.getBoolean("isFreeRoom");
				boolean isOnRepair = result.getBoolean("isOnRepair");
				room = new Room(id, number, capasity, numberOfStars, coast, isOnRepair);
				room.setFreeRoom(isFreeRoom);
		} catch(Exception ex) {
			 throw new PersistenceException(PARSE_EXCEPTION);
		}
		return room;
	}

	@Override
	public List<Room> sortRoomsByCapacity(Connection connection)  throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model ORDER BY capasity;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public List<Room> sortRoomsByCoast(Connection connection)  throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model ORDER BY coast;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public List<Room> sortRoomsByStars(Connection connection)  throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model ORDER BY numberOfStars;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public List<Room> sortFreeRoomsByCapacity(Connection connection)  throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model WHERE isFreeRoom=true ORDER BY capasity;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public List<Room> sortFreeRoomsByCoast(Connection connection) throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model WHERE isFreeRoom=true ORDER BY coast;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public List<Room> sortFreeRoomsByStars(Connection connection) throws PersistenceException{
		ResultSet result = null;
		List<Room> roomsList = new ArrayList<Room>();
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT * FROM room_model WHERE isFreeRoom=true ORDER BY numberOfStars;");
			while(result.next()){
				roomsList.add(parserRS(result));
			}
		} catch(Exception ex) {
			 throw new PersistenceException(ex);
		}
		return roomsList;
	}

	@Override
	public int findLastId(Connection connection) throws PersistenceException {
		ResultSet result = null;
		try(Statement statament = connection.createStatement()){
			result = statament.executeQuery("SELECT Id FROM room_model;");
			result.last();
			return result.getInt(1)+1;
		} catch(Exception e){
			 throw new PersistenceException("EXCEPTION WHEN SEARCHING LAST ID");
		}
		
	}

}
