package com.danco.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Verification;

public interface VerificationRepository extends JpaRepository<Verification, Integer> {

}
