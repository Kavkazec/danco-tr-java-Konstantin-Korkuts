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
import com.danco.ems.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/user/find", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody User findUser(@RequestParam("login") String login, @RequestParam("password") String password) {
		User user = userService.findUserByLoginAndPassword(login, password);
		System.out.println(user.getId());
		return user;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public @ResponseBody User getUserById(@PathVariable("id") int id) {
		User user = userService.getById(id);
		return user;

	}
	
	@RequestMapping(value = "/use/{id}", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody User updatePassword(@PathVariable int id, @RequestParam("password") String password) {
		System.out.println(password);
		User user = getUserById(id);
		user.setPassword(password);
		return user;
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody User addUser(@RequestBody User user) {
		User model = userService.save(user);
		return model;

	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteUser(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		User user = userService.getById(id);
		userService.delete(user);
		return map;

	}
	
	@RequestMapping(value = "/user/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateUser(@RequestBody User user) {
		ModelAndView map = new ModelAndView();
		userService.update(user);
		return map;

	}
	
}
