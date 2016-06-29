package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByLoginAndPassword(String login, String password);
	
	User findByFullName(String fullName);
}
