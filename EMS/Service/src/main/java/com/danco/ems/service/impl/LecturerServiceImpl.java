package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.User;
import com.danco.ems.repository.LecturerRepository;
import com.danco.ems.service.ILecturerService;

@Service
public class LecturerServiceImpl implements ILecturerService {
	
	@Autowired
	private LecturerRepository lecturerRepository;

	public Lecturer getById(int id) {
		return lecturerRepository.findOne(id);
	}

	public Lecturer save(Lecturer model) {
		return lecturerRepository.saveAndFlush(model);
	}

	public void delete(Lecturer model) {
		lecturerRepository.delete(model);
	}

	public void update(Lecturer model) {
		lecturerRepository.save(model);
	}

	public List<Lecturer> getAll() {
		return lecturerRepository.findAll();
	}

	public Lecturer findLecturerByUser(User user) {
		return lecturerRepository.findByUser(user);
	}

}
