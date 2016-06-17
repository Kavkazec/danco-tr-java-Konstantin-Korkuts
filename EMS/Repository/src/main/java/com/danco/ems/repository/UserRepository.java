package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
