package com.danco.training.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 7540414137833810795L;
	private int id;
	
	public BaseEntity(){
		
	}
	
	public BaseEntity(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}