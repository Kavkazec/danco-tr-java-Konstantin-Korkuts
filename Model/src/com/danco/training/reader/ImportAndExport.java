package com.danco.training.reader;

import java.sql.Connection;
import java.util.List;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;

public class ImportAndExport {
	private ImportAndExportGuests guest;
	private ImportAndExportRooms room;
	private ImportAndExportServices service;
	private ImportAndExportSettlements settlements;

	public ImportAndExportGuests getGuest() {
		if (guest == null) {
			guest = new ImportAndExportGuests();
		}
		return guest;
	}

	public ImportAndExportRooms getRoom() {
		if (room == null) {
			room = new ImportAndExportRooms();
		}
		return room;
	}

	public ImportAndExportServices getService() {
		if (service == null) {
			service = new ImportAndExportServices();
		}
		return service;
	}
	
	public ImportAndExportSettlements getSettlement() {
		if (settlements == null) {
			settlements = new ImportAndExportSettlements();
		}
		return settlements;
	}

	private static ImportAndExport instance;

	public static ImportAndExport getInstance() {
		if (instance == null) {
			instance = new ImportAndExport();
		}
		return instance;
	}

	private ImportAndExport() {

	}

	public void writeToFileGuests(String path) {
		getGuest().writeToFileGuests(path);
	}

	public void writeToFileRooms(String path) {
		getRoom().writeToFileRooms(path);
	}

	public void writeToFileServices(String path) {
		getService().writeToFileServices(path);
	}
	
	public void writeToFileSettlements(String path) {
		getSettlement().writeToFileServices(path);
	}

	public List<Service> readFromFileServices(String path) {
		return getService().readFromFileServices(path);
	}

	public List<Room> readFromFileRooms(String path) {
		return getRoom().readFromFileRooms(path);
	}

	public List<Guest> readFromFileGuests(String path) {
		return getGuest().readFromFileGuests(path);
	}
	public List<Settlement> readFromFileSettlements(String path, Connection con) {
		return getSettlement().readFromFileServices(path, con);
	}
}
