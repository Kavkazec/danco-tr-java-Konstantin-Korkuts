package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Subject;
import com.danco.ems.service.ILecturerService;
import com.danco.ems.service.ISubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private ILecturerService lecturerService;
	
	@RequestMapping(value = "/subjects", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Subject> getAllBooks() {
		return subjectService.getAll();
	}
	
	@RequestMapping(value = "/subjects/by/lecturer", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Subject> getSubjectsByLecturer(@RequestParam("id") int id) {
		Lecturer lecturer = lecturerService.getById(id);
		return subjectService.findSubjectByLecturer(lecturer);
	}
	
}
