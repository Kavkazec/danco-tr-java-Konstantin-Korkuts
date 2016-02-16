package com.danco.training.view.util;

import java.util.Date;

import org.apache.log4j.Logger;

import com.danco.training.entity.GuestModel;

public class InGuest {
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	
	public static GuestModel inputGuest() {
		GuestModel gm = null;
		try {
			InReader.print("Name:");
			String name = InReader.readStrin();
			InReader.print("Date of arrival(FORMAT(dd-mm-yyyy)):");
			Date dateArr = InReader.readDate();
			InReader.print("Date of departure(FORMAT(dd-mm-yyyy)):");
			Date dateDep = InReader.readDate();
			gm = new GuestModel(name, dateArr, dateDep);
		} catch (Exception e) {
			LOGGER.error("Date_ERROR");
		}
		return gm;
	}
}
