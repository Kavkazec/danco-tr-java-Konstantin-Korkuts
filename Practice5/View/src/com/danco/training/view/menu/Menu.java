package com.danco.training.view.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<MenuItem> menuItems = new ArrayList<MenuItem>();
	private String title;
	
	public Menu(){
		
	}
	
	public Menu(String title){
		this.title = title;
	}
	
	public Menu( List<MenuItem> menuItems){
		this.menuItems = menuItems;
	}

	public String getTitle() {
		return title;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public void addMenuItem(MenuItem menuItem){
		menuItems.add(menuItem);
	}
	
	public MenuItem getMenuItem(int menuItem){
		if(menuItem < menuItems.size() && menuItem >=0){
				return menuItems.get(menuItem);
		} else {
			return null;
		}
	}
	
	
}
