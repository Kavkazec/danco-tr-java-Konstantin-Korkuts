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
import com.danco.ems.service.ILecturerService;
import com.danco.ems.service.IScheduleService;
import com.danco.ems.service.IUserService;
import com.danco.ems.util.DateUtil;

@RestController
public class ScheduleController {
	
	private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private IScheduleService scheduleService;
	
	@Autowired
	private IGroupeService groupeService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ILecturerService lecturerService;
	
	@RequestMapping(value = "/schedules", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody List<Schedule> getAllSchedules() {
		return scheduleService.getAll();
	}
	
	@RequestMapping(value = "/schedules/find/by/groupe", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody List<Schedule> findSchedulesByGroupe(@RequestParam("title") String title, @RequestParam("date") String date) throws ParseException {
		System.out.println(title + " " + date.toString());
		Groupe groupe = groupeService.findGroupeByTitle(title);
		List<Schedule> schedules = DateUtil.findSchedulesByDate(scheduleService.findScheduleByGroupe(groupe),SDF.parse(date));
		return schedules;
	}
	
	@RequestMapping(value = "/schedules/find/by/lecturer", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody List<Schedule> findSchedulesByLecturer(@RequestParam("fullName") String fullName, @RequestParam("date") String date) throws ParseException {
		System.out.println(fullName + " " + date.toString());
		User user = userService.findUserByFullName(fullName);
		Lecturer lecturer = lecturerService.findLecturerByUser(user);
		List<Schedule> schedules = DateUtil.findSchedulesByDate(scheduleService.findScheduleByLecturer(lecturer),SDF.parse(date));
		return schedules;
	}
}
