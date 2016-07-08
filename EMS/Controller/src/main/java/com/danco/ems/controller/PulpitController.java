package com.danco.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Pulpit;
import com.danco.ems.service.IPulpitService;

@RestController
public class PulpitController {

	@Autowired
	private IPulpitService pulpitService;
	
	@RequestMapping(value = "/pulpit/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Pulpit addPulpit(@RequestBody Pulpit pulpit) {
		Pulpit model = pulpitService.save(pulpit);
		return model;

	}
	
	@RequestMapping(value = "/pulpit/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deletePulpit(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Pulpit pulpit = pulpitService.getById(id);
		pulpitService.delete(pulpit);
		return map;

	}
	
	@RequestMapping(value = "/pulpit/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updatePulpit(@RequestBody Pulpit pulpit) {
		System.out.println(pulpit.getId());
		ModelAndView map = new ModelAndView();
		pulpitService.update(pulpit);
		return map;

	}
	
	@RequestMapping(value = "/pulpit", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Pulpit> getAll() {
		return pulpitService.getAll();

	}
}
