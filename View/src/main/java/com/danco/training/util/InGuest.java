package com.danco.training.util;

import org.apache.log4j.Logger;

import com.danco.training.entity.Guest;

public class InGuest {
	private static final String ID2 = "ID:";
	private static final String PASSPORT_NUMBER = "Passport number:";
	private static final String PASSPORT_SERVIES = "Passport servies:";
	private static final String NAME2 = "Name:";
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	
	public static Guest inputGuest() {
		Guest gm = null;
		try {
			InReader.print(NAME2);
			String name = InReader.readStrin();
			InReader.print(PASSPORT_SERVIES);
			String passSeries = InReader.readStrin();
			InReader.print(PASSPORT_NUMBER);
			int passNumber = InReader.readInt();
			gm = new Guest(name, passSeries, passNumber);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return gm;
	}
	
	public static Guest inputGuestWithID() {
		Guest gm = null;
		try {
			InReader.print(ID2);
			int id = InReader.readInt();
			InReader.print(NAME2);
			String name = InReader.readStrin();
			InReader.print(PASSPORT_SERVIES);
			String passSeries = InReader.readStrin();
			InReader.print(PASSPORT_NUMBER);
			int passNumber = InReader.readInt();
			gm = new Guest(id, name, passSeries, passNumber);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return gm;
	}
}
