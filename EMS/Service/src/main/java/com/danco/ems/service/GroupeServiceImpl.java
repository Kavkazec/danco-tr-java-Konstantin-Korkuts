package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.GroupeRepository;
import com.danco.ems.api.service.IGroupeService;
import com.danco.ems.entity.Groupe;

@Service
public class GroupeServiceImpl implements IGroupeService {
	
	@Autowired
	private GroupeRepository groupeRepository;

	public Groupe getById(int id) {
		return groupeRepository.findOne(id);
	}

	public void save(Groupe model) {
		groupeRepository.save(model);
	}

	public void delete(Groupe model) {
		groupeRepository.delete(model);
	}

	public void update(Groupe model) {
		groupeRepository.save(model);
	}

	public List<Groupe> getAll() {
		return groupeRepository.findAll();
	}

}
