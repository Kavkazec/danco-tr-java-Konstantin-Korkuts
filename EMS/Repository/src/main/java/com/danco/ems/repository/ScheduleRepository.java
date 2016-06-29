package com.danco.ems.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Schedule;

@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	List<Schedule> findByGroupeAndDate(Groupe groupe, Date date);
}
