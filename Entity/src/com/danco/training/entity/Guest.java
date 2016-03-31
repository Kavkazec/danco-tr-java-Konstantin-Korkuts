package com.danco.training.entity;

import java.util.ArrayList;
import java.util.List;

public class Guest extends BaseEntity{
	
	private static final long serialVersionUID = -3561715200790747927L;
	private String name;
	private String passportSeries;
	private int passportNumber;
	private List<Settlement> settlementList;
	
	

	public Guest(String name, String passportSeries, int passportNumber){
		super();
		this.name = name;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
		this.settlementList = new ArrayList<Settlement>();
	}
	
	public Guest(int id, String name, String passportSeries, int passportNumber){
		super(id);
		this.name = name;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
		this.settlementList = new ArrayList<Settlement>();
	}
	
	public List<Settlement> getSettlementList() {
		return settlementList;
	}

	public void setSettlementList(List<Settlement> settlementList) {
		this.settlementList = settlementList;
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
