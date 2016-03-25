package com.danco.training.services.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public interface ISettlementService {
	public Settlement getByIdSettlement(int id);
	public List<Settlement> getAll();
	public void add(Settlement model);
	public void delete(Settlement model);
	public void update(Settlement model);
	public List<Room> releasedInTheFuture(Date date);
	public List<Guest> showLastThreeGuest(Room room);
	public int paiForRoom(Guest guest);
	public int servicesAndRoomsPriceSortedByCoast();
	public int servicesAndRoomsPriceSortedByType();
	public List<String> listGuestsAndRoomsSortedByName();
	public List<String> listGuestsAndRoomsSortedByDate();
	public List<Service> listGuestServicesSortedByCoast(Guest guest);
	public List<Service> listGuestServicesSortedByDate(Guest guest);
}
