package com.danco.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;
}
