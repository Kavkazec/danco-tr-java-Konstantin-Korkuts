package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.Groupe;
import com.danco.ems.entity.Pulpit;
import com.danco.ems.service.IGroupeService;

@RestController
public class GroupeController {

	@Autowired
	private IGroupeService groupeService;
	
	@RequestMapping(value = "/groupe", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Groupe> getAllGroupes() {
		return groupeService.getAll();

	}
	
	@RequestMapping(value = "/groupe/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Groupe addGroupe(@RequestBody Groupe groupe) {
		System.out.println(groupe.getTitle() + groupe.getPulpit().getTitle());
		Groupe model = groupeService.save(groupe);
		return model;

	}
	
	@RequestMapping(value = "/groupe/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteGroupe(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Groupe groupe = groupeService.getById(id);
		groupeService.delete(groupe);
		return map;

	}
	
	@RequestMapping(value = "/groupe/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateGroupe(@RequestBody Groupe groupe) {
		ModelAndView map = new ModelAndView();
		groupeService.update(groupe);
		return map;

	}
}
