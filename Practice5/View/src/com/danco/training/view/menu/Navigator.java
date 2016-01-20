package com.danco.training.view.menu;


public class Navigator {
	private Menu currentMenu = new Menu();

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}
	
	public void navigate(int index){
		if(index < currentMenu.getMenuItems().size() && index >=0){
			currentMenu.getMenuItem(index).doAction();
			setCurrentMenu(currentMenu.getMenuItem(index).getMenu());
		} else {
			setCurrentMenu(null);
		}
	}
	
	public void printMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append(currentMenu.getTitle() + "\n");
		for(MenuItem menuItem : currentMenu.getMenuItems()){
			sb.append(menuItem.getTitle() + "\n");
		}
		System.out.println(sb.toString());
	}
}
