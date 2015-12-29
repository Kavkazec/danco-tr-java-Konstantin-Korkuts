package com.danco.training.Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServiceModel{
	private String name;
	private int coast;
	private GregorianCalendar date;
	public ServiceModel(String name, int coast, GregorianCalendar date) {
		this.name = name;
		this.coast = coast;
		this.date = date;
	}
	public String getName() {
		return name;
	}	
	public int getCoast() {
		return coast;
	}
	public void setCoast(int coast){
		this.coast = coast;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(";");
		sb.append(Integer.toString(coast));
		sb.append(";");
		sb.append(Integer.toString(date.get(Calendar.DATE)));
		sb.append(";");
		sb.append(Integer.toString(date.get(Calendar.MONTH)));
		sb.append(";");
		sb.append(Integer.toString(date.get(Calendar.YEAR)));
		sb.append(";");
		return sb.toString();
	}
}
