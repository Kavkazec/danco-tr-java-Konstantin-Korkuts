package com.danco.training.initannotation;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.Room;

public class InitRoomAnnotation {
	private static final String ZAP =";";
	@ConfigPropery(cPath = "config.annot", param = "Room.number", type = "int")
	private int number;
	@ConfigPropery(cPath = "config.annot", param = "Room.capacity", type = "int")
	private int capacity;
	@ConfigPropery(cPath = "config.annot", param = "Room.numberOfStars", type = "int")
	private int numberOfStars;
	@ConfigPropery(cPath = "config.annot", param = "Room.coast", type = "int")
	private int coast;	
	@ConfigPropery(cPath = "config.annot", param = "Room.isOnRepair", type = "Boolean")
	private boolean isOnRepair;
	@ConfigPropery(cPath = "config.annot", param = "Room.roomList", type = "List")
	private List<String> roomList = new ArrayList<String>();
	private List<Room> list;
	
	public List<Room> soomList(){
		list = new ArrayList<Room>();
		list.add(new Room(number, capacity, numberOfStars, coast, isOnRepair));
		for(int i = 0; i < roomList.size(); i++){
			String[] str = roomList.get(i).split(ZAP);
			int number = Integer.parseInt(str[0]);
			int capasity = Integer.parseInt(str[1]);
			int numberOfStars = Integer.parseInt(str[2]);
			int coast = Integer.parseInt(str[3]);
			boolean status = Boolean.parseBoolean(str[4]);
			Room rm = new Room(number, capasity, numberOfStars, coast, status);
			list.add(rm);
		}
		return list;
	}
	
}
