package com.danco.ems.api.service;

import java.util.List;

import com.danco.ems.entity.BaseEntity;

public interface ICrudService <T extends BaseEntity> {

	public T getById(int id);
	
	public void save(T model);
	
	public void delete(T model);
	
	public void update(T model);
	
	public List<T> getAll();
}
