package com.danco.training.properties.init.annotation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.annotation.ConfigPropery;
import com.danco.training.entity.GuestModel;

public class InitGuestAnnotation {
	private static final Logger LOGGER = Logger.getLogger(InitGuestAnnotation.class);
	private static final String ZAP =";";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	@ConfigPropery(cPath = "config.annot", param = "GuestModel.name", type = "String")
	private String name;
	@ConfigPropery(cPath = "config.annot", param = "GuestModel.dateOfAdd", type = "Date")
	private Date dateOfAdd;
	@ConfigPropery(cPath = "config.annot", param = "GuestModel.dateOfEvi", type = "Date")
	private Date dateOfEvi;
	@ConfigPropery(cPath = "config.annot", param = "GuestModel.guestList", type = "List")
	private List<String> guestList = new ArrayList<String>();
	private List<GuestModel> list;
	
	public List<GuestModel> guestList(){
		list = new ArrayList<GuestModel>();
		list.add(new GuestModel(name, dateOfAdd, dateOfEvi));
		for(int i = 0; i < guestList.size(); i++){
			String[] str = guestList.get(i).split(ZAP);
			String name = str[0];
			Date dAdd = null;
			Date dEvi = null;
			try {
				dAdd = sdf.parse(str[1]);
				dEvi = sdf.parse(str[1]);
			} catch (ParseException e) {
				LOGGER.error(e.getMessage(),e);
			}
			GuestModel gm = new GuestModel(name, dAdd, dEvi);
			list.add(gm);
		}
		return list;
	}
}
