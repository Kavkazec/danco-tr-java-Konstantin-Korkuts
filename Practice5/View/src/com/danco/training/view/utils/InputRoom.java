package com.danco.training.view.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.danco.training.model.RoomModel;

public class InputRoom {
	public static RoomModel inputRoom(){
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("Number:");
			int number = Integer.parseInt(bf.readLine());
			System.out.println("Capasity:");
			int capasity = Integer.parseInt(bf.readLine());
			System.out.println("Number of stars:");
			int stars = Integer.parseInt(bf.readLine());
			System.out.println("Coast:");
			int coast = Integer.parseInt(bf.readLine());
			return new RoomModel(number, capasity, stars, coast);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
