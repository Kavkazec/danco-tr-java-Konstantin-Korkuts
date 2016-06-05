package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.PulpitRepository;
import com.danco.ems.api.service.IPulpitService;
import com.danco.ems.entity.Pulpit;

@Service
public class PulpitServiceImpl implements IPulpitService {
	
	@Autowired
	private PulpitRepository pulpitRepository;

	public Pulpit getById(int id) {
		return pulpitRepository.findOne(id);
	}

	public void save(Pulpit model) {
		pulpitRepository.save(model);
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
