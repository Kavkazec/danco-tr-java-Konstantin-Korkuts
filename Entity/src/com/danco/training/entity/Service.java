package com.danco.training.entity;

public class Service extends BaseEntity{
	
	private static final long serialVersionUID = -5359549563371459471L;
	private String name;
	private int coast;
	
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
