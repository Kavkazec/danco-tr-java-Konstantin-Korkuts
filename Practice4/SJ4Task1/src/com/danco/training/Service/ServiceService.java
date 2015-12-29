package com.danco.training.Service;

import com.danco.training.Model.ServiceModel;
import com.danco.training.Storage.Hotel;

public class ServiceService {
	private Hotel hotel;
	public ServiceService(){
		hotel = Hotel.getInstance();
	}
	public void changeStatus(String name,int coast){	
		for(ServiceModel m: hotel.getService().getListOfServices()){
			if(m.getName() == name){
				m.setCoast(coast);
			}
		}	
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(hotel.getService().getListOfServices().size()));
		sb.append(System.lineSeparator());
		for(ServiceModel g:hotel.getService().getListOfServices()){
			g.toString();
			System.lineSeparator();
		}
		return sb.toString();
	}
}
