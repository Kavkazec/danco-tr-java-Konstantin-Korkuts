package com.danco.ems.service;

import java.util.List;

import com.danco.ems.entity.Student;
import com.danco.ems.entity.Verification;

public interface IVerificationService extends ICrudService<Verification> {
	
	public List<Verification> findVerifiactionsByStudent(Student student);
}
