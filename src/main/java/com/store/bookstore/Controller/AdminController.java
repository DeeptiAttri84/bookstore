// AdminController.java
package com.store.bookstore.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.store.bookstore.Model.Book;
import com.store.bookstore.Service.BookService;  // Ensure this import is correct

import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    Logger logger =LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        try {
            return bookService.getAllBooks();
        } catch (Exception e) {
            // Print the error for debugging
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching books", e);
        }
    }

    @PostMapping("/books")
    public List<Book> addBook(@RequestBody List<Book> book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
    @GetMapping("/testing")
    public String testing() throws FileNotFoundException {
        logger.warn("My first log captured");
        return "Hello, World!";
           // throw new FileNotFoundException("file is not found");
        //return null;
    }        
}
