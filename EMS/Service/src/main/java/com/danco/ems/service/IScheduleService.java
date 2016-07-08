package com.danco.ems.service;

import java.util.Date;
import java.util.List;

import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Schedule;

public interface IScheduleService extends ICrudService<Schedule> {
	public List<Schedule> findScheduleByGroupeAndDate(Groupe groupe, Date date);
	
	public List<Schedule> findScheduleByGroupe(Groupe groupe);
	
	public List<Schedule> findScheduleByLecturerAndDate(Lecturer lecturer, Date date);
	
	public List<Schedule> findScheduleByLecturer(Lecturer lecturer);
}
