package com.danco.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="service_model")
public class Service extends BaseEntity{
	
	private static final long serialVersionUID = -5359549563371459471L;
	
	@Column(name="service_name")
	private String name;
	
	@Column
	private int coast;
	
	@Column
	private String type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_guests_id")
	private Settlement settlement;
	
	@Column(name="service_date")
	private Date date;
	
	public Service(){
		
	}
	
	public Service(String name, int coast){
		super();
		this.name = name;
		this.coast = coast;
	}
	
	public Service(int id, String name, int coast){
		super(id);
		this.name = name;
		this.coast = coast;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Settlement getSettlement() {
		return settlement;
	}

	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCoast() {
		return coast;
	}
	public void setCoast(int coast) {
		this.coast = coast;
	}
}
