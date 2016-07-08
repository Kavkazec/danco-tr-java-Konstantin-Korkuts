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
import com.danco.ems.entity.Pulpit;
import com.danco.ems.service.IBookService;


@RestController
public class BookController{
	
	@Autowired
	private IBookService bookService;

	@RequestMapping(value = "/book", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Book> getAllBooks() {
		return bookService.getAll();

	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Book getBookById(@PathVariable("id") int id) {
		return bookService.getById(id);

	}
	
	@RequestMapping(value = "/book/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Book addBook(@RequestBody Book book) {
		Book model = bookService.save(book);
		return model;

	}
	
	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE, produces="application/json")
	public @ResponseBody ModelAndView  deleteBook(@RequestParam("id") int id) {
		System.out.println(id);
		ModelAndView map = new ModelAndView();
		Book book = bookService.getById(id);
		bookService.delete(book);
		return map;

	}
	
	@RequestMapping(value = "/book/edit", method = RequestMethod.PUT, produces="application/json")
	public @ResponseBody ModelAndView  updateBook(@RequestBody Book book) {
		ModelAndView map = new ModelAndView();
		bookService.update(book);
		return map;

	}
}
