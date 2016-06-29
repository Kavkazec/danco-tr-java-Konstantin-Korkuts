package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Lecturer;
import com.danco.ems.service.ILecturerService;

@RestController
public class LecturerController {
	
	@Autowired
	private ILecturerService lecturerService;
	
	@RequestMapping(value = "/lecturers", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<Lecturer> getAllBooks() {
		return lecturerService.getAll();

	}

}
