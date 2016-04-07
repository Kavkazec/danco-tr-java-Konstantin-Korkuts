package com.danco.training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="guest_model")
public class Guest extends BaseEntity{
	
	private static final long serialVersionUID = -3561715200790747927L;
	
	@Column(name="guest_name")
	private String name;
	
	@Column(name="passport_series")
	private String passportSeries;
	
	@Column(name="passport_number")
	private int passportNumber;
	
	@OneToMany(targetEntity=com.danco.training.entity.Settlement.class, mappedBy="guest", fetch = FetchType.LAZY)
	private List<Settlement> settlementList = new ArrayList<Settlement>();
	
	public Guest(){
		
	}

	public Guest(String name, String passportSeries, int passportNumber){
		super();
		this.name = name;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
	}
	
	public Guest(int id, String name, String passportSeries, int passportNumber){
		super(id);
		this.name = name;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
	}
	
	public List<Settlement> getSettlementList() {
		return settlementList;
	}

	public void setSettlementList(List<Settlement> settlementList) {
		this.settlementList.addAll(settlementList);
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
