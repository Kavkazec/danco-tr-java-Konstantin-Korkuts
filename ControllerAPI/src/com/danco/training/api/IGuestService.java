package com.danco.training.api;

import java.util.List;

import com.danco.training.entity.Guest;

public interface IGuestService {
	public Guest getByIdGuest(int id);
	public void addGuest(Guest guest);
	public void deleteGuest(Guest guest);
	public void updateGuest(Guest guest);
	public List<Guest> getGuests();
	public int numberOfGuests();
	public void exportGuests();
	public void importGuests();
	public void buildGuestsFromAnnot();
}
