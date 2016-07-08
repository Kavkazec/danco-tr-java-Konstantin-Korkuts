package com.danco.ems.service;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.User;

public interface ILecturerService extends ICrudService<Lecturer> {
		
	public Lecturer findLecturerByUser(User user);

}
