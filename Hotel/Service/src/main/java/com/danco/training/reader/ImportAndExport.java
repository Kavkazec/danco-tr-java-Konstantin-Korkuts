package com.danco.training.reader;

import java.util.List;

import org.hibernate.Session;

import com.danco.training.entity.Guest;
import com.danco.training.entity.Room;
import com.danco.training.entity.Service;
import com.danco.training.entity.Settlement;
import com.danco.training.persisexception.PersistenceException;

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

	public void writeToFileGuests(Session session, String path) throws PersistenceException {
		getGuest().writeToFileGuests(session, path);
	}

	public void writeToFileRooms(Session session, String path) throws PersistenceException {
		getRoom().writeToFileRooms(session, path);
	}

	public void writeToFileServices(Session session, String path) throws PersistenceException {
		getService().writeToFileServices(session, path);
	}
	
	public void writeToFileSettlements(Session session, String path) throws PersistenceException {
		getSettlement().writeToFileServices(session, path);
	}

	public List<Service> readFromFileServices(Session session, String path) throws  PersistenceException {
		return getService().readFromFileServices(session, path);
	}

	public List<Room> readFromFileRooms(Session session, String path) {
		return getRoom().readFromFileRooms(session, path);
	}

	public List<Guest> readFromFileGuests(Session session, String path) {
		return getGuest().readFromFileGuests(session, path);
	}
	public List<Settlement> readFromFileSettlements(String path, Session session) {
		return getSettlement().readFromFileServices(path, session);
	}
}
