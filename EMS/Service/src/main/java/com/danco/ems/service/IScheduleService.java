package com.danco.ems.service;

import java.util.Date;
import java.util.List;

import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Schedule;

public interface IScheduleService extends ICrudService<Schedule> {
	public List<Schedule> findScheduleByGroupeAndDate(Groupe groupe, Date date);
}
