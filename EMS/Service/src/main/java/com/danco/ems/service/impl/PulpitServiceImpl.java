package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.entity.Pulpit;
import com.danco.ems.repository.PulpitRepository;
import com.danco.ems.service.IPulpitService;

@Service
public class PulpitServiceImpl implements IPulpitService {
	
	@Autowired
	private PulpitRepository pulpitRepository;

	public Pulpit getById(int id) {
		return pulpitRepository.findOne(id);
	}

	public Pulpit save(Pulpit model) {
		return pulpitRepository.saveAndFlush(model);
	}

	public void delete(Pulpit model) {
		pulpitRepository.delete(model);
	}

	public void update(Pulpit model) {
		pulpitRepository.save(model);
	}

	public List<Pulpit> getAll() {
		return pulpitRepository.findAll();
	}

}
