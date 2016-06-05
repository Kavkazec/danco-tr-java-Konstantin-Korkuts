package com.danco.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
