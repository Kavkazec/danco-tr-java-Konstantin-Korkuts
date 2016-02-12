package com.danco.training.properties.init.annotation;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.RoomModel;

public class InitRoomAnnotation {
	private static final String ZAP =";";
	@ConfigPropery(cPath = "config.annot", param = "RoomModel.number", type = "int")
	private int number;
	@ConfigPropery(cPath = "config.annot", param = "RoomModel.capacity", type = "int")
	private int capacity;
	@ConfigPropery(cPath = "config.annot", param = "RoomModel.numberOfStars", type = "int")
	private int numberOfStars;
	@ConfigPropery(cPath = "config.annot", param = "RoomModel.coast", type = "int")
	private int coast;	
	@ConfigPropery(cPath = "config.annot", param = "RoomModel.roomList", type = "List")
	private List<String> roomList = new ArrayList<String>();
	private List<RoomModel> list;
	
	public List<RoomModel> soomList(){
		list = new ArrayList<RoomModel>();
		list.add(new RoomModel(number, capacity, numberOfStars, coast));
		for(int i = 0; i < roomList.size(); i++){
			String[] str = roomList.get(i).split(ZAP);
			int number = Integer.parseInt(str[0]);
			int capasity = Integer.parseInt(str[1]);
			int numberOfStars = Integer.parseInt(str[2]);
			int coast = Integer.parseInt(str[3]);
			RoomModel rm = new RoomModel(number, capasity, numberOfStars, coast);
			list.add(rm);
		}
		return list;
	}
	
}
