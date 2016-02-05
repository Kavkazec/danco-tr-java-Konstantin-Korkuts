package com.danco.training.controller.utils;

import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.training.entity.GuestModel;

public class PrintGuest {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final String SEPAR = " ; ";
	private InReader reader = new InReader();
	public void printGuests(List<GuestModel> list){
		for(int i = 0; i < list.size(); i++){
			reader.print(list.get(i).getName() + SEPAR + sdf.format(list.get(i).getDateOfAdd())
					+ SEPAR + sdf.format(list.get(i).getDateOfEvi()) + SEPAR);
		}
	}
}
