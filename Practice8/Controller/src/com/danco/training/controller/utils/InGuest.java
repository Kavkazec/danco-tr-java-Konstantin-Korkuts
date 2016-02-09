package com.danco.training.controller.utils;

import java.util.Date;

import org.apache.log4j.Logger;

import com.danco.training.entity.GuestModel;

public class InGuest {
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	
	public GuestModel inputGuest() {
		GuestModel gm = null;
		try {
			InReader input = new InReader();
			input.print("Name:");
			String name = input.readStrin();
			input.print("Date of arrival(FORMAT(dd-mm-yyyy)):");
			Date dateArr = input.readDate();
			input.print("Date of departure(FORMAT(dd-mm-yyyy)):");
			Date dateDep = input.readDate();
			gm = new GuestModel(name, dateArr, dateDep);
		} catch (Exception e) {
			LOGGER.error("Date_ERROR");
		}
		return gm;
	}
}
