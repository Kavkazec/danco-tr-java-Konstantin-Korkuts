package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.StudentRepository;
import com.danco.ems.api.service.IStudentService;
import com.danco.ems.entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student getById(int id) {
		return studentRepository.findOne(id);
	}

	public void save(Student model) {
		studentRepository.save(model);
	}

	public void delete(Student model) {
		studentRepository.delete(model);
	}

	public void update(Student model) {
		studentRepository.save(model);
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

}
