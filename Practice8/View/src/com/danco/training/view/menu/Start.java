package com.danco.training.view.menu;

import com.danco.training.seriolize.SeriolizeUtil;

public class Start {
	public static void main(String[] args){
		SeriolizeUtil.getInstance().readFromFile();
		MainController mainC = new MainController();
		mainC.run();
		SeriolizeUtil.getInstance().writeInFile();
	}
}
