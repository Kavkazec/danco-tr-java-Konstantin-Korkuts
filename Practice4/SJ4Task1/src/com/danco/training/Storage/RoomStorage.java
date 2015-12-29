package com.danco.training.Storage;


import java.util.ArrayList;

import com.danco.training.Model.RoomModel;

public class RoomStorage {
	private ArrayList<RoomModel> rooms = new ArrayList<RoomModel>();
	public void addNumber(RoomModel number){
		rooms.add(number);
	}
	
	public ArrayList<RoomModel> getListOfNumbers(){
		return rooms;
	}
	
	private static RoomStorage instance;

	public static RoomStorage getInstance() {
		if (instance == null) {
			instance = new RoomStorage();
		}
		return instance;
	}
	
}
