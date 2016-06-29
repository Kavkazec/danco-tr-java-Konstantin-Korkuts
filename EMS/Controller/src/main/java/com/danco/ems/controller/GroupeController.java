package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Groupe;
import com.danco.ems.service.IGroupeService;

@RestController
public class GroupeController {

	@Autowired
	private IGroupeService groupeService;
	
	@RequestMapping(value = "/groupes", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Groupe> getAllGroupes() {
		return groupeService.getAll();

	}
}
