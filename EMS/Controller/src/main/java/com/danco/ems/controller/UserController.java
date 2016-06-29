package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danco.ems.entity.Book;
import com.danco.ems.entity.User;
import com.danco.ems.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/users/find", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody User findUser(@RequestParam("login") String login, @RequestParam("password") String password) {
		User user = userService.findUserByLoginAndPassword(login, password);
		System.out.println(user.getId());
		return user;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody User getUserById(@PathVariable("id") int id) {
		User user = userService.getById(id);
		return user;

	}
	
}
