package com.danco.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.entity.Book;
import com.danco.ems.repository.BookRepository;
import com.danco.ems.service.IBookService;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	private BookRepository bookRepository;

	public Book getById(int id) {
		return bookRepository.findOne(id);
	}

	public void save(Book model) {
		bookRepository.save(model);
	}

	public void delete(Book model) {
		bookRepository.delete(model);
	}

	public void update(Book model) {
		bookRepository.save(model);
	}

	public List<Book> getAll() {
		return bookRepository.findAll();
	}

}
