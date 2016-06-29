package com.danco.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.danco.ems.entity.Book;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
