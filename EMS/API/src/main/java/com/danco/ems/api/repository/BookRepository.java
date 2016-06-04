package com.danco.ems.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danco.ems.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
