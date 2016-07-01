package com.danco.ems.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Subject;
import com.danco.ems.repository.SubjectRepository;
import com.danco.ems.service.ISubjectService;

@Service
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject getById(int id) {
		return subjectRepository.findOne(id);
	}

	public void save(Subject model) {
		subjectRepository.save(model);
	}

	public void delete(Subject model) {
		subjectRepository.delete(model);
	}

	public void update(Subject model) {
		subjectRepository.save(model);
	}

	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}

	public List<Subject> findSubjectByLecturer(Lecturer lecturer) {
		return subjectRepository.findByLecturer(lecturer);
	}

}
