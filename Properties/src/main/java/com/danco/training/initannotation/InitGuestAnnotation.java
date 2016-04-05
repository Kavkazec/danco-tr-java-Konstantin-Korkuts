package com.danco.training.initannotation;

import java.util.ArrayList;
import java.util.List;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.Guest;

public class InitGuestAnnotation {
	private static final String ZAP =";";
	@ConfigPropery(cPath = "config.annot", param = "Guest.name", type = "String")
	private String name;
	@ConfigPropery(cPath = "config.annot", param = "Guest.passportSeries", type = "String")
	private String passportSeries;
	@ConfigPropery(cPath = "config.annot", param = "Guest.passportNumber", type = "int")
	private int passportNumber;
	@ConfigPropery(cPath = "config.annot", param = "Guest.guestList", type = "List")
	private List<String> guestList = new ArrayList<String>();
	private List<Guest> list;
	
	public List<Guest> guestList(){
		list = new ArrayList<Guest>();
		list.add(new Guest(name, passportSeries, passportNumber));
		for(int i = 0; i < guestList.size(); i++){
			String[] str = guestList.get(i).split(ZAP);
			String name = str[0];
			String pSeries = str[1];
			int pNumber = Integer.parseInt(str[2]);
			Guest gm = new Guest(name, pSeries, pNumber);
			list.add(gm);
		}
		return list;
	}
}
