package com.danco.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danco.ems.api.repository.BookRepository;
import com.danco.ems.api.service.IBookService;
import com.danco.ems.entity.Book;

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
