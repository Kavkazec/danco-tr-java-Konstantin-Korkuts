package com.danco.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
