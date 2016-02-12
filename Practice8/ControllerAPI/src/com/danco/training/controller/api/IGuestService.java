package com.danco.training.controller.api;

import java.util.List;

import com.danco.training.entity.GuestModel;
import com.danco.training.entity.ServiceModel;

public interface IGuestService {
	public void addGuest(GuestModel guest);
	public void deleteGuest(String name);
	public List<GuestModel> sortByNameGuests();
	public List<GuestModel> sortByDateGuests();
	public int showNumberOfGuests();
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name);
	public List<ServiceModel> showGuestsServicesSortedByDate(String name);
	public void addServiceToGuest(String nameGuest, String nameService);
	public List<GuestModel> printGuest();
	public void exportGuests();
	public void importGuests();
	public void buildGuestsFromAnnot();
}
