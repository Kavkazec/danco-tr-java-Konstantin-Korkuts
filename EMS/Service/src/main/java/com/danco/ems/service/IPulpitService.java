package com.danco.ems.service;

import com.danco.ems.entity.Pulpit;

public interface IPulpitService extends ICrudService<Pulpit> {

	public Pulpit save(Pulpit pulpit);
}
