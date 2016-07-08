package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.User;
import com.danco.ems.repository.UserRepository;
import com.danco.ems.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	public User getById(int id) {
		return userRepository.findOne(id);
	}

	public User  save(User model) {
		return userRepository.saveAndFlush(model);
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

	public User findUserByLoginAndPassword(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}

	public User findUserByFullName(String fullName) {
		return userRepository.findByFullName(fullName);
	}

}
