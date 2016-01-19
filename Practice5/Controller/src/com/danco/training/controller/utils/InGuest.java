package com.danco.training.controller.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.danco.training.model.GuestModel;

public class InGuest {
	private static final String DASH = "-";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public GuestModel inputGuest(){
		InReader input = new InReader();
		input.print("Name:");
		String name = input.readStrin();
		input.print("Day of arrival:");
		int dayOfArr = input.readInt();
		input.print("Month of arrival:");
		int monthOfArr = input.readInt();
		input.print("Year of arrival:");
		int yearOfArr = input.readInt();
		input.print("Day of departure:");
		int dayOfDep = input.readInt();
		input.print("Month of departure:");
		int monthOfDep = input.readInt();
		input.print("Year of departure:");
		int yearOfDep = input.readInt();
		String dateOfArr = dayOfArr + DASH + monthOfArr + DASH + yearOfArr;
		String dateOfDep = dayOfDep + DASH + monthOfDep + DASH + yearOfDep;
		GuestModel gm = null;
		try {
			gm = new GuestModel(name, sdf.parse(dateOfArr) , sdf.parse(dateOfDep));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gm;
	}
}
