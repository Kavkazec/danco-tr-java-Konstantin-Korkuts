package com.danco.training.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 7540414137833810795L;
	 @Id
     @Column
     @GeneratedValue(strategy = GenerationType.IDENTITY)
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