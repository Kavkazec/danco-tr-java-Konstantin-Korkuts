package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.danco.ems.entity.Book;
import com.danco.ems.service.IBookService;


@RestController
public class BookController{
	
	@Autowired
	private IBookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Book> getAllBooks() {
		return bookService.getAll();

	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Book getBookById(@PathVariable("id") int id) {
		return bookService.getById(id);

	}
}
