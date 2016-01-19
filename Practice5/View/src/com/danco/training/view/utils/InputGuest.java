package com.danco.training.view.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

import com.danco.training.model.GuestModel;

public class InputGuest {
	public static GuestModel inputGuest(){
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Name:");
			String name = bf.readLine();
			System.out.println("Day of added:");
			int dayOfAdd = Integer.parseInt(bf.readLine());
			System.out.println("Month of added:");
			int montgOfAdd = Integer.parseInt(bf.readLine());
			System.out.println("Year of added:");
			int yearOfAdd = Integer.parseInt(bf.readLine());
			System.out.println("Day of issue:");
			int dayOfIss = Integer.parseInt(bf.readLine());
			System.out.println("Month of issue:");
			int monthOfIss = Integer.parseInt(bf.readLine());
			System.out.println("Year of issue:");
			int yearOfIss = Integer.parseInt(bf.readLine());
			bf.close();
			return new GuestModel(name, new GregorianCalendar(yearOfAdd, montgOfAdd, dayOfAdd), new GregorianCalendar(yearOfIss, monthOfIss, dayOfIss));
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
