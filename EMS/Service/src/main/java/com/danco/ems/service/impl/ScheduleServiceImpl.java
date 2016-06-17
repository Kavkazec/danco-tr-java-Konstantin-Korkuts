package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void save(Schedule model) {
		scheduleRepository.save(model);
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

}
