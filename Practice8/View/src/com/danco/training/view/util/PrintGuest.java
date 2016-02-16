package com.danco.training.view.util;

import java.text.SimpleDateFormat;
import java.util.List;

import com.danco.training.entity.GuestModel;

public class PrintGuest {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private static final String SEPAR = " ; ";
	public static void printGuests(List<GuestModel> list){
		for(int i = 0; i < list.size(); i++){
			InReader.print(list.get(i).getName() + SEPAR + sdf.format(list.get(i).getDateOfAdd())
					+ SEPAR + sdf.format(list.get(i).getDateOfEvi()) + SEPAR);
		}
	}
}
