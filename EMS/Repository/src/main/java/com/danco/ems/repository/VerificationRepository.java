package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Verification;

@Transactional
public interface VerificationRepository extends JpaRepository<Verification, Integer> {

}
