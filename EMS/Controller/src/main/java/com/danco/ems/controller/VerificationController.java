package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Student;
import com.danco.ems.entity.User;
import com.danco.ems.entity.Verification;
import com.danco.ems.service.IStudentService;
import com.danco.ems.service.IVerificationService;

@RestController
public class VerificationController {

	@Autowired
	private IVerificationService verificationService;
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value = "/verification", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Verification> getAllVerifications() {
		return verificationService.getAll();
	}
	
	@RequestMapping(value = "/verification/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Verification> getAllVerificationsByStudent(@PathVariable int id) {
		Student student = studentService.getById(id);
		return student.getVerifications();
	}
}
