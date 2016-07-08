package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.entity.Student;
import com.danco.ems.entity.Subject;
import com.danco.ems.service.ILecturerService;

@RestController
public class LecturerController {
	
	@Autowired
	private ILecturerService lecturerService;
	
	@RequestMapping(value = "/lecturer", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Lecturer> getAllLecturers() {
		return lecturerService.getAll();

	}
	
	@RequestMapping(value = "/lecturer/{id}", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody Lecturer getLecturertById(@PathVariable int id) {
		return lecturerService.getById(id);
	}
	
	@RequestMapping(value = "/lecturer/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Lecturer addLecturer(@RequestBody Lecturer lecturer) {
		Lecturer model = lecturerService.save(lecturer);
		return model;

	}
	
	@RequestMapping(value = "/lecturer/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteLecturer(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Lecturer lecturer = lecturerService.getById(id);
		lecturerService.delete(lecturer);
		return map;

	}
	
	@RequestMapping(value = "/lecturer/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateLecturer(@RequestBody Lecturer lecturer) {
		ModelAndView map = new ModelAndView();
		lecturerService.update(lecturer);
		return map;

	}
	
}
