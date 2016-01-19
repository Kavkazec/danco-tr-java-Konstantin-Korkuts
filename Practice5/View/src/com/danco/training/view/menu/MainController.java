package com.danco.training.view.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {
	public void run(){
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Navigator navigator = new Navigator();
		Builder.buildMenu();
		navigator.setCurrentMenu(Builder.getFirstMenu());
		while(navigator.getCurrentMenu() != null){
			navigator.printMenu();
			try {
				navigator.navigate(Integer.parseInt(bf.readLine()));			
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
