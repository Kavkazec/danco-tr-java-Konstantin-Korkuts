package com.danco.training.dbentity;

public class Guest extends BaseEntity{
	
	private static final long serialVersionUID = -3561715200790747927L;
	private String name;
	private String passportSeries;
	private int passportNumber;
	
	public Guest(){
		super();
	}
	
	public Guest(int id, String name, String passportSeries, int passportNumber){
		super(id);
		this.name = name;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportSeries() {
		return passportSeries;
	}
	public void setPassportSeries(String passportSeries) {
		this.passportSeries = passportSeries;
	}
	public int getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}
}
