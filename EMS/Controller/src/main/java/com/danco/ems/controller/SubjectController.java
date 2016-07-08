package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Pulpit;
import com.danco.ems.entity.Subject;
import com.danco.ems.service.ILecturerService;
import com.danco.ems.service.ISubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private ILecturerService lecturerService;
	
	@RequestMapping(value = "/subject", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Subject> getAllBooks() {
		return subjectService.getAll();
	}
	
	@RequestMapping(value = "/subject/by/lecturer", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Subject> getSubjectsByLecturer(@RequestParam("id") int id) {
		Lecturer lecturer = lecturerService.getById(id);
		return subjectService.findSubjectByLecturer(lecturer);
	}
	
	@RequestMapping(value = "/subject/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Subject addSubject(@RequestBody Subject subject) {
		System.out.println(subject.getTitle() + subject.getBook());
		Subject model = subjectService.save(subject);
		return model;

	}
	
	@RequestMapping(value = "/subject/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteSubject(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Subject subject = subjectService.getById(id);
		subjectService.delete(subject);
		return map;

	}
	
	@RequestMapping(value = "/subject/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateSubject(@RequestBody Subject subject) {
		System.out.println(subject.getId());
		ModelAndView map = new ModelAndView();
		subjectService.update(subject);
		return map;

	}
	
}
