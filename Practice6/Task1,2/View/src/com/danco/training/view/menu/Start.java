package com.danco.training.view.menu;

import com.danco.training.controller.HotelController;

public class Start {
	public static void main(String[] args){
		HotelController.getInstance().readFromFile();
		MainController mainC = new MainController();
		mainC.run();
		HotelController.getInstance().writeInFile();
	}
}
