package com.danco.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Schedule;
import com.danco.ems.repository.ScheduleRepository;
import com.danco.ems.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	public Schedule getById(int id) {
		return scheduleRepository.findOne(id);
	}

	public Schedule save(Schedule model) {
		return scheduleRepository.saveAndFlush(model);
	}

	public void delete(Schedule model) {
		scheduleRepository.delete(model);
	}

	public void update(Schedule model) {
		scheduleRepository.save(model);
	}

	public List<Schedule> getAll() {
		return scheduleRepository.findAll();
	}

	public List<Schedule> findScheduleByGroupeAndDate(Groupe groupe, Date date) {
		return scheduleRepository.findByGroupeAndDate(groupe, date);
	}

	public List<Schedule> findScheduleByGroupe(Groupe groupe) {
		return scheduleRepository.findByGroupe(groupe);
	}

	public List<Schedule> findScheduleByLecturerAndDate(Lecturer lecturer, Date date) {
		return scheduleRepository.findByLecturerAndDate(lecturer, date);
	}

	public List<Schedule> findScheduleByLecturer(Lecturer lecturer) {
		return scheduleRepository.findByLecturer(lecturer);
	}

}
