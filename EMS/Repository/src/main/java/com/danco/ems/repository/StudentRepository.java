package com.danco.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Student;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
