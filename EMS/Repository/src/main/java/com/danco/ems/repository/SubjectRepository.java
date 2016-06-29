package com.danco.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Subject;

@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
