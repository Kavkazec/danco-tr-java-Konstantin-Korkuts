package com.danco.training.view.menu;

import com.danco.training.view.action.IAction;

public class MenuItem {
	private IAction action;
	private String title;
	private Menu nextMenu;
	
	public MenuItem(IAction action, String title, Menu nextMenu){
		this.action = action;
		this.title = title;
		this.nextMenu = nextMenu;
	}
	
	public MenuItem(String title, Menu nextMenu){
		this.title = title;
		this.nextMenu = nextMenu;
	}
	
	public void doAction(){
		if(action != null){
			action.execute();
		}
	}
	
	public String getTitle(){
		return title;
	}
	
	public Menu getMenu(){
		return nextMenu;
	}
}
