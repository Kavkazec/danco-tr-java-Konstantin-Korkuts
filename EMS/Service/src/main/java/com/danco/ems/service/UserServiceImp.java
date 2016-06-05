package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.UserRepository;
import com.danco.ems.api.service.IUserService;
import com.danco.ems.entity.User;

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getById(int id) {
		return userRepository.findOne(id);
	}

	public void save(User model) {
		userRepository.save(model);
	}

	public void delete(User model) {
		userRepository.delete(model);
	}

	public void update(User model) {
		userRepository.save(model);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

}
