package com.danco.ems.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.danco.ems.entity.Schedule;

public class DateUtil {
	public static List<Schedule> findSchedulesByDate(List<Schedule> schedules, Date date){
		List<Schedule> list = new ArrayList<Schedule>();
		List<Date> dates = new ArrayList<Date>();
		Date dateNow = new Date();
		Date dateNext = new Date();
		dateNow.setTime(date.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateNow);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		dateNext.setTime(calendar.getTimeInMillis());
		for(Schedule schedule : schedules){
			if(dateNow.before(schedule.getDate()) && dateNext.after(schedule.getDate())){
				dates.add(schedule.getDate());
			}
		}
		for (Schedule schedule : schedules) {
			for (Date dateResult : dates) {
				if(schedule.getDate().equals(dateResult)){
					list.add(schedule);
				}
			}
		}
		return list;
	}
}
