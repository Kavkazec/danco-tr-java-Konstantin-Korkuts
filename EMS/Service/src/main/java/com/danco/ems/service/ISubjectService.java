package com.danco.ems.service;

import java.util.List;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Subject;

public interface ISubjectService extends ICrudService<Subject> {
	
	public List<Subject> findSubjectByLecturer(Lecturer lecturer);

}
