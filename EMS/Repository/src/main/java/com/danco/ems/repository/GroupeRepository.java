package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Groupe;

@Transactional
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
	Groupe findByTitle(String title);
}
