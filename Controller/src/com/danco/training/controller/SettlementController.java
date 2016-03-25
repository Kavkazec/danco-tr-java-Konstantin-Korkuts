package com.danco.training.controller;

import java.util.Date;
import java.util.List;
import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.services.api.ISettlementService;

public class SettlementController {
	private ISettlementService setCon;
	
	public SettlementController(ISettlementService setCon){
		this.setCon = setCon;
	}
	
	public Settlement getByIdSettlement(int id) {
		return this.setCon.getByIdSettlement(id);
	}
	
	public List<Settlement> getAll(){
		return this.setCon.getAll();
	}
	public void add(Settlement model){
		this.setCon.add(model);
	}
	public void delete(Settlement model){
		this.setCon.delete(model);
	}
	public void update(Settlement model){
		this.setCon.update(model);
	}
	public List<Room> releasedInTheFuture(Date date){
		return this.setCon.releasedInTheFuture(date);
	}
	public List<Guest> showLastThreeGuest(Room room){
		return this.setCon.showLastThreeGuest(room);
	}
	public int paiForRoom(Guest guest){
		return this.setCon.paiForRoom(guest);
	}
	public int servicesAndRoomsPriceSortedByCoast(){
		return this.setCon.servicesAndRoomsPriceSortedByCoast();
	}
	public int servicesAndRoomsPriceSortedByType(){
		return this.setCon.servicesAndRoomsPriceSortedByType();
	}
	public List<String> listGuestsAndRoomsSortedByName(){
		return this.setCon.listGuestsAndRoomsSortedByName();
	}
	public List<String> listGuestsAndRoomsSortedByDate(){
		return this.setCon.listGuestsAndRoomsSortedByDate();
	}
	public List<Service> listGuestServicesSortedByCoast(Guest guest){
		return this.setCon.listGuestServicesSortedByCoast(guest);
	}
	public List<Service> listGuestServicesSortedByDate(Guest guest){
		return this.setCon.listGuestServicesSortedByDate(guest);
	}
}
