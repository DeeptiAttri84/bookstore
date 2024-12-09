package com.store.bookstore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.bookstore.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll(); 
}
