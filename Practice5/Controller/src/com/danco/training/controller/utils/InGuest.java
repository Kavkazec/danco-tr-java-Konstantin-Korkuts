package com.danco.training.controller.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.danco.training.logger.Config;
import com.danco.training.model.GuestModel;

public class InGuest {
	private static final String LOGFILE = "log4j.properties";
	private static final Logger LOGGER = Logger.getLogger(InReader.class);
	private static Config config = new Config(LOGFILE);

	public GuestModel inputGuest() {
		GuestModel gm = null;
		try {
			Date gc = new GregorianCalendar().getTime();
			InReader input = new InReader();
			input.print("Name:");
			String name = input.readStrin();
			input.print("Date of arrival(FORMAT(dd-mm-yyyy)):");
			Date dateArr = input.readDate();
			input.print("Date of departure(FORMAT(dd-mm-yyyy)):");
			Date dateDep = input.readDate();
			if (dateArr.after(gc) && dateArr.before(dateDep)) {
				gm = new GuestModel(name, dateArr, dateDep);
			} else if (dateArr.before(gc) || dateDep.after(dateArr)) {
				input.print("Entered date can not be earlier than the current!");
			} 
		} catch (Exception e) {
			LOGGER.error("Date_ERROR");
		}
		return gm;
	}
}
