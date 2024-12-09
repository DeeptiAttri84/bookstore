// BookService.java
package com.store.bookstore.Service;  // Ensure this is the correct package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.bookstore.Model.Book;
import com.store.bookstore.Model.BorrowRecord;
//import com.store.bookstore.Model.BorrowRecord;
import com.store.bookstore.Repository.BookRepository;
import com.store.bookstore.Repository.BorrowRecordRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRecordRepository borrowRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> addBook(List<Book> book) {
        return bookRepository.saveAll(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getByBookid(String id) {
       return bookRepository.findById(Long.valueOf(id)).get();
    }

    public Book borrowbook(String id) {
        Book book = bookRepository.findById(Long.valueOf(id)).get();
if (book.getAvailableCopies()>0){
    book.setAvailableCopies(book.getAvailableCopies()-1);
    bookRepository.save(book);
    return book;
   
}
return null;

    }

    /*public static BorrowRecord returnBook(Long recordId) {
    
       
    }

    public List<BorrowRecordRepository> getUserBorrowRecords(Long userId) {
        
    }

    public static BorrowRecord borrowBook(BorrowRecord record) {
       
      
    }
    */
}
