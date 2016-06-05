package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.VerificationRepository;
import com.danco.ems.api.service.IVerificationService;
import com.danco.ems.entity.Verification;

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
