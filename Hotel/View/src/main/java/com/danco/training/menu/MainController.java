package com.danco.training.menu;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.danco.training.util.InReader;

public class MainController {
	private Navigator navigator;
	private Builder builder;
	private boolean exitFlag = false;
	
	public MainController(){
		navigator = new Navigator();
		builder = new Builder();
		builder.buildMenu();
		navigator.setCurrentMenu(builder.getFirstMenu());
	}
	public void run(ObjectOutputStream out, ObjectInputStream in){	
		if(navigator.getCurrentMenu() != null){
			navigator.print();		
		}
		this.exitFlag = !navigator.navigate(InReader.readInt(), in, out);
	}
	public boolean getExitFlag() {
			return exitFlag;
	}
}
