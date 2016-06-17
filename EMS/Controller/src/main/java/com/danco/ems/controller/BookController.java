package com.danco.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> printWelcome() {
		return bookService.getAll();

	}
}
