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
	public void addServiceToGuest(Guest guest, Service service, Date date);
	public void delete(Settlement model);
	public void update(Settlement model);
	public List<Room> releasedInTheFuture(Date date);
	public List<String> showLastThreeGuest(Room room);
	public int paiForRoom(Guest guest);
	public List<String> servicesAndRoomsPriceSortedBy(String string);
	public List<String> listGuestsAndRoomsSortedBy(String string);
	public List<String> listGuestServicesSortedBy(Guest guest , String string);
	public void exportSettlements();
	public void importSettlements();
	public void moveOutFromRoom(Room room, Guest guest);
}
