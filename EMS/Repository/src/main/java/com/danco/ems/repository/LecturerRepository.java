package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.User;

@Transactional
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

	Lecturer findByUser(User user);
}
