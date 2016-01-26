package com.danco.training.view.menu;

import java.util.Scanner;

public class MainController {
	public void run(){
		Scanner sc = new Scanner(System.in);
		Navigator navigator = new Navigator();
		Builder builder = new Builder();
		builder.buildMenu();
		navigator.setCurrentMenu(builder.getFirstMenu());
		while(navigator.getCurrentMenu() != null){
			navigator.printMenu();
			navigator.navigate(sc.nextInt());			
		}
		sc.close();
	}
}
