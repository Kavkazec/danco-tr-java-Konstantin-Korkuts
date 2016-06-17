package com.danco.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
