package com.danco.training.view.util;

import java.util.List;

import com.danco.training.entity.Guest;

public class PrintGuest {
	private static final String SEPAR = " ; ";
	public static void printGuests(List<Guest> list){
		for (Guest guest : list) {
			InReader.print(guest.getId() + SEPAR + guest.getName() + SEPAR + guest.getPassportSeries()
			 + SEPAR + guest.getPassportNumber());
		}
	}
}
