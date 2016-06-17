package com.danco.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
