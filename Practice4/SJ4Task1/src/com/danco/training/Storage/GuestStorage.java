package com.danco.training.Storage;

import java.util.ArrayList;

import com.danco.training.Model.GuestModel;

public class GuestStorage {
	private ArrayList<GuestModel> guests = new ArrayList<GuestModel>();
	public ArrayList<GuestModel> getGuests() {
		return guests;
	}
	public void addGuests(GuestModel guest) {
		guests.add(guest);
	}
	private static GuestStorage instance;

	public static GuestStorage getInstance() {
		if (instance == null) {
			instance = new GuestStorage();
		}
		return instance;
	}
	
}
