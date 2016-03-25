package com.danco.training.service;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.dao.RoomDao;
import com.danco.training.dao.factory.DaoFactory;
import com.danco.training.dbconnection.ConnectionProvider;
import com.danco.training.entity.Room;
import com.danco.training.persistexception.PersistenceException;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.services.api.IRoomService;



// TODO: Auto-generated Javadoc
/**
 * The Class RoomService.
 */
public class RoomService implements IRoomService{
	private static final Logger LOGGER = Logger.getLogger(RoomService.class);
	private RoomDao roomDao = DaoFactory.getRoomDao();
	private ImportAndExport ie = ImportAndExport.getInstance();
	
	public String getPath(){
		try{
			PropertiesReader prop = PropertiesReader.getInstance();
			prop.setProperties();
			return prop.getUtil().getCsvPath();
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
	
	public Connection getConnection(){
		try {
			return ConnectionProvider.getInstance().getConnection();
		} catch (PersistenceException e) {
			LOGGER.error(e);
			return null;
			
		}
	}
	
	@Override
	public void addRoom(Room room) {
		try{
			roomDao.add(getConnection(), room);
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void deleteRoom(Room room) {
		try{
			roomDao.delete(getConnection(), room);
		} catch(Exception e){
			LOGGER.error(e);
			
		}
	}

	@Override
	public List<Room> sortByCoastFreeRoom() {
		try{
			return roomDao.sortFreeRoomsByCoast(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortByCapacityFreeRoom() {
		try{
			return roomDao.sortFreeRoomsByCapacity(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortByStarsFreeRoom() {
		try{
			return roomDao.sortFreeRoomsByStars(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortByCoastRoom() {
		try{
			return roomDao.sortRoomsByCoast(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortByCapacityRoom() {
		try{
			return roomDao.sortRoomsByCapacity(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> sortByStarsRoom() {
		try{
			return roomDao.sortRoomsByStars(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Room> getRooms() {
		try{
			return roomDao.getAll(getConnection());
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
		
	}

	@Override
	public void cloneRoom(Room model) {
		Room room = null;
		try{
			room = roomDao.getById(getConnection(), model.getId()).clone();
			room.setId(roomDao.findLastId(getConnection()));
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void exportRooms() {
		try{
			ie.writeToFileRooms(getPath());
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void importRooms() {
		try{
			ie.writeToFileRooms(getPath());
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void buildRoomsFromAnnot() {
		try{
			
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void updateRoom(Room room) {
		try{
			roomDao.update(getConnection(), room);
		} catch(Exception e){
			LOGGER.error(e);
		}
	
}

	@Override
	public void changeRoomStatus(Room room) {
		try{
			roomDao.update(getConnection(), room);
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public void changeRoomCoast(Room room) {
		try{
			roomDao.update(getConnection(), room);
		} catch(Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public int numberOfFreeRooms() {
		int count = 0;
		try{
			for(Room room: roomDao.getAll(getConnection())){
				if(room.isFreeRoom()){
					count += 1;
				}
			}
			return count;
		} catch(Exception e){
			LOGGER.error(e);
			return count;
		}
	}

	@Override
	public String showRoomDetails(Room room) {
		String str = "";
		try {
			str = room.getId()+ " " + room.getNumber()+ " " + room.getCapacity()+ " " 
					+ room.getNumberOfStars()+ " " + room.getCoast()+ " " + room.isFreeRoom()+ " " + room.isOnRepair();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
		return str;
	}

	@Override
	public Room getByIdRoom(int id) {
		try{
			return roomDao.getById(getConnection(), id);
		} catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
}
