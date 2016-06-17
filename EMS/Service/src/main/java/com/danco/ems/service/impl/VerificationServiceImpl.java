package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.entity.Verification;
import com.danco.ems.repository.VerificationRepository;
import com.danco.ems.service.IVerificationService;

@Service
public class VerificationServiceImpl implements IVerificationService {
	
	@Autowired
	private VerificationRepository verificationRepository;

	public Verification getById(int id) {
		return verificationRepository.findOne(id);
	}

	public void save(Verification model) {
		verificationRepository.save(model);
	}

	public void delete(Verification model) {
		verificationRepository.delete(model);
	}

	public void update(Verification model) {
		verificationRepository.save(model);
	}

	public List<Verification> getAll() {
		return verificationRepository.findAll();
	}

}