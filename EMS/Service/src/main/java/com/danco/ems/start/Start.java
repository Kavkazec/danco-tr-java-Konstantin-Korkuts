package com.danco.ems.start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Lecture;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Pulpit;
import com.danco.ems.entity.Schedule;
import com.danco.ems.entity.Subject;
import com.danco.ems.entity.User;
import com.danco.ems.entity.UserRole;
import com.danco.ems.service.IGroupeService;
import com.danco.ems.service.ILecturerService;
import com.danco.ems.service.IPulpitService;
import com.danco.ems.service.IScheduleService;
import com.danco.ems.service.ISubjectService;
import com.danco.ems.service.IUserService;
import com.danco.ems.service.impl.BookServiceImpl;
import com.danco.ems.service.impl.GroupeServiceImpl;
import com.danco.ems.service.impl.LecturerServiceImpl;
import com.danco.ems.service.impl.PulpitServiceImpl;
import com.danco.ems.service.impl.ScheduleServiceImpl;
import com.danco.ems.service.impl.SubjectServiceImpl;
import com.danco.ems.service.impl.UserServiceImpl;

public class Start {

	public static void main(String[] args) throws ParseException {
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2016-5-27");
		System.out.println(date.toString());
	}

}
