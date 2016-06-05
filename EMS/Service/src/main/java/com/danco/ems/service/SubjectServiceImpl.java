package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.SubjectRepository;
import com.danco.ems.api.service.ISubjectService;
import com.danco.ems.entity.Subject;

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

}
