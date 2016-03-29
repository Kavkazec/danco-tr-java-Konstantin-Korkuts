package com.danco.training.api;

import java.util.Date;
import java.util.List;

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
	public List<String> servicesAndRoomsPriceSortedByCoast();
	public List<String> servicesAndRoomsPriceSortedByType();
	public List<String> listGuestsAndRoomsSortedByName();
	public List<String> listGuestsAndRoomsSortedByDate();
	public List<String> listGuestServicesSortedByCoast(Guest guest);
	public List<String> listGuestServicesSortedByDate(Guest guest);
	public void exportSettlements();
	public void importSettlements();
}
