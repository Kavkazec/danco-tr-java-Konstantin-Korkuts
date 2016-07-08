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
import com.danco.ems.entity.User;
import com.danco.ems.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Student> getAllStudents() {
		return studentService.getAll();

	}
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Student getStudentById(@PathVariable int id) {
		return studentService.getById(id);
	}
	
	
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody Student updateInterests(@PathVariable int id, @RequestParam("interests") String interests) {
		System.out.println(interests);
		Student student = studentService.getById(id);
		student.setInterests(interests);
		return student;
	}
	
	@RequestMapping(value = "/student/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Student addBook(@RequestBody Student student) {
		Student model = studentService.save(student);
		return model;

	}
	
	@RequestMapping(value = "/student/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteBook(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Student student = studentService.getById(id);
		studentService.delete(student);
		return map;

	}
	
	@RequestMapping(value = "/student/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateBook(@RequestBody Student student) {
		ModelAndView map = new ModelAndView();
		studentService.update(student);
		return map;

	}
	
}
