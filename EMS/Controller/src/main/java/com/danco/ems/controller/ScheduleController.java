package com.danco.ems.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Lecture;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Schedule;
import com.danco.ems.entity.Subject;
import com.danco.ems.entity.User;
import com.danco.ems.service.IGroupeService;
import com.danco.ems.service.IScheduleService;
import com.danco.ems.service.IUserService;

@RestController
public class ScheduleController {
	
	private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private IScheduleService scheduleService;
	
	@Autowired
	private IGroupeService groupeService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/schedules", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody List<Map<String,Object>> getAllSchedules() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Schedule> all = scheduleService.getAll();
		for (Schedule schedule : all) {
			Map<String,Object> map = new HashMap<String, Object>();
			Groupe groupe = schedule.getGroupe();
			Lecture lecture = schedule.getLecture();
			Subject subject = lecture.getSubject();
			Lecturer lecturer = subject.getLecturer();
			User user = lecturer.getUser();
			map.put("date",schedule.getDate());
			map.put("groupe",groupe.getTitle());
			map.put("subject",subject.getTitle());
			map.put("type",lecture.getType());
			map.put("lecturer",user.getFullName());
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value = "/schedules/find/by/groupe", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody List<Map<String,Object>> findSchedulesByGroupe(@RequestParam("title") String title, @RequestParam("date") String date) throws ParseException {
		System.out.println(title + " " + date.toString());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Schedule> all = findSchedulesByDate(SDF.parse(date));
		for (Schedule schedule : all) {
			Map<String,Object> map = new HashMap<String, Object>();
			Groupe groupe = groupeService.findGroupeByTitle(title);
			if(schedule.getGroupe().equals(groupe)){
				Lecture lecture = schedule.getLecture();
				Subject subject = lecture.getSubject();
				Lecturer lecturer = subject.getLecturer();
				User user = lecturer.getUser();
				map.put("date",schedule.getDate());
				map.put("groupe",groupe.getTitle());
				map.put("subject",subject.getTitle());
				map.put("type",lecture.getType());
				map.put("lecturer",user.getFullName());
				list.add(map);
			}
		}
	
		return list;
	}
	
	@RequestMapping(value = "/schedules/find/by/lecturer", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody List<Map<String,Object>> findSchedulesByLecturer(@RequestParam("fullName") String fullName, @RequestParam("date") String date) throws ParseException {
		System.out.println(fullName + " " + date.toString());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Schedule> all = findSchedulesByDate(SDF.parse(date));
		for (Schedule schedule : all) {
			Map<String,Object> map = new HashMap<String, Object>();
			Groupe groupe = schedule.getGroupe();
			Lecture lecture = schedule.getLecture();
			Subject subject = lecture.getSubject();
			Lecturer lecturer = subject.getLecturer();
			User user = userService.findUserByFullName(fullName);
			if(lecturer.getUser().equals(user)){
				map.put("date",schedule.getDate());
				map.put("groupe",groupe.getTitle());
				map.put("subject",subject.getTitle());
				map.put("type",lecture.getType());
				map.put("lecturer",user.getFullName());
				list.add(map);
			}
		}
	
		return list;
	}
	
	public List<Schedule> findSchedulesByDate(Date date){
		List<Schedule> schedules = new ArrayList<Schedule>();
		List<Date> dates = new ArrayList<Date>();
		Date dateNow = new Date();
		Date dateNext = new Date();
		dateNow.setTime(date.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateNow);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		dateNext.setTime(calendar.getTimeInMillis());
		for(Schedule schedule : scheduleService.getAll()){
			if(dateNow.before(schedule.getDate()) && dateNext.after(schedule.getDate())){
				dates.add(schedule.getDate());
			}
		}
		for (Schedule schedule : scheduleService.getAll()) {
			for (Date dateResult : dates) {
				if(schedule.getDate().equals(dateResult)){
					schedules.add(schedule);
				}
			}
		}
		return schedules;
	}
	
}
