package com.danco.training.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.entity.Room;
import com.danco.training.service.RoomService;

public class ImportAndExportRooms {
	private static final String SEPAR = " ; ";
	private static final String NEXT_LINE = "\n";
	private static final Logger LOGGER = Logger.getLogger(ImportAndExportRooms.class);
	private RoomService room;
	
	public RoomService getRoom() {
		if(room == null){
			room = new RoomService();
		}
		return room;
	}
	
	public void writeToFileRooms(String path){
		FileWriter fw = null;
		List<Room> list = getRoom().getRooms();
		try {
			fw = new FileWriter(path);
			fw.append(Room.class.getSimpleName());
			fw.append(NEXT_LINE);
			for(int i = 0 ; i < list.size(); i++){
				fw.append(list.get(i).getNumber() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getCapacity() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getNumberOfStars() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).getCoast() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).isFreeRoom() + "");
				fw.append(SEPAR);
				fw.append(list.get(i).isOnRepair() + "");
				fw.append(SEPAR);
				fw.append(NEXT_LINE);
			}
			fw.flush();
		}catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
	}
	
	public List<Room> readFromFileRooms(String path){
		List<String> list = new ArrayList<String>();
		List<Room> rooms = new ArrayList<Room>();
		String line = "";
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			while((line = bf.readLine()) != null){
				list.add(line);
			}
			for(int i = 1; i < list.size(); i++){
				if(Room.class.getSimpleName().equals(list.get(0))){
					String[] arr = list.get(i).split(SEPAR);
					int number = Integer.parseInt(arr[0]);
					int capacity = Integer.parseInt(arr[1]);
					int stars = Integer.parseInt(arr[2]);
					int coast = Integer.parseInt(arr[3]);
					boolean status = Boolean.parseBoolean(arr[4]);
					boolean onRepair = Boolean.parseBoolean(arr[6]);
					Room rm = new Room(number, capacity, stars, coast, status);
					rm.setOnRepair(onRepair);
					if(!equalID(number, rooms)){
						rooms.add(rm);
					}
				}
			}
		}catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);
		} finally{
			try {
				bf.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		return rooms;
	
	}
	
	public boolean equalID(int number, List<Room> list){
		Room rm = null;
		for(Room model: list){
			if(model.getNumber() == number){
				rm = model;
				break;
			}
		}
		if(rm == null){
			return true;
		}
		return false;
		
	}
	
}
