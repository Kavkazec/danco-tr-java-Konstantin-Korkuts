package com.danco.training.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.annotation.ProcessAnnotation;
import com.danco.training.comparator.FreeRoomCoastComparator;
import com.danco.training.comparator.FreeRoomCopasityComparator;
import com.danco.training.comparator.FreeRoomStarsComparator;
import com.danco.training.comparator.RoomCoastComparator;
import com.danco.training.comparator.RoomCopasityComparator;
import com.danco.training.comparator.RoomStarsCmparator;
import com.danco.training.controller.api.IRoomService;
import com.danco.training.entity.GuestModel;
import com.danco.training.entity.RoomModel;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.properties.init.annotation.InitRoomAnnotation;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.storage.Hotel;



// TODO: Auto-generated Javadoc
/**
 * The Class RoomService.
 */
public class RoomService implements IRoomService{
	private static final Logger logger = Logger.getLogger(RoomService.class);
	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel = Hotel.getInstance();
	
	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	private static final String SEPAR = " ; ";
	
	/**
	 * Instantiates a new room service.
	 */
	
	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public List<RoomModel> printRoom(){
		try{
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Adds the room.
	 *
	 * @param room the room
	 */
	public void addRoom(RoomModel room){
		try{
			hotel.addRoom(room);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Delete room.
	 *
	 * @param room the room
	 */
	public void deleteRoom(int number){
		try{
			hotel.deleteRoom(number);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Delete guest from room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void deleteGuestFromRoom(String name){
		try{
			hotel.deleteGuestFromRoom(name);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Delete all guests from room.
	 *
	 * @param room the room
	 */
	public void deleteAllGuestsFromRoom(int number){
		try{
			hotel.deleteAllGuestFromRoom(number);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Adds the guest in room.
	 *
	 * @param room the room
	 * @param guest the guest
	 */
	public void addGuestInRoom( int number, String name){
		try{
			hotel.addGuestInRoom(number, name);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}	
	}
	
	public void changeRoomsCoast(int number, int coast){
		try{
			for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
			{
				if(number == hotel.getRoom().getListOfNumbers().get(i).getNumber()){
					hotel.getRoom().getListOfNumbers().get(i).setCoast(coast);
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}	
	}
	
	public void changeRoomsStatusRepair(){
		try{
			for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++){
				if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == false){
					hotel.getRoom().getListOfNumbers().get(i).setOnRepair(true);
				} else if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == true){
					hotel.getRoom().getListOfNumbers().get(i).setOnRepair(false);
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Sort by coast free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastFreeRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCoastComparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Sort by copasity free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityFreeRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomCopasityComparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Sort by stars free room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsFreeRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new FreeRoomStarsComparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}	
	}
	
	/**
	 * Sort by coast room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCoastRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCoastComparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}	
	}
	
	/**
	 * Sort by copasity room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByCopasityRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomCopasityComparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}	
	}
	
	/**
	 * Sort by stars room.
	 *
	 * @return the list
	 */
	public List<RoomModel> sortByStarsRoom(){
		try{
			Collections.sort(hotel.getRoom().getListOfNumbers(), new RoomStarsCmparator());
			return hotel.getRoom().getListOfNumbers();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}	
	}
	
	/**
	 * Show free rooms.
	 *
	 * @return the int
	 */
	public int showNumberOfFreeRooms(){
		try{
			for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
				if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == false){
					t += 1;
				}
					
			return t;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}	
	}
	
	/**
	 * Show chek out date.
	 *
	 * @param date the date
	 * @return the list
	 */
	public List<RoomModel> showChekOutDate(Date date){
		try{
			List<RoomModel> list = new ArrayList<RoomModel>();
			for(int i = 0; i < hotel.getRoom().getListOfNumbers().size(); i++)
			{
					for(int j = 0; j < hotel.getRoom().getListOfNumbers().get(i).getGuests().size(); j++)
					{
						if(hotel.getRoom().getListOfNumbers().get(i).getStatus() == true && sdf.format(hotel.getRoom().getListOfNumbers().get(i).getGuests().get(j).getDateOfEvi()).equals(sdf.format(date))){
							list.add(hotel.getRoom().getListOfNumbers().get(i));
						}
					}
			}
			return list;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Show room details.
	 *
	 * @param room the room
	 * @return the string
	 */
	public String showRoomDetails(int number){
		try{
			String str = "";
			for(RoomModel roomMod: hotel.getRoom().getListOfNumbers()){
				if(number == roomMod.getNumber()){
					str = roomMod.getNumber() + SEPAR + roomMod.getCapacity() + SEPAR +
							roomMod.getNumberOfStars() + SEPAR+ 
							roomMod.getCoast() + SEPAR + roomMod.getStatus() +SEPAR
							+ roomMod.getIsOnRepair() + SEPAR;
				}
			}
			return str;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Show price per room.
	 *
	 * @param guest the guest
	 * @return the string
	 */
	public String showPricePerRoom(String name){
		try{
			String str = "Guest " + name  + " must pay ";
			for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
				for(GuestModel guestMod : roomMod.getGuests()){
					if(name.equals(guestMod.getName())){
						long diff = guestMod.getDateOfEvi().getTime() - guestMod.getDateOfAdd().getTime();
						str = str + (diff / (1000L*60L*60L*24L)*roomMod.getCoast()) + "$";
					}
				}
			}
			return str;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Show last three guests.
	 *
	 * @param room the room
	 * @return the string
	 */
	
	public List<GuestModel> showLastThreeGuests(int number){
		try{
			PropertiesReader.getInstance().setProperties();
			List<GuestModel> list = new ArrayList<GuestModel>();
			int numberOfGuest = PropertiesReader.getInstance().getUtil().getRecordNumber();
			for(RoomModel roomMod : hotel.getRoom().getListOfNumbers()){
				if(number == roomMod.getNumber()){
					if(roomMod.getGuests().size() == numberOfGuest){
						for(int i = roomMod.getGuests().size()-numberOfGuest; i < roomMod.getGuests().size(); i++){
							list.add(roomMod.getGuests().get(i));
						}
					} else if(roomMod.getGuests().size() < 3){
						for(int i = 0; i < roomMod.getGuests().size(); i++){
							list.add(roomMod.getGuests().get(i));
						}
					}
				}
			}
			return list;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public void cloneRoom(int number){
		try{
			hotel.cloneRoom(number);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	public void exportRooms(){
		try{
			PropertiesReader.getInstance().setProperties();
			ImportAndExport.getInstance().writeToFileRooms(PropertiesReader.getInstance().getUtil().getCsvPath());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void importRooms(){
		try{
			PropertiesReader.getInstance().setProperties();
			hotel.getRoom().setRooms(ImportAndExport.getInstance().readFromFileRooms(PropertiesReader.getInstance().getUtil().getCsvPath()));
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	public void buildRoomsFromAnnot(){
		PropertiesReader.getInstance().setProperties();
		ProcessAnnotation p = new ProcessAnnotation();
		InitRoomAnnotation r = new InitRoomAnnotation();
		p.procAnnotation(r);
		hotel.getRoom().setRooms(r.soomList());;
	}
}
