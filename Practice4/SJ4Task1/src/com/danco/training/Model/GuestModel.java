package com.danco.training.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GuestModel  {
	private int id;
	private String name;
	private GregorianCalendar dateOfAdd;
    private GregorianCalendar dateOfEvi;
	private ArrayList<ServiceModel> services = new ArrayList<ServiceModel>();
	public GuestModel(int id, String name, GregorianCalendar dateOfAdd, GregorianCalendar dateOfEvi){
		this.id = id;
		this.name = name;
		this.dateOfAdd = dateOfAdd;
		this.dateOfEvi = dateOfEvi;
	}
	public String getName() {
		return name;
	}
	public GregorianCalendar getDateOfAdd() {
		return dateOfAdd;
	}
	public GregorianCalendar getDateOfEvi() {
		return dateOfEvi;
	}
	public ArrayList<ServiceModel> getServices() {
		return services;
	}
	public void setServices(ArrayList<ServiceModel> services) {
		this.services = services;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(id));
		sb.append(";");
		sb.append(name);
		sb.append(";");
		sb.append(Integer.toString(dateOfAdd.get(Calendar.DATE)));
		sb.append(",");
		sb.append(Integer.toString(dateOfAdd.get(Calendar.MONTH)));
		sb.append(",");
		sb.append(Integer.toString(dateOfAdd.get(Calendar.YEAR)));
		sb.append(";");
		sb.append(Integer.toString(dateOfEvi.get(Calendar.DATE)));
		sb.append(",");
		sb.append(Integer.toString(dateOfEvi.get(Calendar.MONTH)));
		sb.append(",");
		sb.append(Integer.toString(dateOfEvi.get(Calendar.YEAR)));
		sb.append(";");
		return sb.toString();
	}
}
